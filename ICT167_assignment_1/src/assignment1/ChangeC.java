package assignment1;

/**
 * Calculation Change Program
 * Author: HUYNH THIEN PHU
 * Date: 24TH JUNE 2023
 * File Name: ChangeC.java
 * 
 * Purpose: Represent a change object that stores information about a person's name and the amount of change 
 * they have in different denominations of coins. The class provides methods to calculate and display the 
 * change to be given for each denomination, as well as retrieve and update the coin amount.
 * 
 * Assumption/Conditions: The program assumes that the user will input valid data as per the program's
 * prompts. The coin values and number of denominations are fixed as per the COIN_VALUES and
 * NUM_COIN_DENOMINATIONS constants.
 */

public class ChangeC {
    private String name;
    private int coinAmount;
    private int[] coinDenomination;
    
    
    // Constructor
    public ChangeC(String name, int coinAmount) {
        this.name = name;
        this.coinAmount = coinAmount;
        this.coinDenomination = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public int getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(int coinAmount) {
        this.coinAmount = coinAmount;
    }
    
    
    
    /**
     * Displays the change breakdown for the given coin amount.
     */
    public void displayChange() {
        int[] coinDivide = calculateChange();

        // Display the change for each denomination in descending order
        for (int i = coinDenomination.length - 1; i >= 0; i--) {
            if (coinDivide[i] > 0) {
                System.out.println(getDenominationString(coinDenomination[i]) + ": " + coinDivide[i]);
            }
        }
    }

    
    
    /**
     * Calculates the change breakdown for the given coin amount.
     * Returns an array representing the number of coins for each denomination.
     */
    public int[] calculateChange() {
        int[] coinChange = new int[coinDenomination.length];
        int remainAmount = coinAmount;

        // Iterate over each denomination in descending order
        for (int i = coinDenomination.length - 1; i >= 0; i--) {
            coinChange[i] = remainAmount / coinDenomination[i]; // Calculate the number of coins for the current denomination
            remainAmount %= coinDenomination[i]; // Update the remaining amount
        }
        return coinChange;
    }

    
    
    /**
     * Returns the denomination as a string representation.
     * Denominations less than 100 are represented as pence (e.g., 1p, 50p),
     * while denominations of 100 or greater are represented as pounds (e.g., £1, £2).
     */
    private String getDenominationString(int denomination) {
        if (denomination < 100) {
            return denomination + "P";
        } else {
            return "£" + (denomination / 100);
        }
    }
}
