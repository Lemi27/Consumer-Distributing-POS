# Consumers Distributing Point of Sale System

## Overview

This project implements a Point of Sale (POS) system inspired by Consumers Distributing, a retail store chain that operated from 1957 to 1996 in Canada and the United States. Consumers Distributing was known for its unique shopping experience where customers ordered products from a catalogue, and "Order Pickers" retrieved the items from the warehouse.

This Java-based POS system allows users to manage inventory, handle customer data, and process orders similar to the operations of the original Consumers Distributing stores. It utilizes text files to populate the database with customer and product information.

## Features

- **Inventory Management**: Add, remove, edit, and print items in the product catalogue.
- **Customer Management**: Add, remove, and print customer information.
- **Order Processing**: Create orders, check out, and print order details.
- **File Handling**: Read and write customer and product data from/to text files.
- **Text-based Interface**: User-friendly menu-driven interface for easy navigation.

## Getting Started

To run the POS system, make sure you have Java installed on your system.

1. Clone this repository:

    ```bash
    git clone https://github.com/your-username/consumers-distributing-pos.git
    ```

2. Navigate to the project directory:

    ```bash
    cd consumers-distributing-pos
    ```

3. Compile the Java files:

    ```bash
    javac main/java/consumersdistributing/*.java main/java/consumersdistributing/menus/*.java main/java/consumersdistributing/inventory/*.java main/java/consumersdistributing/customer/*.java main/java/consumersdistributing/pos/*.java main/java/consumersdistributing/utilities/*.java
    ```

4. Run the Main class:

    ```bash
    java main.java.consumersdistributing.Main
    ```

5. Follow the on-screen instructions to navigate through the menus and operate the POS system.

## Data Files

The system reads and writes customer and product data from/to text files:

- **Customers.txt**: Contains customer information in the format: ID, Phone Number, First Name, Last Name.
- **Catalogue.txt**: Contains product information in the format: Product Number, Quantity, Price, Name, Description.

Ensure these files exist and are properly formatted to populate the database.

## Notes

- This POS system is designed as a text-based simulation and may not fully replicate the functionalities of the original Consumers Distributing stores.
- Feel free to modify and extend the code to suit your needs or improve upon it.
