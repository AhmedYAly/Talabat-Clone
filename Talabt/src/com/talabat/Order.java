package com.talabat;

import java.sql.*;
import java.util.*;

public class Order {
    private String name;
    private java.sql.Date Date;
    private String rst_name;
    private String notes;
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product prdct){
        products.add(prdct);
    }

    public void setDate(){
        this.Date = java.sql.Date.valueOf(java.time.LocalDate.now());
    }

    private void savetoDatabase(Order ord) throws SQLException{
        String query = "insert into orders_inf (ORDER_NAME, ORDER_DATE, NOTES, RST_NAME) value(?,?,?,?)";
        PreparedStatement insert = Main.conn.prepareStatement(query);
        insert.setString(1, this.name);
        insert.setDate(2, this.Date);
        insert.setString(3, this.notes);
        insert.setString(4, this.rst_name);
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
}
