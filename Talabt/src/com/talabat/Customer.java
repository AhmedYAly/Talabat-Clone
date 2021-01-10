package com.talabat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User{
    private String mobileNumber;
    private String address;
    private float totalPrice = 0;
    private List<Order> orderList = new ArrayList<Order>();


    public Customer(String userName, String password) {
        super(userName, password);
    }

    public Customer(String userName, String password, String mobileNumber, String address) {
        super(userName, password);
        this.mobileNumber = mobileNumber;
        this.address = address;

        String query = "insert into customer (CUSTOMER_USERNAME, CUSTOMER_PASSWORD, MOBILE_NUMBER, ADDRESS) values(?,?,?,?)";
        PreparedStatement insert = null;
        try {
            insert = Main.conn.prepareStatement(query);
            insert.setString(1, userName);
            insert.setString(2, password);
            insert.setString(3, mobileNumber);
            insert.setString(4, address);
            insert.execute();

            System.out.println("Added to database.");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public boolean login(String username, String password) throws SQLException{
        boolean loggedIn;

        String query = "select CUSTOMER_PASSWORD from customer where CUSTOMER_USERNAME = ?";
        PreparedStatement select = Main.conn.prepareStatement(query);
        select.setString(1,username);
        ResultSet set = select.executeQuery();

        if(!set.next()){
            loggedIn = false; // username not found
            System.out.println("Username not found!");
        } else{
            loggedIn = true; // prompt to continue
            System.out.println("Username found.");
        }

        if(loggedIn){
            if(password.equals(set.getString("CUSTOMER_PASSWORD"))){
                loggedIn = true;
                System.out.println("User credentials correct.");
            } else{
                loggedIn = false; //password incorrect
                System.out.println("Invalid Password");
            }
        }

        return loggedIn;
    }

    public List<Product> makeOrder() throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        List<Product> productSelection = new ArrayList<Product>();
        Product prd = new Product();
        Scanner input = new Scanner(System.in);

        String query = "select * from product";
        PreparedStatement select = Main.conn.prepareStatement(query);
        ResultSet productSet = select.executeQuery();

        while(productSet.next()){
            prd.setName(productSet.getString("PRODUCT_NAME"));
            prd.setDescription(productSet.getString("PRODUCT_DESCRIPTION"));
            prd.setPrice(productSet.getFloat("PRICE"));

            productList.add(prd);
            prd.displayInfo();
        }

        mealSelection:
        while(true){
            System.out.println("\nChoose your meal:");
            int selection = input.nextInt();

            for(int i = 0; i < productList.size(); i++){
                if(selection - 1 == i){
                    totalPrice += productList.get(i).getPrice();
                    productSelection.add(productList.get(i));
                    break;
                }
            }

            System.out.println("would you likr another meal? ");
            String redo = input.next();

            if(redo.equals("y"))
                continue mealSelection;
            else{
                Order ord = new Order();
                ord.setProducts(productSelection);
                ord.setName(this.getUserName() + this.address);
                ord.setDate();
                ord.displayInfo();
                ord.savetoDatabase();
                orderList.add(ord);
                break;
            }
        }
        return productList;
    }

    public List<Order> displayOrders() throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        Order ord = new Order();
        Product prd = new Product();

        String query = "select * from orders_inf";
        PreparedStatement select = Main.conn.prepareStatement(query);
        ResultSet orderSet = select.executeQuery();

        while(orderSet.next()){
            ord.setName(orderSet.getString("ORDER_NAME"));
            ord.setDate(orderSet.getDate("ORDER_DATE"));
            ord.setNotes(orderSet.getString("NOTES"));
            ord.setRst_name(orderSet.getString("RST_NAME"));

            query = "select * from orders where order_name = ?";
            select = Main.conn.prepareStatement(query);
            select.setString(1 ,ord.getName());
            ResultSet productSet = select.executeQuery();

            while(productSet.next()){
                prd.setName(productSet.getString("MEAL_NAME"));
                prd.setQuantity(productSet.getInt("QUANTITY"));

                query = "select PRICE from product where PRODUCT_NAME = ?";
                select = Main.conn.prepareStatement(query);
                select.setString(1, prd.getName());
                ResultSet priceSet = select.executeQuery();

                while(priceSet.next()){
                    prd.setPrice(priceSet.getFloat("PRICE"));
                    productList.add(prd);
                }
                ord.setProducts(productList);
                orderList.add(ord);
            }
        }

        return orderList;
    }
}
