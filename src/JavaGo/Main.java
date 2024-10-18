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
        // Creating default items, coffees and user accounts
        Item.createItems();
        Coffee.createCoffees();
        Payment.createUserAccounts();

        // Ordering process
        User.createUser(scanner);
    }
}
