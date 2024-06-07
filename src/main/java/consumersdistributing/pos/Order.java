/********************************************************
@file               Order.java
@description        This class represents an order in the point of sale (POS) system.
                    It includes attributes such as customer name, product name, 
                    stock, quantity ordered, and price.
********************************************************/

package main.java.consumersdistributing.pos;

public class Order {
    
    // CLASS VARIABLES
    private String customerName;
    private String productName;
    private int stock;
    private int quantityOrdered;
    private double price;
    
    /*******************
        Order()
        @param customerName     The name of the customer
        @param productName      The name of the product
        @param stock            The available stock of the product
        @param quantityOrdered  The quantity of product ordered
        @param price            The price of the product
        @description            Constructor to initialize an Order object.
    *******************/
    public Order(String customerName, String productName, int stock, int quantityOrdered, double price) {
        this.customerName = customerName;
        this.productName = productName;
        this.stock = stock;
        this.quantityOrdered = quantityOrdered;
        this.price = price;
    }

    // GETTERS
    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public double getPrice() {
        return price;
    }

    // SETTERS
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
