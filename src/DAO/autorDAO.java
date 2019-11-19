/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Paulo
 */
public class autorDAO {

    private final static autorDAO INSTANCE = new autorDAO();
    private Statement stmt;

    private ArrayList<autor> arrayAutor;
    private Connection connection;
    private final String UPDATE = "UPDATE autor SET "
            + "nomea = ?, "
            + "biografia = ?,"
            + "WHERE codigo_autor = ?";
    private final String INSERT = "INSERT INTO autor "
            + "(nomea, biografia)"
            + " VALUES (?, ?)";

    /**
     * Constructor autorDAO.
     */
    public autorDAO() {
        connection = ConnectionBD.getConnection();
        try {
            stmt = Objects.requireNonNull(ConnectionBD.getConnection()).createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        arrayAutor = new ArrayList<>();
    }

    /**
     * Get unique instance of autorDAO.
     *
     * @return
     */
    public static autorDAO getINSTANCE() {
        return INSTANCE;
    }

    /**
     * Import all autorDAO from BD.
     */
    public void importAutores() {
        try {
            Statement stmt = Objects.requireNonNull(ConnectionBD.getConnection()).createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM autor");
            while (rs.next()) {
                int codigo_autor = rs.getInt("codigo_autor");
                String nomea = rs.getString("nomea");
                String biografia = rs.getString("biografia");
                System.out.println("\n");
                String info = "codigo_autor: " + codigo_autor
                        + "\nnomea: " + nomea
                        + "\nbiografia: " + biografia;
                System.out.println(info);
                try {
                } catch (Exception e) {
                    System.out.println("Já existe: \n" + info);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get from codigo_autor.
     */
    public autor get(int codigo_autor) throws Exception {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM autor WHERE codigo_autor = ?");
        st.setInt(1, codigo_autor);
        ResultSet rs = st.executeQuery();
        rs.next();
        try {
            return createAutor(rs);
        } catch (SQLException e) {
            throw new Exception("O autor não existe");
        }
    }

    /**
     * Save a autorDAO
     */
    public void save(autor autor) throws Exception {
        PreparedStatement saveAutor = connection.prepareStatement(INSERT);
        saveAutor.setString(1, autor.getNomea());
        saveAutor.setString(2, autor.getBiografia());
        saveAutor.execute();
        saveAutor.close();
    }

    /**
     * Remove a autorDAO
     */
    public void remove(autor autor) throws Exception {
        PreparedStatement stmt = connection.prepareStatement("DELETE "
                + "FROM autor where codigo_autor = ?");
        stmt.setLong(1, autor.getCodigo_autor());
        stmt.execute();
        stmt.close();
    }

    /**
     * Update a autorDAO
     */
    public void update(autor autor) throws Exception {
        PreparedStatement updateAutor = connection.prepareStatement(UPDATE);
        updateAutor.setString(1, autor.getNomea());
        updateAutor.setString(2, autor.getBiografia());
        updateAutor.execute();
        updateAutor.close();
    }

    /**
     * Create autorDAO
     */
    public autor createAutor(ResultSet resultSet) throws SQLException {
        int codigo_autor = resultSet.getInt("codigo_autor");
        String nomea = resultSet.getString("nomea");
        String biografia = resultSet.getString("biografia");
        System.out.println("\n");
        String info = "codigo_autor: " + codigo_autor
                + "\nnomea: " + nomea
                + "\nbiografia: " + biografia;
        System.out.println(info);
        return new autor( nomea, biografia);
    }

    /**
     * Search for autorDAO
     */
    public autor searchFor(String query, int atributte) throws Exception {
        String column = null;
        switch (atributte) {
            case 0:
                column = "codigo_autor";
                break;
            case 1:
                column = "nomea";
                break;
            case 2:
                column = "biografia";
                break;
        }
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM autor WHERE " + column + " = '" + query + "'");
            //TODO verificar se veio vazio
            while (rs.next()) {
                return createAutor(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
