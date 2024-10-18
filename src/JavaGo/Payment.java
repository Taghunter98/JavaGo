package JavaGo;

import java.util.ArrayList;

public class Payment {
    private String name;
    private int pin;
    private String sortCode;
    private String accountNumber;
    private double balance;

    // List to store all user accounts
    private static ArrayList<Payment> userAccounts = new ArrayList<>();

    // Constructor
    public Payment(String name, int pin, String sortCode, String accountNumber, double balance) {
        this.name = name;
        this.pin = pin;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.balance = balance;

        // Add the newly created user to the list of accounts
        userAccounts.add(this);
    }

    // Getters for account information
    public int getPin() {
        return pin;
    }

    public String getSortCode() {
        return sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Method to get the list of user accounts
    public static ArrayList<Payment> getUserAccounts() {
        return userAccounts;
    }

    // Method to create sample user accounts
    public static void createUserAccounts() {
        Payment johnDoe = new Payment("John Doe",
                1234,
                "12-34-56",
                "12345678",
                1000
        );
        Payment joshBassett = new Payment("Josh Bassett",
                2545,
                "12-34-56",
                "12345678",
                5
        );
    }

    // Method to find a user account by pin
    public static Payment findAccountByPin(int pin) {
        for (Payment user : userAccounts) {
            if (user.getPin() == pin) {
                return user;
            }
        }
        return null;
    }
}
