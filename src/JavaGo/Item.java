package JavaGo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Item {
    /*
    The Item class contains the basic information for all items sold on the system.
    - itemName is the name of the item
    - itemDes is the description - this will appear on the terminal
    - itemCal is the total calories of the item TODO crate class for this
    - price is the price of the item
    - hasAllergy checks if item has any allergens
     */
    public String itemName;
    public String itemDes;
    public double itemPrice;
    public String itemID;
    public int itemCal;
    boolean hasAllergy;

    // item lists
    static ArrayList<Item> items = new ArrayList<>();
    static String randID;

    // constructor for Items
    public Item(String itemName, String itemDes, double itemPrice, int itemCal, boolean hasAllergy) {

        // Generate random ID, for example 283952-V8M32
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
        for (int i = 0; i < 5; i++) {
            sb.append(chars[rnd.nextInt(chars.length)]);
            randID = sb.toString();
        }

        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDes = itemDes;
        this.itemID = randID;
        this.itemCal = itemCal;
        this.hasAllergy = hasAllergy;

        items.add(this);
    }

    public static void createItems() {
        // Pastries and snacks
        Item croissant = new Item("Croissant",
                "Fresh buttery croissant",
                2.95,
                200,
                false
        );
        Item sandwich = new Item("Ham Sandwich",
                "Ham and cheese sandwich",
                5.50,
                350,
                true
        );
        Item cookie = new Item("Chocolate Chip Cookie",
                "Large cookie with chocolate chips",
                3.50,
                250,
                true
        );
        Item fruitSalad = new Item("Fruit Salad",
                "Mixed fruit salad",
                4.20,
                150,
                false
        );

        // Add to items list
        items.add(croissant);
        items.add(sandwich);
        items.add(cookie);
        items.add(fruitSalad);
    }

    /*
    Accessor methods for Item class
    - getItemName returns item name
    - getItemDes returns item description
    - getItemID returns item ID
    - get itemCal returns item's calories
    - get allergy returns boolean for item allergy
     */

    // get name
    public String getItemName() {
        return itemName;
    }

    // get item description
    public String getItemDes() {
        return itemDes;
    }

    // get item price
    public double getPrice() {
        return itemPrice;
    }

    // get item ID
    public String getItemID() {
        return itemID;
    }

    // get item calories
    public int getItemCal() {
        return itemCal;
    }

    // get allergy
    public boolean hasAllergy() {
        return hasAllergy;
    }

    // get array items
    public ArrayList<Item> getItems() {
        return items;
    }

    // Method to print each item out
    public static void printItems() {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            System.out.println("Item Name: " + item.getItemName() + "\nDescription: " + item.getPrice());
            System.out.println("Calories: " + item.getItemCal());
            Terminal.printDivider(50);
        }
    }

}

