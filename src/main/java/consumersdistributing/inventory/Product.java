/********************************************************
@author(s)          Lemi Miyu
@date               07-Jun-2024
@teacher            Andrew Carreiro
@file               Product.java
@description        This class represents a Product with attributes such as name,
                    product number, price, quantity, and description. It includes 
                    methods for getting and setting these attributes, as well as a 
                    method for generating a unique product number.
********************************************************/

package main.java.consumersdistributing.inventory;

public class Product {

    // CLASS VARIABLES
    private String name;
    private String productNum;
    private double price;
    private int quantity;
    private String description;
    private static boolean idExists;
    private static int x;

    /*******************
        Product(String productNum, int quantity, double price, String name, String description)
        @param          productNum
        @param          quantity
        @param          price
        @param          name
        @param          description
        @description    Constructor to initialize the product with given details.
    *******************/
    public Product(String productNum, int quantity, double price, String name, String description) {

        // Initialize the product with given details
        this.name = name;
        this.productNum = productNum;
        this.price = price;
        this.quantity = quantity;
        this.description = description;

    }

    /*******************
        getName()
        @return         String
        @description    Returns the name of the product.
    *******************/
    public String getName() {
        return this.name;
    }

    /*******************
        getProductNum()
        @return         String
        @description    Returns the product number of the product.
    *******************/
    public String getProductNum() {
        return this.productNum;
    }

    /*******************
        getPrice()
        @return         double
        @description    Returns the price of the product.
    *******************/
    public double getPrice() {
        return this.price;
    }

    /*******************
        getQuantity()
        @return         int
        @description    Returns the quantity of the product.
    *******************/
    public int getQuantity() {
        return this.quantity;
    }

    /*******************
        getDescription()
        @return         String
        @description    Returns the description of the product.
    *******************/
    public String getDescription() {
        return this.description;
    }

    /*******************
        setProductNum(String productNum)
        @param          productNum
        @return         void
        @description    Sets the product number of the product.
    *******************/
    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    /*******************
        setPrice(double price)
        @param          price
        @return         void
        @description    Sets the price of the product.
    *******************/
    public void setPrice(double price) {
        this.price = price;
    }

    /*******************
        setQuantity(int quantity)
        @param          quantity
        @return         void
        @description    Sets the quantity of the product.
    *******************/
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /*******************
        setDescription(String description)
        @param          description
        @return         void
        @description    Sets the description of the product.
    *******************/
    public void setDescription(String description) {
        this.description = description;
    }

    /*******************
        generateProductNum()
        @return         String
        @description    Generates a unique product number.
    *******************/
    public static String generateProductNum() {

        // Repeat the loop if the product number exists for any product
        do {

            idExists = false; // Assume the product number does not exist initially
            x = (int)(Math.random() * 900000 + 100000);

            // Check if the generated product number exists for any product
            for (Product product : InventoryManagement.getProductList()) {

                if (product.getProductNum().equals(String.valueOf(x))) {

                    idExists = true; // Set idExists to true if the product number exists
                    break; // Exit the loop since the product number was found

                }

            }

        } while (idExists); // Repeat the loop if the product number exists for any product

        // Return the generated product number
        return String.valueOf(x);

    }
    
}
