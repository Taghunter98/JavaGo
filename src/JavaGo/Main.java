package JavaGo;

import java.util.Scanner;

public class Main {
    /*
    Created by @Josh and @Mos on 10/10/24
    Repo available at: https://github.com/Taghunter98/JavaGo
    JavaGo version 1.0
     */

    // user input
    static Scanner scanner = new Scanner(System.in);

    // build project
    public static void main(String[] args) {;
        User.createUser(scanner);

        // Creating item instances
        Item coffee = new Item("Coffee", "Hot brewed coffee", 5, false);
        Item muffin = new Item("Muffin", "Blueberry muffin", 350, true);

        // coffee type arrays
        String[] milkTypes = {"Cows Milk", "Oat Milk", "Soya Milk"};
        String[] beanTypes = {"Arabica", "Robusta", "Liberica", "Excelsa"};

        // coffees
        Coffee cappuccino = new Coffee(
                "Cappuccino",
                "Cappuccino with regular milk",
                180,
                true,
                milkTypes[0],beanTypes[0]
        );
        Coffee latte = new Coffee(
                "Latte",
                "Latte with regular milk",
                170,
                true,
                milkTypes[0],beanTypes[1]
        );


        // Get user input to print the item details
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the item to display details: ");
        String input = scanner.nextLine();

        // Print item details based on user input
        Coffee.printCoffee(input);
    }
}
