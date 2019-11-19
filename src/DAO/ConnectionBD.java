package DAO;//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionBD {

    public static String status = "Não conectou...";

    public ConnectionBD() {
    }

    //Método de Conexão//
    public static Connection getConnection() {
        Connection connection = null;
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName("com.mysql.jdbc.Driver");

            String serverName = "localhost";
            String mydatabase = "bibliotecamagica";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?autoReconnect=true&useSSL=false";
            String username = "root";
            String password = "root123";

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                status = ("Conectado com sucesso!");
            } else {
                status = ("Não foi possivel realizar conexão");
            }
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + e.getErrorCode());
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String statusConection() {
        return status;
    }

    public static boolean FecharConexao() {
        try {
            ConnectionBD.getConnection().close();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConnectionBD.getConnection();
    }

}