/********************************************************
@author             Lemi Miyu
@date               07-Jun-2024
@teacher            Andrew Carreiro
@file               FileHandling.java
@description        This class handles reading and writing customer and product data
                    to and from text files.
********************************************************/

package main.java.consumersdistributing.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import main.java.consumersdistributing.customer.Customer;
import main.java.consumersdistributing.customer.CustomerManagement;
import main.java.consumersdistributing.inventory.InventoryManagement;
import main.java.consumersdistributing.inventory.Product;

public class FileHandling {

    private static String id;
    private static String phoneNumber;
    private static String firstName;
    private static String lastName;
    private static String productNum;
    private static int quantity;
    private static double price;
    private static String name;
    private static String description;
    private static File customerFile;
    private static Scanner diskScanner;
    private static File productFile;
    private static PrintWriter diskWriter;

    /*******************
        readCustomerData()
        @return         void
        @description    Reads customer data from a file and adds them to CustomerManagement.
    *******************/
    public static void readCustomerData() {

        try {

            customerFile = new File("Customers.txt");
            diskScanner = new Scanner(customerFile);
            diskScanner.useDelimiter(",|\r\n|\r|\n");

            while (diskScanner.hasNext()) {

                id = diskScanner.next();
                phoneNumber = diskScanner.next();
                firstName = diskScanner.next();
                lastName = diskScanner.next();

                CustomerManagement.addCustomer(id, phoneNumber, firstName, lastName);

            }

            diskScanner.close(); // close scanner

        } catch (FileNotFoundException e) {

            System.err.print(e);

        }

    }

    /*******************
        readProductData()
        @return         void
        @description    Reads product data from a file and adds them to InventoryManagement.
    *******************/
    public static void readProductData() {

        try {

            productFile = new File("Catalogue.txt");
            diskScanner = new Scanner(productFile);
            diskScanner.useDelimiter(",|\r\n|\r|\n");

            while (diskScanner.hasNext()) {

                productNum = diskScanner.next();
                quantity = diskScanner.nextInt();
                price = diskScanner.nextDouble();
                name = diskScanner.next();
                description = diskScanner.next();

                InventoryManagement.addItem(productNum, quantity, price, name, description);

            }

            diskScanner.close(); // close scanner

        } catch (FileNotFoundException e) {

            System.err.print(e);

        }

    }

    /*******************
        writeCustomerData()
        @return         void
        @description    Writes customer data from CustomerManagement to a file.
    *******************/
    public static void writeCustomerData() throws FileNotFoundException {

        diskWriter = new PrintWriter("Customers.txt");
      
        for (Customer customers : CustomerManagement.getCustomerList()) {

            diskWriter.printf("%s,%s,%s,%s\n", customers.getId(), customers.getPhoneNumber(), customers.getFirstName(), customers.getLastName());
        }
     
        diskWriter.close();

    }

    /*******************
        writeProductData()
        @return         void
        @description    Writes product data from InventoryManagement to a file.
    *******************/
    public static void writeProductData() throws FileNotFoundException {

        diskWriter = new PrintWriter("Catalogue.txt");
      
        for (Product products : InventoryManagement.getProductList()) {

            diskWriter.printf("%s,%s,%s,%s,%s\n", products.getProductNum(), products.getQuantity(), products.getPrice(), products.getName(), products.getDescription());
        }
     
        diskWriter.close();

    }
    
}
