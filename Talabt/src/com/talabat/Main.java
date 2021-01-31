package com.talabat;

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

    public static void main(String[] args) throws SQLException {
       // Main.databaseConnection();
        Customer cus = new Customer("null", "null");
//       Customer c =new Customer("liv","123","010","aesjo");
//       c.makeOrder();
//       for(Order order:c.displayOrders()){
//           order.displayInfo();
//       }
//        new Selection(cus).setVisible(true);

        //new Selection().setVisible(true);

        //new OwnerHome().setVisible(true);

        new CusHome().setVisible(true);

        //conn.close();
    }
}
