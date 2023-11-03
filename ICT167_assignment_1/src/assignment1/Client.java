package assignment1;

import java.util.Scanner;

import assignment1.ChangeC;

/**
 * Calculation Change Program
 * Author: HUYNH THIEN PHU
 * Date: 24TH JUNE 2023
 * File Name: Client.java
 * 
 * Purpose: provide a user interface for interacting with the ChangeC objects. It displays a menu of options 
 * for performing different operations on the change objects, such as entering a name and displaying the 
 * change, finding the smallest or largest amount, calculating the total number of coins, and calculating the 
 * total amount for all denominations. The Client class also includes utility methods for finding specific 
 * ChangeC objects based on name or coin amount, as well as checking for duplicate names. It serves as the 
 * entry point for the program and coordinates the execution of different operations based on user input. 
 * 
 * Assumptions/Conditions: The program assumes that the user will input valid data as per the program's
 * prompts. The coin values and number of denominations are fixed as per the COIN_VALUES and
 * NUM_COIN_DENOMINATIONS constants.
 */

public class Client {
    public static void main(String[] args) {
        ChangeC[] changeArray = new ChangeC[10];
        Scanner sc = new Scanner(System.in);

        // Student information display
        studentInformation();

        String name;
        int coinAmount;
        int count = 0;

        System.out.println("=======================================");
        System.out.println("O-O design implemented program starting");
        System.out.println("=======================================");
        
        System.out.println("Enter at least 10 records to run the program");

        // while loop to be enter at least 2 record from user to run the program
        while (count < 10) {
            System.out.println("Please enter the person's name: ");
            name = sc.nextLine();

            // Check if the name is duplicates
            if (isExitName(changeArray, name)) {
                System.out.println("The name already exists. Please enter a new name: ");
                continue;
            }

            System.out.println("Please enter the coin value for the person: ");
            coinAmount = sc.nextInt();
            sc.nextLine();

            ChangeC change = new ChangeC(name, coinAmount);
            changeArray[count] = change;
            count++;

            // Check if still have more person to input 
            System.out.println("Do you have more persons to enter? (Y/N)");
            String res = sc.nextLine().toUpperCase();
            if (!res.equals("Y")) {
                break;
            }
        }

        // Open the second While loop to start display menu and process the choice from user
        int choice = 0;
        while (choice != 6) {
            menuDisplay();
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
            
            	// Menu choice option 1
                case 1:
                    System.out.println("Enter the name of the person, and the program will display the coin amount and the coin change for that person");
                    System.out.println("Please enter the name of the person: ");
                    String findName = sc.next();
                    ChangeC personChange = displayChangeForPerson(changeArray, findName);
                    if (personChange != null) {
                        System.out.println("Person name: " + personChange.getName());
                        System.out.println("Coin Amount: " + personChange.getCoinAmount() + " pence");
                        System.out.println("Change:");
                        personChange.displayChange();
                    } else {
                        System.out.println(findName + " name");
                        System.out.println("Not found");
                    }
                    break;

                // Menu choice option 2
                case 2:
                    ChangeC smallestAmount = displaySmallestAmount(changeArray);
                    if (smallestAmount != null) {
                        System.out.println("Person with the smallest amount: " + smallestAmount.getName());
                        System.out.println("Coin amount: " + smallestAmount.getCoinAmount());
                        System.out.println("Change:");
                        smallestAmount.displayChange();
                    }
                    break;

                // Menu choice option 3
                case 3:
                    ChangeC largestAmount = displayLargestAmount(changeArray);
                    if (largestAmount != null) {
                        System.out.println("Person with the largest amount: " + largestAmount.getName());
                        System.out.println("Coin amount: " + largestAmount.getCoinAmount());
                        System.out.println("Change:");
                        largestAmount.displayChange();
                    }
                    break;v

                // Menu choice option 4
                case 4:
                    totalCoinCalculate(changeArray);
                    break;

                // Menu choice option 5
                case 5:
                    totalAmountCalculate(changeArray);
                    break;

                // Menu choice option 6
                case 6:
                    System.out.println("You have exited the system program! \nThank you and see you soon");
                    break;

                // DEfault option if invalid choice was choose
                default:
                    System.out.println("Invalid choice. Please enter a valid menu option.");
                    continue;
            }
        }
    }

    
    /**
     * Displays student information.
     */
    public static void studentInformation() {
        System.out.println("Title: ICT167 Assignment 1");
        System.out.println("Author / Student Name: Huynh Thien Phu");
        System.out.println("Student ID: 34237012");
        System.out.println("Unit Code: ICT167");
        System.out.println("Unit Name: Principles of Computer Science");
        System.out.println("Professor: Kelvin Wong");
        System.out.println("File Name: Client.java");
        System.out.println("Purpose: Provide a user interface for interacting with the ChangeC objects.\n It displays a menu of options for performing different operations on the change objects, such as entering \n a name and displaying the change, finding the smallest or largest amount, calculating the total number of \n coins, and calculating the total amount for all denominations. The Client class also includes utility \n methods for finding specific ChangeC objects based on name or coin amount, as well as checking for duplicate \n names. It serves as the entry point for the program and coordinates the execution of different operations \n based on user input.");
        System.out.println("Date: 24th June 2023");
    }

    
    
    /**
     * Checks if the name already exists in the changeArray.
     *
     * @param changeArray The array of ChangeC objects.
     * @param name        The name to be checked.
     * @return True if the name already exists, False otherwise.
     */
    public static boolean isExitName(ChangeC[] changeArray, String name) {
        for (int i = 0; i < changeArray.length; i++) {
            ChangeC change = changeArray[i];
            if (change != null && change.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    
    
    /**
     * Displays the menu options.
     */
    public static void menuDisplay() {
    	System.out.println("==============================================");
        System.out.println("\nMenu Display");
        System.out.println("1. Enter a name and display change to be given for each denomination");
        System.out.println("2. Find the name with the smallest amount and display change to be given for each denomination");
        System.out.println("3. Find the name with the largest amount and display change to be given for each denomination");
        System.out.println("4. Calculate and display the total number of coins for each denomination");
        System.out.println("5. Calculate and display the total amount (i.e., NOT the total number of coins) for the sum of all denominations");
        System.out.println("6. Exit");
    }

    
    
//    --------------------------------------------------------------------------------------------------------------------------------------------------
//    5 Options display menu logic function
    
    
    
    /** Option 1
     * Finds and returns the ChangeC object for the given name.
     *
     * @param changeArray The array of ChangeC objects.
     * @param name        The name to search for.
     * @return The ChangeC object with the given name, or null if not found.
     */
    public static ChangeC displayChangeForPerson(ChangeC[] changeArray, String name) {
        for (int i = 0; i < changeArray.length; i++) {
            ChangeC change = changeArray[i];
            if (change != null && change.getName().equals(name)) {
                return change;
            }
        }
        return null;
    }

    
    
    /** Option 2
     * Finds and returns the ChangeC object with the smallest coin amount.
     *
     * @param changeArray The array of ChangeC objects.
     * @return The ChangeC object with the smallest coin amount, or null if not found.
     */
    public static ChangeC displaySmallestAmount(ChangeC[] changeArray) {
        ChangeC smallestAmount = null;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < changeArray.length; i++) {
            ChangeC change = changeArray[i];
            if (change != null && change.getCoinAmount() < min) {
                smallestAmount = change;
                min = change.getCoinAmount();
            }
        }
        return smallestAmount;
    }

    
    
    /** Option 3
     * Finds and returns the ChangeC object with the largest coin amount.
     *
     * @param changeArray The array of ChangeC objects.
     * @return The ChangeC object with the largest coin amount, or null if not found.
     */
    public static ChangeC displayLargestAmount(ChangeC[] changeArray) {
        ChangeC largestAmount = null;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < changeArray.length; i++) {
            ChangeC change = changeArray[i];
            if (change != null && change.getCoinAmount() > max) {
                largestAmount = change;
                max = change.getCoinAmount();
            }
        }
        return largestAmount;
    }

    
    
    /** Option 4
     * Calculates and displays the total number of coins for each denomination.
     *
     * @param changeArray The array of ChangeC objects.
     */
    private static void totalCoinCalculate(ChangeC[] changeArray) {
        int[] totalCoin = new int[8];

        for (int i = 0; i < changeArray.length; i++) {
            ChangeC change = changeArray[i];
            if (change != null) {
                int[] coins = change.calculateChange();
                for (int j = 0; j < totalCoin.length; j++) {
                    totalCoin[0] += coins[0];
                    totalCoin[1] += coins[1];
                    totalCoin[2] += coins[2];
                    totalCoin[3] += coins[3];
                    totalCoin[4] += coins[4];
                    totalCoin[5] += coins[5];
                    totalCoin[6] += coins[6];
                    totalCoin[7] += coins[7];
                }
            }
        }

        System.out.println("Total number of coins for each denomination");
        System.out.println("1p: " + totalCoin[0]);
        System.out.println("2p: " + totalCoin[1]);
        System.out.println("5p: " + totalCoin[2]);
        System.out.println("10p: " + totalCoin[3]);
        System.out.println("20p: " + totalCoin[4]);
        System.out.println("50p: " + totalCoin[5]);
        System.out.println("£1: " + totalCoin[6]);
        System.out.println("£2: " + totalCoin[7]);
    }

    
    
    /** Option 5
     * Calculates and displays the total amount for all denominations.
     *
     * @param changeArray The array of ChangeC objects.
     */
    private static void totalAmountCalculate(ChangeC[] changeArray) {
        int totalAmount = 0;
        for (int i = 0; i < changeArray.length; i++) {
            ChangeC change = changeArray[i];
            if (change != null) {
                totalAmount += change.getCoinAmount();
            }
        }
        System.out.println("Total amount for all denominations is: " + totalAmount + " pence");
    }
}
