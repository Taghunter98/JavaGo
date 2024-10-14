package JavaGo;

import java.util.ArrayList;

public class Coffee extends Item{

    /*
    The Coffee class has specific fields.
    - milkType is the type of milk used
    - beanType is the type of bean for different flavour
     */
    public String milkType;
    public String beanType;

    // array to store coffees
    static ArrayList<Coffee> coffees = new ArrayList<>();

    // constructor for Coffee class
    public Coffee(String itemName, String itemDes, int itemCal, boolean hasAllergy, String milkType, String beanType) {
        super(itemName, itemDes, itemCal, hasAllergy);

        this.milkType = milkType;
        this.beanType = beanType;


        // add to list
        coffees.add(this);
    }

    /*
    Accessor methods for Coffee class
    - get milkType
    - getbeanType
     */

    // get milk type
    public String getMilkType() {
        return milkType;
    }

    // get bean type
    public String getBeanType() {
        return beanType;
    }

    // Print coffee information
    public static void printCoffee(String itemName) {
        for (Coffee coffee : coffees) {
            if (coffee.getItemName().equalsIgnoreCase(itemName)) {
                System.out.println("Item Name: " + coffee.getItemName());
                System.out.println("Description: " + coffee.getItemDes());
                System.out.println("Calories: " + coffee.getItemCal());
                System.out.println("Allergen Info: " + (coffee.hasAllergy() ? "Contains allergens" : "No allergens"));
                System.out.println("Item ID: " + coffee.getItemID());
                System.out.println("Milk Type: " + coffee.getMilkType());
                System.out.println("Bean Type: " + coffee.getBeanType());
                return; // Exit after printing the found item
            }
        }
        System.out.println("Coffee item not found!");
    }
}

