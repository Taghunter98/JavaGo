package JavaGo;

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
    static Scanner input = new Scanner(System.in);

    // main order method
    public static void order() {
        Terminal.clearTerminal();

        // menu
        Item.printItems();
        checkItem();
    }

    // check item exists TODO add check for if item is invalid
    public static String checkItem() {
        // ask user what they want
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose an item: ");
        String item = scanner.nextLine();

        // check to see if item exists
        for (Item item1 : Item.items) {

            // check input matches name
            if (item.equals(item1.itemName)) {
                String itemNa = item1.itemName;
                System.out.println(itemNa + " added to bag");

                // update total
                double itemVal = item1.getPrice();
                total += itemVal;
                System.out.println("Total: " + total);
                item = String.valueOf(item1);
                backToMenu();
            }
        }
        return item;
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
        String server = scanner.nextLine();

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

            if (enteredSortCode.equals(user.getSortCode())) {
                System.out.println("Please enter your Account Number: ");
                String enteredAccountNumber = input.next();

                if (enteredAccountNumber.equals(user.getAccountNumber())) {
                    Terminal.printHeader("Success");
                } else {
                    System.out.println("Invalid Account Number.");
                    payment();  // Retry
                }
            } else {
                System.out.println("Invalid Sort Code.");
                payment();  // Retry
            }
        } else {
            System.out.println("Invalid pin.");
            payment();  // Retry
        }
    }


}
