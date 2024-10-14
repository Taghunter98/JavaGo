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
    public static void main(String[] args) {

        // Creating item instances
        Item coffee = new Item("Coffee", "Hot brewed coffee", 4.95 ,5, false);
        Item muffin = new Item("Muffin", "Blueberry muffin", 4.95,350, true);

        // coffee type arrays
        String[] milkTypes = {"Cows Milk", "Oat Milk", "Soy Milk"};
        String[] beanTypes = {"Arabica", "Robusta", "Liberica", "Excelsa"};

        // coffees
        Coffee cappuccino = new Coffee(
                "Cappuccino",
                "Cappuccino with regular milk",
                4.95,
                180,
                true,
                milkTypes[0],beanTypes[0]
        );
        Coffee latte = new Coffee(
                "Latte",
                "Latte with regular milk",
                5.30,
                170,
                true,
                milkTypes[0],beanTypes[1]
        );

        // Ordering process
        User.createUser(scanner);
    }
}
