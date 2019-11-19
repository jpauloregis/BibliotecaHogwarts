/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.livro;
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
public class livroDAO {

    private final static livroDAO INSTANCE = new livroDAO();
    private Statement stmt;

    private ArrayList<livro> arraylivro;
    private Connection connection;
    private final String UPDATE = "UPDATE livro SET "
            + "titulo = ?, "
            + "resumo = ?,"
            + "ano_publicacao = ?,"
            + "volume = ?,"
            + "editora = ?,"
            + "edicao = ?,"
            + "altura = ?,"
            + "peso = ?,"
            + "largura = ?,"
            + "isbn_issn = ?,"
            + "WHERE codigo_livro = ?";
    private final String INSERT = "INSERT INTO livro "
            + "(titulo, resumo, ano_publicacao, volume, editora, edicao, altura, peso, largura, isbn_issn)"
            + " VALUES (?,?,?,?,?,?,?,?,?,?)";

    /**
     * Import all autorDAO from BD.
     */
    public void importlivros() {
        try {
            Statement stmt = Objects.requireNonNull(ConnectionBD.getConnection()).createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM livro");
            while (rs.next()) {
                int codigo_livro = rs.getInt("codigo_livro");
                String titulo = rs.getString("titulo");
                String resumo = rs.getString("resumo");
                int ano_publicacao = rs.getInt("ano_publicacao");
                String volume = rs.getString("volume");
                String editora = rs.getString("editora");
                String edicao = rs.getString("edicao");
                Double altura = rs.getDouble("altura");
                Double peso = rs.getDouble("peso");
                Double largura = rs.getDouble("largura");
                String isbn_issn = rs.getString("isbn_issn");

                System.out.println("\n");
                String info = "codigo_livro: " + codigo_livro
                        + "\ntitulo: " + titulo
                        + "\nresumo: " + resumo
                        + "\nano_publicacao: " + ano_publicacao
                        + "\nvolume: " + volume
                        + "\neditora: " + editora
                        + "\nedicao: " + edicao
                        + "\naltura: " + altura
                        + "\npeso: " + peso
                        + "\nlargura: " + largura
                        + "\nisbn_issn: " + isbn_issn;
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
    public livroDAO() {
        connection = ConnectionBD.getConnection();
        try {
            stmt = Objects.requireNonNull(ConnectionBD.getConnection()).createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        arraylivro = new ArrayList<>();
    }

    /**
     * Get unique instance of autorDAO.
     *
     * @return
     */
    public static livroDAO getINSTANCE() {
        return INSTANCE;
    }

    /**
     * Get from codigo_autor.
     */
    public livro get(int codigo_livro) throws Exception {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM livro WHERE codigo_livro = ?");
        st.setInt(1, codigo_livro);
        ResultSet rs = st.executeQuery();
        rs.next();
        try {
            return createlivro(rs);
        } catch (SQLException e) {
            throw new Exception("não existe");
        }
    }

    /**
     * Save a autorDAO
     */
    public void save(livro livro) throws Exception {
        PreparedStatement savelivro = connection.prepareStatement(INSERT);
        savelivro.setString(1, livro.getTitulo());
        savelivro.setString(2, livro.getResumo());
        savelivro.setInt(3, livro.getAno_publicacao());
        savelivro.setString(4, livro.getVolume());
        savelivro.setString(5, livro.getEditora());
        savelivro.setString(6, livro.getEdicao());
        savelivro.setDouble(7, livro.getAltura());
        savelivro.setDouble(8, livro.getPeso());
        savelivro.setDouble(9, livro.getLargura());
        savelivro.setString(10, livro.getIsbn_issn());
        savelivro.execute();
        savelivro.close();
    }

    /**
     * Remove a autorDAO
     */
    public void remove(livro livro) throws Exception {
        PreparedStatement stmt = connection.prepareStatement("DELETE "
                + "FROM livro where codigo_livro = ?");
        stmt.setLong(1, livro.getCodigo_livro());
        stmt.execute();
        stmt.close();
    }

    /**
     * Update a autorDAO
     */
    public void update(livro livro) throws Exception {
        PreparedStatement updatelivro = connection.prepareStatement(UPDATE);
        updatelivro.setString(1, livro.getTitulo());
        updatelivro.setString(2, livro.getResumo());
        updatelivro.setInt(3, livro.getAno_publicacao());
        updatelivro.setString(4, livro.getVolume());
        updatelivro.setString(5, livro.getEditora());
        updatelivro.setString(6, livro.getEdicao());
        updatelivro.setDouble(7, livro.getAltura());
        updatelivro.setDouble(8, livro.getPeso());
        updatelivro.setDouble(9, livro.getLargura());
        updatelivro.setString(10, livro.getIsbn_issn());
        updatelivro.close();
    }

    /**
     * Create autorDAO
     */
    public livro createlivro(ResultSet rs) throws SQLException {
       int codigo_livro = rs.getInt("codigo_livro");
                String titulo = rs.getString("titulo");
                String resumo = rs.getString("resumo");
                int ano_publicacao = rs.getInt("ano_publicacao");
                String volume = rs.getString("volume");
                String editora = rs.getString("editora");
                String edicao = rs.getString("edicao");
                Double altura = rs.getDouble("altura");
                Double peso = rs.getDouble("peso");
                Double largura = rs.getDouble("largura");
                String isbn_issn = rs.getString("isbn_issn");

        System.out.println("\n");
         String info = "codigo_livro: " + codigo_livro
                        + "\ntitulo: " + titulo
                        + "\nresumo: " + resumo
                        + "\nano_publicacao: " + ano_publicacao
                        + "\nvolume: " + volume
                        + "\neditora: " + editora
                        + "\nedicao: " + edicao
                        + "\naltura: " + altura
                        + "\npeso: " + peso
                        + "\nlargura: " + largura
                        + "\nisbn_issn: " + isbn_issn;
        System.out.println(info);
        return new livro( titulo, resumo, ano_publicacao, volume, editora, edicao, altura, peso, largura, isbn_issn);
    }

    /**
     * Search for autorDAO
     */
    public livro searchFor(String query, int atributte) throws Exception {
        String column = null;
        switch (atributte) {
            case 0:
                column = "codigo_livro";
                break;
            case 1:
                column = "titulo";
                break;
            case 2:
                column = "resumo";
                break;
            case 3:
                column = "ano_publicacao";
                break;
            case 4:
                column = "volume";
                break;
            case 5:
                column = "editora";
                break;
            case 6:
                column = "edicao";
                break;
            case 7:
                column = "altura";
                break;
            case 8:
                column = "peso";
                break;
            case 9:
                column = "largura";
                break;
            case 10:
                column = "isbn_issn";
                break;

        }
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM livro  WHERE " + column + " = '" + query + "'");
            //TODO verificar se veio vazio
            while (rs.next()) {
                return createlivro(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
