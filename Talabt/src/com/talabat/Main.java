package com.talabat;

import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class Main {
    public static Connection conn;

    public static void databaseConnection(){
        final String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
        final String connVar = "hr";
        System.out.println("Establishing Connection...");
        try {
            conn = DriverManager.getConnection(dbURL, connVar, connVar);
            System.out.println("Connected.");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Failed to connect to database!");

            System.exit(304);
        }
    }

    public static void main(String[] args) throws SQLException {
        Main.databaseConnection();
        Customer cus = new Customer("null", "null");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPanel(cus).setVisible(true);
            }
        });
    }
}
