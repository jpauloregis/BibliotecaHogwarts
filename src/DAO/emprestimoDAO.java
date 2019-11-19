/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.complemento;
import Models.emprestimo;
import java.sql.Connection;
import java.sql.Date;
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
public class emprestimoDAO {

    private final static emprestimoDAO INSTANCE = new emprestimoDAO();
    private Statement stmt;

    private ArrayList<emprestimo> arrayEmprestimo;
    private Connection connection;
    private final String UPDATE = "UPDATE emprestimo SET "
            + "data_vencimento = ?,"
            + "WHERE se_codigo = ?";
    private final String INSERT = "INSERT INTO emprestimo "
            + "(data_vencimento)"
            + " VALUES (?)";

    /**
     * Constructor autorDAO.
     */
    public emprestimoDAO() {
        connection = ConnectionBD.getConnection();
        try {
            stmt = Objects.requireNonNull(ConnectionBD.getConnection()).createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        arrayEmprestimo = new ArrayList<>();
    }

    /**
     * Get unique instance of autorDAO.
     *
     * @return
     */
    public static emprestimoDAO getINSTANCE() {
        return INSTANCE;
    }

    /**
     * Import all autorDAO from BD.
     */
    public void importEmprestimo() {
        try {
            Statement stmt = Objects.requireNonNull(ConnectionBD.getConnection()).createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM emprestimo");
            while (rs.next()) {
                int se_codigo = rs.getInt("se_codigo");
                Date data_vencimento = rs.getDate("data_vencimento");
                System.out.println("\n");
                String info = "se_codigo: " + se_codigo
                        + "\ndata_vencimento: " + data_vencimento;
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
    public emprestimo get(int se_codigo) throws Exception {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM emprestimo WHERE se_codigo = ?");
        st.setInt(1, se_codigo);
        ResultSet rs = st.executeQuery();
        rs.next();
        try {
            return createEmprestimo(rs);
        } catch (SQLException e) {
            throw new Exception("não existe");
        }
    }

    /**
     * Save a autorDAO
     */
    public void save(emprestimo emprestimo) throws Exception {
        PreparedStatement saveEmprestimo = connection.prepareStatement(INSERT);
        saveEmprestimo.setDate(1, emprestimo.getData_vencimento());
        saveEmprestimo.execute();
        saveEmprestimo.close();
    }

    /**
     * Remove a autorDAO
     */
    public void remove(emprestimo emprestimo) throws Exception {
        PreparedStatement stmt = connection.prepareStatement("DELETE "
                + "FROM emprestimo where se_codigo = ?");
        stmt.setLong(1, emprestimo.getSe_codigo());
        stmt.execute();
        stmt.close();
    }

    /**
     * Update a autorDAO
     */
    public void update(emprestimo emprestimo) throws Exception {
        PreparedStatement updateEmprestimo = connection.prepareStatement(UPDATE);
        updateEmprestimo.setDate(1, emprestimo.getData_vencimento());
        updateEmprestimo.execute();
        updateEmprestimo.close();
    }

    /**
     * Create autorDAO
     */
    public emprestimo createEmprestimo(ResultSet resultSet) throws SQLException {
        int se_codigo = resultSet.getInt("se_codigo");
        Date data_vencimento = resultSet.getDate("data_vencimento");
        System.out.println("\n");
        String info = "se_codigo: " + se_codigo
                + "\ndata_vencimento: " + data_vencimento;
        System.out.println(info);
        return new emprestimo(se_codigo, data_vencimento);
    }

    /**
     * Search for autorDAO
     */
    public emprestimo searchFor(String query, int atributte) throws Exception {
        String column = null;
        switch (atributte) {
            case 0:
                column = "se_codigo";
                break;
            case 1:
                column = "data_vencimento";
                break;
    
        }
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM emprestimo  WHERE " + column + " = '" + query + "'");
            //TODO verificar se veio vazio
            while (rs.next()) {
                return createEmprestimo(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
