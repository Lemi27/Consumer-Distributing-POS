/********************************************************
@author             Lemi Miyu
@date               07-Jun-2024
@teacher            Andrew Carreiro
@file               InventoryManagementMenu.java
@description        This class provides a menu interface for managing the inventory.
                    It allows users to add, remove, print products, edit stock, 
                    or go back to the previous menu.
********************************************************/

package main.java.consumersdistributing.menus;

import java.io.FileNotFoundException;
import java.util.Scanner;

import main.java.consumersdistributing.ConsumerDistributingPOS;
import main.java.consumersdistributing.inventory.InventoryManagement;
import main.java.consumersdistributing.inventory.Product;
import main.java.consumersdistributing.utilities.Util;

public class InventoryManagementMenu {
    
    private static String menuSelection;
    private static Scanner userInput = new Scanner(System.in);
    private static String productId;
    private static double price;
    private static int quantity;
    private static String productName;
    private static String productDescription;

    /*******************
        posMenu()
        @return         void
        @description    Displays and handles the inventory management menu options.
    *******************/
    public static void posMenu() throws FileNotFoundException {

        do {

            // USER INPUT: Prompt the user for menu selection
            System.out.println("Would you like to navigate to:\n1. Add new product to catalogue\n2. Remove product from catalogue\n3. Print catalogue\n4. Edit the number of items in stock for an item\n5. Go back to previous menu");
            menuSelection = userInput.next();
            userInput.nextLine();

            // PROCESSING: Add a line break for readability
            Util.lineBreak();

            // Menu: Handle the menu selection
            switch (menuSelection) {

                case "1":
                    
                    // Adds a new product to catalogue
                    System.out.println("Enter product quantity:");
                    quantity = Util.assureInput(userInput);

                    Util.lineBreak();

                    System.out.println("Enter product price:");
                    price = Util.assureDouble(userInput);

                    Util.lineBreak();

                    System.out.println("Enter product name:");
                    productName = userInput.nextLine();

                    Util.lineBreak();

                    System.out.println("Enter product description:");
                    productDescription = userInput.nextLine();

                    Util.lineBreak();

                    // Add the new product to inventory
                    InventoryManagement.addItem(Product.generateProductNum(), quantity, price, productName, productDescription);

                    System.out.println("Product successfully added to the catalogue.");

                    Util.lineBreak();

                    break;

                case "2":

                    // Removes a product from catalogue
                    System.out.println("Enter the ID of the product you would like to remove:");
                    productId = userInput.next();

                    userInput.nextLine();
                    Util.lineBreak();

                    // Check if the product exists
                    if (InventoryManagement.getProductWithId(productId) == null) {

                        System.out.println("Product does not exist. Please try again or add a new product.");
                        Util.lineBreak();
                        break;

                    } else {

                        // Remove the product from inventory
                        InventoryManagement.deleteItem(InventoryManagement.getProductList().indexOf(InventoryManagement.getProductWithId(productId)));

                        System.out.println("Product successfully removed from the catalogue.");

                        Util.lineBreak();

                        break;

                    }

                case "3":

                    // Prints catalogue
                    InventoryManagement.printInventoryDatabase();

                    Util.lineBreak();

                    break;

                case "4":

                    // Edits the number of items in stock for a product
                    System.out.println("Enter the ID of the product to change its stock:");
                    productId = userInput.next();

                    // Check if the product exists
                    if (InventoryManagement.getProductWithId(productId) == null) {

                        System.out.println("Product does not exist. Please try again or add a new product.");
                        Util.lineBreak();
                        break;

                    } else {

                        userInput.nextLine();
                        Util.lineBreak();

                        System.out.println("Enter the new stock of this product:");
                        quantity = Util.assureInput(userInput);

                        Util.lineBreak();

                        // Update the product stock
                        InventoryManagement.editStock(InventoryManagement.getProductList().indexOf(InventoryManagement.getProductWithId(productId)), quantity);

                        Util.lineBreak();

                        System.out.println("Product stock successfully changed.");

                        Util.lineBreak();

                        break;

                    }

                case "5":

                    // Goes back to the parent menu
                    ConsumerDistributingPOS.firstMenu();
                    break;
            
                default:

                    // Error case (invalid input)
                    System.out.println("Invalid input. Please try again.");
                    Util.lineBreak();
                    break;

            }

        // Loop until a valid option (1-5) is selected
        } while (true);

    }

}
