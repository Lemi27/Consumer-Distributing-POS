/********************************************************
@file               Util.java
@description        This class provides utility methods for input validation and formatting output.
********************************************************/

package main.java.consumersdistributing.utilities;

import java.util.Scanner;

public class Util {

    private static int x;
    private static double y;

    /*******************
        assureInput(Scanner uI)
        @param          uI Scanner object for input
        @return         int x - the validated integer input
        @description    Prevents program from crashing due to non-integer input.
    *******************/
    public static int assureInput(Scanner uI) {

        // loops while input is not an integer
        while (!uI.hasNextInt()) {

            System.out.println("Invalid input. Please try again.");
            uI.next();
                
        }

        x = uI.nextInt();
        uI.nextLine();

        return x;
    
    }

    /*******************
        assureDouble(Scanner uI)
        @param          uI Scanner object for input
        @return         double y - the validated double input
        @description    Prevents program from crashing due to non-double input.
    *******************/
    public static double assureDouble(Scanner uI) {

        while (!uI.hasNextDouble()) {

            System.out.println("Invalid input. Please try again.");
            uI.next();

        }

        y = uI.nextDouble();
        uI.nextLine();

        return y;

    }

    /*******************
        lineBreak()
        @description    Prints a line break to the terminal, allowing output to be more readable.
        @return         void
    *******************/
    public static void lineBreak() {

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
    
}
