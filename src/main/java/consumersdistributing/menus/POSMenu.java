/********************************************************
@author             Lemi Miyu
@date               07-Jun-2024
@teacher            Andrew Carreiro
@file               POSMenu.java
@description        This class handles the menu for POS operations including order
                    creation, order review, and checkout.
********************************************************/

package main.java.consumersdistributing.menus;

import java.io.FileNotFoundException;
import java.util.Scanner;

import main.java.consumersdistributing.ConsumerDistributingPOS;
import main.java.consumersdistributing.customer.CustomerManagement;
import main.java.consumersdistributing.inventory.InventoryManagement;
import main.java.consumersdistributing.pos.POS;
import main.java.consumersdistributing.utilities.Util;

public class POSMenu {

    private static String menuSelection;
    private static Scanner userInput = new Scanner(System.in);
    private static String customerId;
    private static String productId;
    private static String customerName;
    private static String productName;
    private static int quantityOrdered;
    
    /*******************
        posMenu()
        @return         void
        @description    Displays and handles the POS menu options.
    *******************/
    public static void posMenu() throws FileNotFoundException {

        do {

            // USER INPUT: Prompt the user for menu selection
            System.out.println("Would you like to navigate to:\n1. Order desk\n2. Order pick display\n3. Check out\n4. Go back to the previous menu");
            menuSelection = userInput.next();

            userInput.nextLine();
            Util.lineBreak();

            // Menu: Handle the menu selection
            switch (menuSelection) {

                case "1":
                    
                    // Order desk
                    System.out.println("Enter the customer's ID:");
                    customerId = userInput.next();

                    userInput.nextLine();
                    Util.lineBreak();

                    // Check if the customer exists
                    if (CustomerManagement.getCustomer(customerId) == null) {

                        System.out.println("Customer does not exist. Please try again or create a new customer.");
                        Util.lineBreak();
                        break;

                    }

                    do {

                        // Ensure the order list is initialized and the customer exists
                        if (POS.getOrderList().size() >= 0 && !(CustomerManagement.getCustomer(customerId) == null)) {

                            customerName = CustomerManagement.getCustomer(customerId).getFirstName() + " " + CustomerManagement.getCustomer(customerId).getLastName();
                            Util.lineBreak();

                        }

                        System.out.println("Enter the product ID:");
                        productId = userInput.next();

                        userInput.nextLine();
                        Util.lineBreak();

                        // Check if the product exists
                        if (InventoryManagement.getProductWithId(productId) == null) {

                            System.out.println("Product does not exist. Please try again or add a new product.");
                            Util.lineBreak();
                            break;

                        } else {

                            productName = InventoryManagement.getProductWithId(productId).getName();

                        }

                        System.out.println("Enter the quantity the customer is ordering:");
                        quantityOrdered = Util.assureInput(userInput);

                        // Check if there is enough stock
                        if (quantityOrdered > InventoryManagement.getProductList().get(InventoryManagement.getProductList().indexOf(InventoryManagement.getProductWithId(productId))).getQuantity()) {

                            System.out.printf("Not enough stock to add this to order. Do you want to order %d instead? (y/n): ", InventoryManagement.getProductList().get(InventoryManagement.getProductList().indexOf(InventoryManagement.getProductWithId(productId))).getQuantity());

                            if (userInput.next().equals("y")) {

                                quantityOrdered = InventoryManagement.getProductList().get(InventoryManagement.getProductList().indexOf(InventoryManagement.getProductWithId(productId))).getQuantity();
                                userInput.nextLine();

                            } else {

                                System.out.println("Invalid stock to add to order. Returning to menu.");
                                Util.lineBreak();
                                break;
                            }

                        }

                        Util.lineBreak();

                        // Add order to POS
                        POS.addOrder(customerName, productName, InventoryManagement.getProductWithId(productId).getQuantity(), quantityOrdered, InventoryManagement.getProductWithId(productId).getPrice());

                        Util.lineBreak();

                        System.out.println("Item successfully added to order. Would you like to add more items to your cart? (y/n)");

                        menuSelection = userInput.next();

                        userInput.nextLine();

                    } while (menuSelection.equals("y"));

                    Util.lineBreak();

                    break;

                case "2":

                    // Order pick display
                    POS.printOrderPick();
                    break;

                case "3":

                    // Check out or cancel order
                    do {

                        System.out.println("Would you like to:\n1. Check out\n2.Cancel order");
                        menuSelection = userInput.next();

                        userInput.nextLine();
                        Util.lineBreak();

                        switch (menuSelection) {

                            case "1":
                                
                                // Check out if there are items in the cart
                                if (POS.getOrderList().size() > 0) {

                                    POS.checkout();

                                } else {

                                    System.out.println("There are no items in the cart. Please add items to order to checkout.");
                                    Util.lineBreak();
                                    POSMenu.posMenu();

                                }

                                break;

                            case "2":

                                // Cancel order and clear the order list
                                POS.getOrderList().clear();
                                Util.lineBreak();
                                posMenu();
                                break;
                        
                            default:

                                // Error case (invalid input)
                                System.out.println("Invalid input. Please try again.");
                                Util.lineBreak();
                                break;
                        }

                    } while (!menuSelection.equals("1") || !menuSelection.equals("2"));

                    Util.lineBreak();

                    break;

                case "4":

                    // Go back to the previous menu
                    ConsumerDistributingPOS.firstMenu();
                    Util.lineBreak();
                    break;

                default:
                    
                    // Error case (invalid input)
                    System.out.println("Invalid input. Please try again.");
                    Util.lineBreak();
                    break;

            }

        } while (true);

    }

}
