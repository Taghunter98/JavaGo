package JavaGo;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class User {
    /*
    These are the fields for the user class.
    - name is the name given for the user
    - id will be generated once the user is created
    - hasAllergy will either be true or false depending on user choice
     */
    public String name;
    public int id;
    boolean hasAllergy = false;

    // user creation fields
    Scanner scanner = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<User>();

    // constructor for User
    public User(String name,int id,boolean hasAllergy) {
        this.name = name;
        this.id = id;
        this.hasAllergy = hasAllergy;
    }

    /*
    Accessor methods will return values from User
    - getName returns name of user
    - getId returns ID of user
    - getAllergy returns boolean if user has allergy
     */

    // return name
    public String getName() {
        return name;
    }

    // return ID
    public int getId() {
        return id;
    }

    // return allergy
    public boolean hasAllergy() {
        return hasAllergy;
    }

    /*
    Method to create a new user.
    This will be the first thing someone does when using the kiosk.
    User will be asked for name and allergy.
    User ID will be generated.
     */

    public static void createUser(Scanner scanner) {
        /*
        This function generates a random ID.
        The ID needs to be 10 characters long.
        The ID is made up of numbers.
        */
        int userId;
        Random rnd = new Random();
        userId = 100000000 + rnd.nextInt(900000000);

        Terminal.clearTerminal();
        Terminal.printHeader("Welcome to Javago");
        System.out.println("Please enter your name: ");
        String userName = scanner.next();
        Terminal.printDivider(50);
        System.out.println("Do you have an allergy? \n(1) Yes \n(2) No:");
        String allergy = scanner.next();
        boolean userAllergy = false;

        if (allergy.equals("1")) {
            userAllergy = true;
        }
        else if (allergy.equals("2")) {
            userAllergy = false;
        }

        // create new user and add to the array list TODO add to db
        User newUser = new User(userName,userId,userAllergy);
        users.add(newUser);

        System.out.println(newUser.getId());

        // function that moves user to next step
        Order.order(userId,userName);
    }


}

