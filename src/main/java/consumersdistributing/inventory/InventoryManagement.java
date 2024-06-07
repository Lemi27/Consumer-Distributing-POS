/********************************************************
@author(s)          Lemi Miyu
@date               07-Jun-2024
@teacher            Andrew Carreiro
@file               InventoryManagement.java
@description        This class provides methods to manage a list of products,
                    including adding, removing, retrieving, and printing product details.
********************************************************/

package main.java.consumersdistributing.inventory;

import java.util.ArrayList;

public class InventoryManagement {

    // ArrayList to hold Product objects
    private static ArrayList<Product> products = new ArrayList<>();

    /*******************
        getProductList()
        @return         ArrayList<Product>
        @description    Returns the list of all products.
    *******************/
    public static ArrayList<Product> getProductList() {
        
        // Return the list of products
        return products;

    }

    /*******************
        getProductWithId(String productNum)
        @param          productNum
        @return         Product
        @description    Searches for a product by product number and returns the product object.
    *******************/
    public static Product getProductWithId(String productNum) {

        // Loop through the product list to find a product by product number
        for (int i = 0; i < products.size(); i++) {

            if (productNum.equals(products.get(i).getProductNum())) {

                // Return the found product
                return products.get(i);

            }

        }

        // Return null if no product is found
        return null;

    }

    /*******************
        getProductWithName(String name)
        @param          name
        @return         Product
        @description    Searches for a product by name and returns the product object.
    *******************/
    public static Product getProductWithName(String name) {

        // Loop through the product list to find a product by name
        for (int i = 0; i < products.size(); i++) {

            if (name.equals(products.get(i).getName())) {

                // Return the found product
                return products.get(i);

            }

        }

        // Return null if no product is found
        return null;

    }

    /*******************
        addItem(String productNum, int quantity, double price, String name, String description)
        @param          productNum
        @param          quantity
        @param          price
        @param          name
        @param          description
        @return         void
        @description    Adds a new product to the list with the provided details.
    *******************/
    public static void addItem(String productNum, int quantity, double price, String name, String description) {

        // Add a new product to the list
        products.add(new Product(productNum, quantity, price, name, description));

    }

    /*******************
        itemSold(int index, int quantitySold)
        @param          index
        @param          quantitySold
        @return         void
        @description    Updates the quantity of a product after a sale.
    *******************/
    public static void itemSold(int index, int quantitySold) {

        // Update the quantity of the product after a sale
        products.get(index).setQuantity(products.get(index).getQuantity() - quantitySold);

    }

    /*******************
        deleteItem(int index)
        @param          index
        @return         void
        @description    Removes a product from the list at the specified index.
    *******************/
    public static void deleteItem(int index) {

        // Remove the product at the specified index
        products.remove(index);

    }

    /*******************
        editStock(int index, int newStock)
        @param          index
        @param          newStock
        @return         void
        @description    Updates the stock quantity of a product at the specified index.
    *******************/
    public static void editStock(int index, int newStock) {

        // Update the stock quantity of the product
        products.get(index).setQuantity(newStock);

    }

    /*******************
        printInventoryDatabase()
        @return         void
        @description    Prints all products' details in a formatted manner.
    *******************/
    public static void printInventoryDatabase() {

        // Loop through the product list and print each product's details

        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Product Number", "Quantity", "Price", "Product Name", "Product Description");
        System.out.println("**********************************************************************************************************************************************************************************************");

        for (Product products : products) {

            System.out.printf("%-25s%-25s%-25.2f%-25s%-25s\n", products.getProductNum(), products.getQuantity(), products.getPrice(), products.getName(), products.getDescription());

        }

    }
    
}
