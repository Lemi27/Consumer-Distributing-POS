/********************************************************
@author             Lemi Miyu
@date               07-Jun-2024
@teacher            Andrew Carreiro
@file               POS.java
@description        This class handles the point of sale (POS) operations, managing the
                    order list, adding orders, printing order details, and processing
                    checkout operations.
********************************************************/

package main.java.consumersdistributing.pos;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import main.java.consumersdistributing.inventory.InventoryManagement;
import main.java.consumersdistributing.menus.POSMenu;
import main.java.consumersdistributing.utilities.Util;

public class POS {

    private static ArrayList<Order> order = new ArrayList<>();
    private static double total;
    private static int quantityOrdered;
    
    /*******************
        getOrderList()
        @return         ArrayList<Order>
        @description    Returns the list of orders.
    *******************/
    public static ArrayList<Order> getOrderList() {
        
        return order;

    }

    /*******************
        addOrder(String customerName, String productName, int stock, int quantityOrdered, double price)
        @param customerName     The name of the customer
        @param productName      The name of the product
        @param stock            The available stock of the product
        @param quantityOrdered  The quantity of product ordered
        @param price            The price of the product
        @description    Adds an order to the list.
    *******************/
    public static void addOrder(String customerName, String productName, int stock, int quantityOrdered, double price) {

        order.add(new Order(customerName, productName, stock, quantityOrdered, price));

    }

    /*******************
        printOrderPick()
        @return         void
        @description    Prints the order pick display.
    *******************/
    public static void printOrderPick() {

        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Customer Name", "Product Name", "Stock", "Quantity Ordered", "Price per Unit");
        System.out.println("**********************************************************************************************************************************************************************************************");

        for (Order order : order) {

            System.out.printf("%-25s%-25s%-25s%-25s%-25.2f\n", order.getCustomerName(), order.getProductName(), order.getStock(), order.getQuantityOrdered(), order.getPrice());

        }

    }

    /*******************
        checkout()
        @return         void
        @description    Processes the checkout, updates inventory, calculates total,
                        and prints the order details.
    *******************/
    public static void checkout() throws FileNotFoundException {

        for (int i = 0; i < order.size(); i++) {

            quantityOrdered = order.get(i).getQuantityOrdered();

            total += quantityOrdered * order.get(i).getPrice();
            InventoryManagement.itemSold(InventoryManagement.getProductList().indexOf(InventoryManagement.getProductWithName(order.get(i).getProductName())), quantityOrdered);

        }
        
        total *= 1.13; // Applying 13% tax

        POS.printOrderPick();

        Util.lineBreak();

        System.out.println("**********");
        System.out.printf("Total (with 13%% tax): $%.2f\n", total);
        System.out.println("**********");

        System.out.println("Order successfully completed. Returning to the previous menu.");

        order.clear(); // Clearing the order list after checkout

        POSMenu.posMenu(); // Return to POS menu

    } 

}
