package JavaGo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Order {
    /*
    Order Class
    - User needs to browse menu
    - User then will add items to basket
    - User will then be asked if they want to buy more or checkout
    - User will checkout and be asked for payment information
    - Receipt will then be printed

    Fields
    - total is the sum of all items
    - paymentSuccess is a boolean that checks if the user can pay
    - orderID is the randomly generated order ID number
     */
    public static double total;
    private boolean paymentSuccess;
    public static String orderID;
    public static String serverName;
    static Scanner input = new Scanner(System.in);

    // list for shopping bag
    static ArrayList<String> bag = new ArrayList<>();

    // main order method
    public static void order() {
        Terminal.clearTerminal();

        // menu
        Item.printItems();
        checkItem();
    }

    // check if item exists with improved search and user selection for multiple items
    public static void checkItem() {
        // ask user what they want
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose an item: ");
        String inputItem = scanner.nextLine().toLowerCase();

        ArrayList<Item> matchedItems = new ArrayList<>();

        // search for items that contains the input text
        for (Item item1 : Item.items) {
            if (item1.itemName.toLowerCase().contains(inputItem)) {
                matchedItems.add(item1);
            }
        }

        // If matches are found, display them
        if (!matchedItems.isEmpty()) {
            System.out.println("Found " + matchedItems.size() + " item(s):");

            // Print out all matching items
            for (int i = 0; i < matchedItems.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + matchedItems.get(i).getItemName());
            }

            // If there is more than one match, ask the user to choose
            if (matchedItems.size() > 1) {
                System.out.println("Please choose an item number from the list: ");
                int choice = scanner.nextInt();

                // Ensure the user's choice is within range
                if (choice > 0 && choice <= matchedItems.size()) {
                    Item selectedItem = matchedItems.get(choice - 1);
                    addToBag(selectedItem);
                } else {
                    System.out.println("Invalid choice. Returning to menu.");
                    backToMenu();
                }
            } else {
                // If only one match, automatically add it to the bag
                Item selectedItem = matchedItems.get(0);
                addToBag(selectedItem);
            }

        } else {
            // If no matches found, suggest trying again
            System.out.println("No items found with the name '" + inputItem + "'.");
            backToMenu();
        }
    }

    // method to add to bag
    public static void addToBag(Item item) {
        bag.add(item.getItemName());
        total += item.getPrice();
        System.out.println(item.getItemName() + " added to bag. Total: £" + total);
        backToMenu();
    }



    // back to menu method
    public static void backToMenu() {
        // go back to menu
        Terminal.printHeader("Back to menu?");
        System.out.println("(1) Yes");
        System.out.println("(2) No");
        int userInput = input.nextInt();

        if (userInput == 1) {
            order();

        } else {
            checkout();
        }
    }


    // generate random ID
    public static String orderNum() {
        String randID;
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
        for (int i = 0; i < 5; i++) {
            sb.append(chars[rnd.nextInt(chars.length)]);
            randID = sb.toString();
            orderID = randID;
        }
        return orderID;
    }

    // checkout
    public static void checkout() {
        Scanner scanner = new Scanner(System.in);

        Terminal.clearTerminal();
        Terminal.printHeader("Checkout");

        System.out.println("Who served you today?: ");
        serverName = scanner.nextLine();

        payment();
    }

    public static void payment() {
        Terminal.clearTerminal();
        Terminal.printHeader("Payment");

        // Ask for the pin
        System.out.println("Please enter your pin: ");
        int enteredPin = input.nextInt();

        // Find the account by pin
        Payment user = Payment.findAccountByPin(enteredPin);

        if (user != null) {
            // Proceed with other checks (sort code, account number)
            System.out.println("Please enter your Sort Code: ");
            String enteredSortCode = input.next();

            if (enteredSortCode.equals(user.sortCode())) {
                System.out.println("Please enter your Account Number: ");
                String enteredAccountNumber = input.next();

                if (enteredAccountNumber.equals(user.accountNumber())) {
                    printReceipt();
                } else {
                    System.out.println("Invalid Account Number.");
                    payment();
                }
            } else {
                System.out.println("Invalid Sort Code.");
                payment();
            }
        } else {
            System.out.println("Invalid pin.");
            payment();
        }
    }

    // method to generate receipt
    public static void printReceipt() {
        Terminal.clearTerminal();
        Terminal.printHeader("Javago");
        System.out.println("Your server today was " + serverName);
        System.out.println("Order Number: " + Order.orderNum());
        System.out.println();
        System.out.println();

        // print out all items of bag
        for(int i = 0; i < bag.size(); i++) {
            System.out.println("Item: " + bag.get(i) + " " + (i + 1));
            Terminal.printDivider(50);
        }

        // print total
        System.out.println();
        System.out.println();
        System.out.println();
        Terminal.printDivider(50);
        System.out.println("Total Price: " + total);
    }
}
