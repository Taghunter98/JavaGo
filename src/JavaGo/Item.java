package JavaGo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

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
    public String itemID;
    public int itemCal;
    boolean hasAllergy;

    // item lists
    static ArrayList<Item> items = new ArrayList<>();
    static String randID;

    // constructor for Items
    public Item(String itemName, String itemDes, int itemCal, boolean hasAllergy) {

        // Generate random ID, for example 283952-V8M32
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
        for (int i = 0; i < 5; i++) {
            sb.append(chars[rnd.nextInt(chars.length)]);
            randID = sb.toString();
        }

        this.itemName = itemName;
        this.itemDes = itemDes;
        this.itemID = randID;
        this.itemCal = itemCal;
        this.hasAllergy = hasAllergy;

        items.add(this);
    }

    public Item(String itemName, String itemDes, int itemCal, boolean hasAllergy, String milkType, String beanType) {
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

    // Method to print item details
    public static void printItem(String itemName) {
        Iterator<Item> it = items.iterator();
        if (it.hasNext()) {
            Item item = it.next();
            if (item.getItemName().contains(itemName)) {
                System.out.println("Item Name: " + item.getItemName());
                System.out.println("Description: " + item.getItemDes());
                System.out.println("Calories: " + item.getItemCal());
                System.out.println("Allergen Info: " + (item.hasAllergy() ? "Contains allergens" : "No allergens"));
                System.out.println("Item ID: " + item.getItemID());
            }
        } else {
            System.out.println("Item not found");
        }
    }

}

