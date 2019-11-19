/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.usuario;
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
public class usuarioDAO {

    private final static usuarioDAO INSTANCE = new usuarioDAO();
    private Statement stmt;

    private ArrayList<usuario> arrayusuario;
    private Connection connection;
    private final String UPDATE = "UPDATE usuario SET "
            + "nome = ?, "
            + "email = ?,"
            + "cpf = ?,"
            + "cep = ?,"
            + "complemento = ?,"
            + "numero = ?,"
            + "celular = ?,"
            + "residencial = ?,"
            + "data_cadastro = ?,"
            + "WHERE codigo_usuario = ?";
    private final String INSERT = "INSERT INTO usuario "
            + "(nome, email, cpf, cep, complemento, numero, celular, residencial, data_cadastro)"
            + " VALUES (?,?,?,?,?,?,?,?,?)";

    /**
     * Import all autorDAO from BD.
     */
    public void importusuarios() {
        try {
            Statement stmt = Objects.requireNonNull(ConnectionBD.getConnection()).createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                int codigo_usuario = rs.getInt("codigo_usuario");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String cep = rs.getString("cep");
                String complemento = rs.getString("complemento");
                String numero = rs.getString("numero");
                String celular = rs.getString("celular");
                String residencial = rs.getString("residencial");
                String data_cadastro = rs.getString("data_cadastro");

                System.out.println("\n");
                String info = "codigo_usuario: " + codigo_usuario
                        + "\nnome: " + nome
                        + "\nemail: " + email
                        + "\ncpf: " + cpf
                        + "\ncep: " + cep
                        + "\ncomplemento: " + complemento
                        + "\nnumero: " + numero
                        + "\ncelular: " + celular
                        + "\nresidencial: " + residencial
                        + "\ndata_cadastro: " + data_cadastro;
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
     * Constructor autorDAO.
     */
    public usuarioDAO() {
        connection = ConnectionBD.getConnection();
        try {
            stmt = Objects.requireNonNull(ConnectionBD.getConnection()).createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        arrayusuario = new ArrayList<>();
    }

    /**
     * Get unique instance of autorDAO.
     *
     * @return
     */
    public static usuarioDAO getINSTANCE() {
        return INSTANCE;
    }

    /**
     * Get from codigo_autor.
     */
    public usuario get(int codigo_usuario) throws Exception {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM usuario WHERE codigo_usuario = ?");
        st.setInt(1, codigo_usuario);
        ResultSet rs = st.executeQuery();
        rs.next();
        try {
            return createusuario(rs);
        } catch (SQLException e) {
            throw new Exception("não existe");
        }
    }

    /**
     * Save a autorDAO
     */
    public void save(usuario usuario) throws Exception {
        PreparedStatement saveusuario = connection.prepareStatement(INSERT);
        saveusuario.setString(1, usuario.getNome());
        saveusuario.setString(2, usuario.getEmail());
        saveusuario.setString(3, usuario.getCpf());
        saveusuario.setString(4, usuario.getCep());
        saveusuario.setString(5, usuario.getComplemento());
        saveusuario.setString(6, usuario.getNumero());
        saveusuario.setString(7, usuario.getCelular());
        saveusuario.setString(8, usuario.getResidencial());
        saveusuario.setString(9, usuario.getData_cadastro());
        saveusuario.execute();
        saveusuario.close();
    }

    /**
     * Remove a autorDAO
     */
    public void remove(usuario usuario) throws Exception {
        PreparedStatement stmt = connection.prepareStatement("DELETE "
                + "FROM usuario where codigo_usuario = ?");
        stmt.setLong(1, usuario.getCodigo_usuario());
        stmt.execute();
        stmt.close();
    }

    /**
     * Update a autorDAO
     */
    public void update(usuario usuario) throws Exception {
        PreparedStatement updateusuario = connection.prepareStatement(UPDATE);
        updateusuario.setString(1, usuario.getNome());
        updateusuario.setString(2, usuario.getEmail());
        updateusuario.setString(3, usuario.getCpf());
        updateusuario.setString(4, usuario.getCep());
        updateusuario.setString(5, usuario.getComplemento());
        updateusuario.setString(6, usuario.getNumero());
        updateusuario.setString(7, usuario.getCelular());
        updateusuario.setString(8, usuario.getResidencial());
        updateusuario.setString(9, usuario.getData_cadastro());
        updateusuario.execute();
        updateusuario.close();
    }

    /**
     * Create autorDAO
     */
    public usuario createusuario(ResultSet rs) throws SQLException {
        int codigo_usuario = rs.getInt("codigo_usuario");
        String nome = rs.getString("nome");
        String email = rs.getString("email");
        String cpf = rs.getString("cpf");
        String cep = rs.getString("cep");
        String complemento = rs.getString("complemento");
        String numero = rs.getString("numero");
        String celular = rs.getString("celular");
        String residencial = rs.getString("residencial");
        String data_cadastro = rs.getString("data_cadastro");

        System.out.println("\n");
        String info = "codigo_usuario: " + codigo_usuario
                + "\nnome: " + nome
                + "\nemail: " + email
                + "\ncpf: " + cpf
                + "\ncep: " + cep
                + "\ncomplemento: " + complemento
                + "\nnumero: " + numero
                + "\ncelular: " + celular
                + "\nresidencial: " + residencial
                + "\ndata_cadastro: " + data_cadastro;
        System.out.println(info);
        return new usuario( nome, email, cpf, cep, complemento, numero, celular, residencial, data_cadastro);
    }

    /**
     * Search for autorDAO
     */
    public usuario searchFor(String query, int atributte) throws Exception {
        String column = null;
        switch (atributte) {
            case 0:
                column = "codigo_usuario";
                break;
            case 1:
                column = "nome";
                break;
            case 2:
                column = "email";
                break;
            case 3:
                column = "cpf";
                break;
            case 4:
                column = "cep";
                break;
            case 5:
                column = "complemento";
                break;
            case 6:
                column = "numero";
                break;
            case 7:
                column = "celular";
                break;
            case 8:
                column = "residencial";
                break;
            case 9:
                column = "data_cadastro";
                break;

        }
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario  WHERE " + column + " = '" + query + "'");
            //TODO verificar se veio vazio
            while (rs.next()) {
                return createusuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
