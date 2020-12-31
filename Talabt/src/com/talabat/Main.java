package com.talabat;

import javax.swing.*;
import java.sql.*;

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

    public static void main(String[] args) {
        //Main.databaseConnection();

        login panel = new login(new ImageIcon("/assets/images/img.png").getImage());

        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setSize(448,526);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
