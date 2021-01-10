package com.talabat;

import java.sql.*;
import java.util.*;

public class Order {
    private String name;
    private java.sql.Date Date;
    private String rst_name = "7amada";
    private String notes = "mafie4 lift";
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product prdct){
        products.add(prdct);
    }

    public void setDate(){
        this.Date = java.sql.Date.valueOf(java.time.LocalDate.now());
    }

    public void savetoDatabase() throws SQLException{
        String query = "insert into orders_inf (ORDER_NAME, ORDER_DATE, NOTES, RST_NAME) values(?,?,?,?)";
        PreparedStatement insert = Main.conn.prepareStatement(query);
        insert.setString(1, name);
        insert.setDate(2, Date);
        insert.setString(3, notes);
        insert.setString(4, rst_name);
        insert.execute();

        for (Product prd:products) {
            query = "insert into orders (MEAL_NAME, QUANTITY, ORDER_NAME) values(?,?,?)";
            insert = Main.conn.prepareStatement(query);
            insert.setString(1, prd.getName());
            insert.setInt(2, prd.getQuantity());
            insert.setString(3, this.name);
            insert.execute();
        }

        System.out.println("added to database");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(java.sql.Date date) {
        this.Date = date;
    }

    public void setRst_name(String rst_name) {
        this.rst_name = rst_name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void displayInfo(){
        System.out.println(name);
        System.out.println(rst_name);
        System.out.println(notes);
        System.out.println(Date);
        for(int i = 0; i < products.size(); i++){
            System.out.println(products.get(i).getName());
            System.out.println(products.get(i).getQuantity());
            System.out.println("-----");
        }
    }
}
