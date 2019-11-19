/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.autor;
import Models.complemento;
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
public class complementoDAO {
    private final static complementoDAO INSTANCE = new complementoDAO();
    private Statement stmt;

    private ArrayList<complemento> arrayComplemento;
    private Connection connection;
    private final String UPDATE = "UPDATE complemento SET "
            + "tipo = ?, "
            + "localizacao = ?,"
            + "WHERE livros_codigo = ?";
    private final String INSERT = "INSERT INTO complemento "
            + "(tipo, localizacao)"
            + " VALUES (?, ?)";

    /**
     * Constructor autorDAO.
     */
    public complementoDAO() {
        connection = ConnectionBD.getConnection();
        try {
            stmt = Objects.requireNonNull(ConnectionBD.getConnection()).createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        arrayComplemento = new ArrayList<>();
    }

    /**
     * Get unique instance of autorDAO.
     *
     * @return
     */
    public static complementoDAO getINSTANCE() {
        return INSTANCE;
    }

    /**
     * Import all autorDAO from BD.
     */
    public void importComplementos() {
        try {
            Statement stmt = Objects.requireNonNull(ConnectionBD.getConnection()).createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM complemento");
            while (rs.next()) {
                int livros_codigo = rs.getInt("livros_codigo");
                String tipo = rs.getString("tipo");
                String localizacao = rs.getString("localizacao");
                System.out.println("\n");
                String info = "livros_codigo: " + livros_codigo
                        + "\ntipo: " + tipo
                        + "\nlocalizacao: " + localizacao;
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
    public complemento get(int livros_codigo) throws Exception {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM complemento WHERE livros_codigo = ?");
        st.setInt(1, livros_codigo);
        ResultSet rs = st.executeQuery();
        rs.next();
        try {
            return createComplemento(rs);
        } catch (SQLException e) {
            throw new Exception("não existe");
        }
    }

    /**
     * Save a autorDAO
     */
    public void save(complemento complemento) throws Exception {
        PreparedStatement saveComplemento = connection.prepareStatement(INSERT);
        saveComplemento.setString(1, complemento.getTipo());
        saveComplemento.setString(2, complemento.getLocalizacao());
        saveComplemento.execute();
        saveComplemento.close();
    }

    /**
     * Remove a autorDAO
     */
    public void remove(complemento complemento) throws Exception {
        PreparedStatement stmt = connection.prepareStatement("DELETE "
                + "FROM complemento where livros_codigo = ?");
        stmt.setLong(1, complemento.getLivros_codigo());
        stmt.execute();
        stmt.close();
    }

    /**
     * Update a autorDAO
     */
    public void update(complemento complemento) throws Exception {
        PreparedStatement updatecomplemento = connection.prepareStatement(UPDATE);
        updatecomplemento.setString(1, complemento.getTipo());
        updatecomplemento.setString(2, complemento.getLocalizacao());
        updatecomplemento.execute();
        updatecomplemento.close();
    }

    /**
     * Create autorDAO
     */
    public complemento createComplemento(ResultSet resultSet) throws SQLException {
        int livros_codigo = resultSet.getInt("livros_codigo");
        String tipo = resultSet.getString("tipo");
        String localizacao = resultSet.getString("localizacao");
        System.out.println("\n");
        String info = "livros_codigo: " + livros_codigo
                + "\ntipo: " + tipo
                + "\nlocalizacao: " + localizacao;
        System.out.println(info);
        return new complemento(livros_codigo, tipo, localizacao);
    }

    /**
     * Search for autorDAO
     */
    public complemento searchFor(String query, int atributte) throws Exception {
        String column = null;
        switch (atributte) {
            case 0:
                column = "livros_codigo";
                break;
            case 1:
                column = "tipo";
                break;
            case 2:
                column = "localizacao";
                break;
        }
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM complemento  WHERE " + column + " = '" + query + "'");
            //TODO verificar se veio vazio
            while (rs.next()) {
                return createComplemento (rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
