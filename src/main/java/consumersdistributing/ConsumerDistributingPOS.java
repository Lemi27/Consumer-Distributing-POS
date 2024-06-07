/********************************************************
@file               ConsumerDistributingPOS.java
@description        This class represents the main point of entry for the Consumers Distributing POS system. 
                    It allows navigation through different menus and handles program termination.
********************************************************/

package main.java.consumersdistributing;

import java.io.FileNotFoundException;
import java.util.Scanner;

import main.java.consumersdistributing.menus.InventoryManagementMenu;
import main.java.consumersdistributing.menus.POSMenu;
import main.java.consumersdistributing.menus.CustomerManagementMenu;
import main.java.consumersdistributing.utilities.FileHandling;
import main.java.consumersdistributing.utilities.Util;

public class ConsumerDistributingPOS {

    private static String menuSelection;
    private static Scanner userInput = new Scanner(System.in);

    /*******************
        ConsumerDistributingPOS()
        @description        Constructor for ConsumerDistributingPOS class. 
                            Initializes the system and displays the main menu.
        @throws             FileNotFoundException if data files are not found
    *******************/
    public ConsumerDistributingPOS() throws FileNotFoundException {

        // Reading data
        FileHandling.readCustomerData();
        FileHandling.readProductData();

        ConsumerDistributingPOS.firstMenu();

    }

    /*******************
        firstMenu()
        @description        Displays the main menu and handles user input to navigate through different options.
        @throws             FileNotFoundException if data files cannot be written
    *******************/
    public static void firstMenu() throws FileNotFoundException {

        // Infinitely loops menu unless user chooses to exit
        do {

            // USER INPUT
            System.out.println("Would you like to navigate to:\n1. Inventory Management\n2. Customer Management\n3. Purchasing\n4. End program");
            menuSelection = userInput.next();

            // PROCESSING

            userInput.nextLine();
            Util.lineBreak();

            // Menu
            switch (menuSelection) {

                // Redirects user to inventory management menu
                case "1":
                    
                    InventoryManagementMenu.posMenu();
                    break;

                // Redirects user to store management menu
                case "2":

                    CustomerManagementMenu.storeManagementMenu();
                    break;

                case "3":

                    POSMenu.posMenu();
                    break;

                // Ends program
                case "4":

                    // Writing data
                    FileHandling.writeCustomerData();
                    FileHandling.writeProductData();

                    System.exit(0);

                    break;
            
                // Error case (invalid input)
                default:

                    System.out.println("Invalid input. Please try again.");
                    Util.lineBreak();
                    break;

            }
        
        } while (!menuSelection.equals("1") || !menuSelection.equals("2") || !menuSelection.equals("3") || !menuSelection.equals("4"));

    }
    
}
