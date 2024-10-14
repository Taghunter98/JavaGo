package JavaGo;

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

    // main order method
    public static void order(int userId, String userName) {
        Terminal.clearTerminal();
        // menu
        Item.printItems();

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

                System.out.println("£" + total + " in total");

                // go back to menu
                Scanner numberScanner = new Scanner(System.in);
                Terminal.clearTerminal();
                Terminal.printDivider(50);
                Terminal.printHeader("Back to menu?");
                System.out.println("(1) Yes");
                System.out.println("(2) No");
                int input = numberScanner.nextInt();

                if (input == 1) {
                    Order.order(userId, userName);
                } else {
                    Terminal.printHeader("Checkout");
                    System.out.println("Order total: " + total);
                }
            } else {
                System.out.println("Invalid item");
            }
        }
    }
}
