/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebastian-dev
 */
public class Database {
    
    private static Connection connection = null;

    public static Connection getConecction() throws SQLException {

        String ip = "localhost";
        String basedatos = "playcards_DB";
        String usuario = "postgres";
        String pass = "postgres";
        String puerto = "5432";
        String url = "jdbc:postgresql://" + ip + ":" + puerto + "/" + basedatos;

        try {
            if (Database.connection == null) {
                Class.forName("org.postgresql.Driver");
                Database.connection = DriverManager.getConnection(url, usuario, pass);
                Database.connection.setAutoCommit(false);
                return Database.connection;
            }
        } catch (Exception ex) {
            System.out.println("ERROR EN EL DRIVER \n ERROR : " + ex.getMessage());
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            Database.connection.close();
        }

        return Database.connection;

    }
    
}
