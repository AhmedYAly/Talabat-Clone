package com.talabat;

public class Product {
    private String name;
    private String description;
    private float price;
    private int quantity;

    public Product(Product p) {
        this.name = p.getName();
        this.description = p.getDescription();
        this.price = p.getPrice();
        this.quantity = p.getQuantity();
    }

    public Product() {
        
    }
   

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void displayInfo(){
        System.out.println(name + "\t\t" + price);
    }
}
