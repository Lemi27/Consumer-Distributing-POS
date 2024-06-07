/********************************************************
@author             Lemi Miyu
@date               07-Jun-2024
@teacher            Andrew Carreiro
@file               CustomerManagementMenu.java
@description        This class provides a menu interface for managing customers.
                    It allows users to add, remove, print customers, or go back to 
                    the previous menu.
********************************************************/

package main.java.consumersdistributing.menus;

import java.io.FileNotFoundException;
import java.util.Scanner;

import main.java.consumersdistributing.ConsumerDistributingPOS;
import main.java.consumersdistributing.customer.Customer;
import main.java.consumersdistributing.customer.CustomerManagement;
import main.java.consumersdistributing.utilities.Util;

public class CustomerManagementMenu {
    
    private static String menuSelection;
    private static Scanner userInput = new Scanner(System.in);
    private static String customerId;
    private static String firstName;
    private static String lastName;
    private static String phoneNumber;

    /*******************
        storeManagementMenu()
        @return         void
        @description    Displays and handles the customer management menu options.
    *******************/
    public static void storeManagementMenu() throws FileNotFoundException {

        do {

            // USER INPUT: Prompt the user for menu selection
            System.out.println("Would you like to navigate to:\n1. Add a customer\n2. Remove a customer\n3. Print customer directory\n4. Go back to the previous menu");
            menuSelection = userInput.next();

            Util.lineBreak();

            // Handle the menu selection
            switch (menuSelection) {

                case "1":
                    
                    // Add a customer
                    System.out.println("Enter the customer's phone number:");
                    phoneNumber = userInput.next();

                    userInput.nextLine();
                    Util.lineBreak();

                    System.out.println("Enter the customer's first name:");
                    firstName = userInput.next();

                    userInput.nextLine();
                    Util.lineBreak();

                    System.out.println("Enter the customer's last name:");
                    lastName = userInput.next();

                    // Generate a unique customer ID and add the customer
                    CustomerManagement.addCustomer(Customer.generateId(), phoneNumber, firstName, lastName);

                    userInput.nextLine();
                    Util.lineBreak();

                    System.out.println("Customer successfully added to the directory.");

                    Util.lineBreak();

                    break;

                case "2":

                    // Remove a customer
                    System.out.println("Enter the ID of the customer you would like to remove:");
                    customerId = userInput.next();

                    // Check if the customer exists
                    if (CustomerManagement.getCustomer(customerId) == null) {

                        System.out.println("Customer does not exist. Please try again or add a new customer.");
                        Util.lineBreak();
                        break;

                    } else {

                        userInput.nextLine();
                        Util.lineBreak();

                        // Remove the customer
                        CustomerManagement.removeCustomer(CustomerManagement.getCustomerList().indexOf(CustomerManagement.getCustomer(customerId)));

                        Util.lineBreak();

                        System.out.println("Customer successfully removed from the directory.");

                        Util.lineBreak();

                        break;

                    }

                case "3":

                    // Print the customer directory
                    CustomerManagement.printCustomerDatabase();
                    Util.lineBreak();
                    break;

                case "4":

                    // Go back to the previous menu
                    ConsumerDistributingPOS.firstMenu();
                    break;
            
                default:

                    // Handle invalid input
                    System.out.println("Invalid input. Please try again.");
                    Util.lineBreak();
                    break;

            }

        // Loop until a valid option (1-4) is selected
        } while (true);

    }

}
