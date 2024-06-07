/********************************************************
@author(s)          Lemi Miyu
@date               07-Jun-2024
@teacher            Andrew Carreiro
@file               CustomerManagement.java
@description        This class provides methods to manage a list of customers,
                    including adding, removing, retrieving, and printing customer details.
********************************************************/

package main.java.consumersdistributing.customer;

import java.util.ArrayList;

public class CustomerManagement {

    // ArrayList to hold Customer objects
    private static ArrayList<Customer> customers = new ArrayList<>();

    /*******************
        getCustomerList()
        @return         ArrayList<Customer>
        @description    Returns the list of all customers.
    *******************/
    public static ArrayList<Customer> getCustomerList() {

        // Return the list of customers
        return customers;

    }

    /*******************
        getCustomer(String id)
        @param          id
        @return         Customer
        @description    Searches for a customer by ID and returns the customer object.
    *******************/
    public static Customer getCustomer(String id) {

        // Loop through the customer list to find a customer by ID
        for (int i = 0; i < customers.size(); i++) {

            if (id.equals(customers.get(i).getId())) {

                // Return the found customer
                return customers.get(i);

            }

        }

        // Return null if no customer is found
        return null;

    }

    /*******************
        addCustomer(String id, String phoneNumber, String firstName, String lastName)
        @param          id
        @param          phoneNumber
        @param          firstName
        @param          lastName
        @return         void
        @description    Adds a new customer to the list with the provided details.
    *******************/
    public static void addCustomer(String id, String phoneNumber, String firstName, String lastName) {

        // Add a new customer to the list
        customers.add(new Customer(id, phoneNumber, firstName, lastName));

    }

    /*******************
        removeCustomer(int index)
        @param          index
        @return         void
        @description    Removes a customer from the list at the specified index.
    *******************/
    public static void removeCustomer(int index) {

        // Remove the customer at the specified index
        customers.remove(index);

    }

    /*******************
        printCustomerDatabase()
        @return         void
        @description    Prints all customers' details in a formatted manner.
    *******************/
    public static void printCustomerDatabase() {

        System.out.printf("%-25s%-25s%-25s%-25s\n", "ID", "Phone Number", "First Name", "Last Name");
        System.out.println("**********************************************************************************************************************************************************************************************");

        // Loop through the customer list and print each customer's details
        for (Customer customers : customers) {
            
            System.out.printf("%-25s%-25s%-25s%-25s\n", customers.getId(), customers.getPhoneNumber(), customers.getFirstName(), customers.getLastName());

        }

    }
    
}
