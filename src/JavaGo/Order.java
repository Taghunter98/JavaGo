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
    - orderNumber is a randomly generated number
    - serverName is the name of the server
    - paymentSuccess is a boolean that checks if the user can pay
     */
    public static double total;
    private String orderNumber;
    private String serverName;
    private boolean paymentSuccess;
    public static String orderID;
    public Item item;
    static Scanner input = new Scanner(System.in);

    // main order method
    public static void order() {
        Terminal.clearTerminal();

        // menu
        Item.printItems();
        checkItem();


    }

    // check item exists
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
                item = String.valueOf(item1);
                backToMenu();
            }
        }
        return item;
    }

    // back to menu method
    public static void backToMenu() {
        // go back to menu
        Terminal.clearTerminal();
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

        Terminal.printDivider(50);
        Terminal.printHeader("card payment");

        System.out.println("Please enter your pin");
        int pin = input.nextInt();

    }
}
