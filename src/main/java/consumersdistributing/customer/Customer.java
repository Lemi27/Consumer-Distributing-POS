/********************************************************
@author             Lemi Miyu
@date               07-Jun-2024
@teacher            Andrew Carreiro
@file               Customer.java
@description        This class represents a Customer with attributes such as id,
                    first name, last name, and phone number. It includes methods 
                    for getting and setting these attributes, as well as a method 
                    for generating a unique customer ID.
********************************************************/

package main.java.consumersdistributing.customer;

public class Customer {

    // CLASS VARIABLES
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private static int x;
    private static boolean idExists;

    /*******************
        Customer(String id, String phoneNumber, String firstName, String lastName)
        @param          id
        @param          phoneNumber
        @param          firstName
        @param          lastName
        @description    Constructor to initialize the customer with given details.
    *******************/
    public Customer(String id, String phoneNumber, String firstName, String lastName) {

        // Initialize the customer with given details
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

    }

    /*******************
        getId()
        @return         String
        @description    Returns the ID of the customer.
    *******************/
    public String getId() {
        return this.id;
    }

    /*******************
        getFirstName()
        @return         String
        @description    Returns the first name of the customer.
    *******************/
    public String getFirstName() {
        return this.firstName;
    }

    /*******************
        getLastName()
        @return         String
        @description    Returns the last name of the customer.
    *******************/
    public String getLastName() {
        return this.lastName;
    }

    /*******************
        getPhoneNumber()
        @return         String
        @description    Returns the phone number of the customer.
    *******************/
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /*******************
        setId(String id)
        @param          id
        @return         void
        @description    Sets the ID of the customer.
    *******************/
    public void setId(String id) {
        this.id = id;
    }

    /*******************
        setFirstName(String firstName)
        @param          firstName
        @return         void
        @description    Sets the first name of the customer.
    *******************/
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*******************
        setLastName(String lastName)
        @param          lastName
        @return         void
        @description    Sets the last name of the customer.
    *******************/
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*******************
        setPhoneNumber(String phoneNumber)
        @param          phoneNumber
        @return         void
        @description    Sets the phone number of the customer.
    *******************/
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*******************
        generateId()
        @return         String
        @description    Generates a unique customer ID.
    *******************/
    public static String generateId() {

        // Repeat the loop if the ID exists for any customer
        do {

            idExists = false; 
            x = (int)(Math.random() * 900000 + 100000);

            // Check if the generated ID exists for any customer
            for (Customer customer : CustomerManagement.getCustomerList()) {

                // Repeats outer loop if generated ID is already assigned
                if (customer.getId().equals(String.valueOf(x))) {

                    idExists = true; 
                    break; 

                }

            }

        } while (idExists);

        // Return the generated ID
        return String.valueOf(x);

    }
    
}
