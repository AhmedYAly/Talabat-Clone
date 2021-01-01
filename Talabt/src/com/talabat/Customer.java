package com.talabat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private String mobileNumber;
    private String address;
    private float totalPrice;

    public Customer(String userName, String password, String mobileNumber, String address) {
        super(userName, password);
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public void Register(Customer customer) throws SQLException {
        String query = "insert into customer (CUSTOMER_USERNAME, CUSTOMER_PASSWORD, MOBILE_NUMBER, ADDRESS) values(?,?,?,?)";
        PreparedStatement insert = Main.conn.prepareStatement(query);
        insert.setString(1, customer.getUserName());
        insert.setString(2, customer.getPassword());
        insert.setString(3, customer.mobileNumber);
        insert.setString(4, customer.address);
        insert.execute();

        System.out.println("Added to database.");
    }

    public boolean login(String username, String password) throws SQLException{
        boolean loggedIn;
        int isFound = 0; //default value

        String query = "select CUSTOMER_PASSWORD from customer where CUSTOMER_USERNAME = ?";
        PreparedStatement select = Main.conn.prepareStatement(query);
        select.setString(1,username);
        ResultSet set = select.executeQuery();

        if(!set.next()){
            isFound = 2; // username not found
            System.out.println("Username not found!");
        } else{
            isFound = 1; // prompt to continue
            System.out.println("Username found.");
        }

        if(isFound == 1){
            while(set.next()){
                if(password.equals(set.getString("CUSTOMER_PASSWORD"))){
                    isFound = 1;
                    System.out.println("User credentials correct.");
                } else{
                    isFound = 3; //password incorrect
                    System.out.println("Logged in");
                }
            }
        }

        if(isFound == 1){
            loggedIn = true;
        } else{
            loggedIn = false;
        }

        return loggedIn;
    }

    public List<Product> displayProducts() throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        Product prd = new Product();

        String query = "select * from product";
        PreparedStatement select = Main.conn.prepareStatement(query);
        ResultSet productSet = select.executeQuery();

        while(productSet.next()){
            prd.setName(productSet.getString("PRODUCT_NAME"));
            prd.setDescription(productSet.getString("PRODUCT_DESCRIPTION"));
            prd.setPrice(productSet.getFloat("PRICE"));

            productList.add(prd);
        }

        return productList;
    }

    public List<Order> displayOrders() throws SQLException {
        List<Order> orderList = new ArrayList<Order>();
        List<Product> productList = new ArrayList<Product>();
        Order ord = new Order();
        Product prd = new Product();

        String query = "select * from orders_inf";
        PreparedStatement select = Main.conn.prepareStatement(query);
        ResultSet orderSet = select.executeQuery();

        while(orderSet.next()){
            ord.setName(orderSet.getString("ORDER_NAME"));
            ord.setDate(orderSet.getDate("ORDER_DATE"));
            ord.setNotes(orderSet.getString("NOTES)"));
            ord.setRst_name(orderSet.getString("RST_NAME"));

            query = "select * from orders where order_name = ?";
            select = Main.conn.prepareStatement(query);
            select.setString(1 ,ord.getName());
            ResultSet productSet = select.executeQuery();

            while(productSet.next()){
                prd.setName(productSet.getString("MEAL_NAME"));
                prd.setQuantity(productSet.getInt("QUANTITY"));

                query = "select PRICE form product where PRODUCT_NAME = ?";
                select = Main.conn.prepareStatement(query);
                select.setString(1, prd.getName());
                ResultSet priceSet = select.executeQuery();

                while(priceSet.next()){
                    prd.setPrice(priceSet.getFloat("PRICE"));
                    productList.add(prd);
                }
                ord.setProducts(productList);
            }
            orderList.add(ord);
        }

        return orderList;
    }
}
