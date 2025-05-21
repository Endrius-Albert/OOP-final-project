/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shopping;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kheal
 */
public class Supermarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<StoreItem> itemsInTrolley = new ArrayList<>();
        ShoppingTrolley myBag = new ShoppingTrolley(); 
        Scanner mykb = new Scanner(System.in); 
        double[] total = {0.0}; 
        
        //create a food itens object 
        FoodItem milk = new FoodItem("Milk", 2.50, "10/06/2025");
        FoodItem bread = new FoodItem("Bread", 1.80, "09/06/2025");
        FoodItem cheese = new FoodItem("Cheddar Cheese", 3.75, "15/06/2025");

        //create clothing itens objects
        ClothingItem tshirt = new ClothingItem("T-shirt", 15.00, "M", "Cotton");
        ClothingItem jeans = new ClothingItem("Jeans", 45.00, "L", "Denim");
        ClothingItem jacket = new ClothingItem("Jacket", 80.00, "XL", "Leather");

        //create drink itens objects
        DrinkItem wine = new DrinkItem("Red Wine", 12.00, "750ml", true);
        DrinkItem juice = new DrinkItem("Orange Juice", 3.00, "1L", false);
        DrinkItem beer = new DrinkItem("Craft Beer", 5.50, "500ml", true);
        DrinkItem water = new DrinkItem("Water", 2.00, "2L", false);
        
        //create store items 
        StoreItem toaster = new StoreItem("Toaster", 25.00); //electrical appliance
        StoreItem headphones = new StoreItem("Headphones", 75.00); //electronics
        StoreItem vacuumCleaner = new StoreItem("Vacuum Cleaner", 120.00); //home utility

        /*create menu to let the user choose which category of items to buy */
        int option = 0;
        do {
            System.out.println("Welcome to the Supermarket!");
            System.out.println("Choose a category to buy from:");
            System.out.println("1. Food");
            System.out.println("2. Drinks");
            System.out.println("3. Clothing");
            System.out.println("4. Store Items");
            System.out.println("5. View trolley");
            System.out.println("6. Finish shopping");

            try {
                option = mykb.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid. Please enter a number.");
                mykb.nextLine(); //clear invalid input
                option = 0; //force repeat
                continue;
            }
/*I passed "mykb" and "myBag" as parameters to these methods 
because they were created in the main method and we want to keep using the same instances. 
This way, all items added in different methods go to the same trolley, and we use a single 
Scanner for user input throughout the program. 
If we created new objects inside each method, they would be different from the ones in "main"
 and we would lose the items or have multiple Scanners causing input issues.*/

   switch(option) {
     case 1:buyFoodItem(mykb, myBag, total, milk, bread, cheese, itemsInTrolley);break;
     case 2:buyDrinkItem(mykb, myBag, total, wine, juice, beer, water, itemsInTrolley);break;
     case 3:buyClothingItem(mykb, myBag, total, tshirt, jeans, jacket, itemsInTrolley); break;
     case 4:buyStoreItem(mykb, myBag, total, toaster, headphones, vacuumCleaner, itemsInTrolley);break;
     case 5:
    total[0] = 0;
    for (StoreItem item : itemsInTrolley) {
        total[0] += item.getPrice();
    }
    trolleyMenu(mykb, myBag, total, itemsInTrolley);
    break;
     case 6:
    System.out.printf("Total: €%.2f\n", total[0]);
        System.out.println(" ");
    displayItemsInTrolley(myBag); 
    break;

     default:System.out.println("Invalid option. Please try again.");}
     } while(option != 6);
        displayItemsInTrolley(myBag); 
    }

    /*displays all items in the shopping trolley and empties it afterwards.*/
    public static void displayItemsInTrolley(ShoppingTrolley trolley) {
    System.out.println("Items in your trolley:");
    String list = trolley.emptyTrolley();
    System.out.println(list);
    }

    /*method to display food items and let the user choose which one to buy*/
    public static void buyFoodItem(Scanner mykb, ShoppingTrolley myBag, double[] total, FoodItem milk, FoodItem bread, FoodItem cheese, ArrayList<StoreItem> itemsInTrolley) {
        System.out.println("Choose a food item to buy:");
        System.out.println("1. " + milk);
        System.out.println("2. " + bread);
        System.out.println("3. " + cheese);
        System.out.println("4. Cancel");
        int choice = 0;
        try {
            choice = mykb.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid. Returning to main menu.");
            mykb.nextLine();
            return;
        }
        switch(choice) {
            case 1: howMany(mykb, myBag, milk, total, itemsInTrolley); break;
            case 2: howMany(mykb, myBag, bread, total, itemsInTrolley); break;
            case 3: howMany(mykb, myBag, cheese, total, itemsInTrolley); break;
            case 4: break;
            default: System.out.println("Invalid choice.");
        }
    }

    /*method to display clothing items and let the user choose which one to buy*/
    public static void buyClothingItem(Scanner mykb, ShoppingTrolley myBag, double[] total, ClothingItem tshirt, ClothingItem jeans, ClothingItem jacket, ArrayList<StoreItem> itemsInTrolley) {
        System.out.println("Choose a clothing item to buy:");
        System.out.println("1. " + tshirt);
        System.out.println("2. " + jeans);
        System.out.println("3. " + jacket);
        System.out.println("4. Cancel");
        int choice = 0;
        try {
            choice = mykb.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid. Returning to main menu.");
            mykb.nextLine();
            return;
        }
        switch(choice) {
            case 1: howMany(mykb, myBag, tshirt, total, itemsInTrolley); break;
            case 2: howMany(mykb, myBag, jeans, total, itemsInTrolley); break;
            case 3: howMany(mykb, myBag, jacket, total, itemsInTrolley); break;
            case 4: break;
            default: System.out.println("Invalid choice.");
        }
    }

    /*method to display drink items and let the user choose which one to buy, using addToTrolley to check age if needed*/
    public static void buyDrinkItem(Scanner mykb, ShoppingTrolley myBag, double[] total, DrinkItem wine, DrinkItem juice, DrinkItem beer, DrinkItem water, ArrayList<StoreItem> itemsInTrolley) {
        System.out.println("Choose a drink item to buy:");
        System.out.println("1. " + wine);
        System.out.println("2. " + juice);
        System.out.println("3. " + beer);
        System.out.println("4. " + water);
        System.out.println("5. Cancel");
        int choice = 0;
        try {
            choice = mykb.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid. Returning to main menu.");
            mykb.nextLine();
            return;
        }
       switch(choice) {
 /* The if checks if the age was okay and the first item was added.
 If yes, then we ask how many more the user wants to add*/   
        case 1: if (wine.addToTrolley()) { howMany(mykb, myBag, wine, total, itemsInTrolley); } break;
        case 2: if (juice.addToTrolley()) { howMany(mykb, myBag, juice, total, itemsInTrolley); } break;
        case 3: if (beer.addToTrolley()) { howMany(mykb, myBag, beer, total, itemsInTrolley); } break;
        case 4: if (water.addToTrolley()) { howMany(mykb, myBag, water, total, itemsInTrolley); } break;
        case 5: break;
    default: System.out.println("Invalid choice.");
}

    }

    /*method to display store items and let the user choose which one to buy*/
    public static void buyStoreItem(Scanner mykb, ShoppingTrolley myBag, double[] total, StoreItem toaster, StoreItem headphones, StoreItem vacuumCleaner, ArrayList<StoreItem> itemsInTrolley) {
        System.out.println("Choose a store item to buy:");
        System.out.println("1. " + toaster);
        System.out.println("2. " + headphones);
        System.out.println("3. " + vacuumCleaner);
        System.out.println("4. Cancel");
        int choice = 0;
        try {
            choice = mykb.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid. Returning to main menu.");
            mykb.nextLine();
            return;
        }
        switch(choice) {
            case 1: howMany(mykb, myBag, toaster, total, itemsInTrolley); break;
            case 2: howMany(mykb, myBag, headphones, total, itemsInTrolley); break;
            case 3: howMany(mykb, myBag, vacuumCleaner, total, itemsInTrolley); break;
            case 4: break;
            default: System.out.println("Invalid choice.");
        }
    }

    /*method to ask how many units to add*/
public static void howMany(Scanner mykb, ShoppingTrolley myBag, StoreItem item, double[] total, ArrayList<StoreItem> itemsInTrolley) {
    System.out.print("How many do you want to buy? ");
    int quantity = 0;
    try {
        quantity = mykb.nextInt();
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero. Returning to main menu.");
            return;
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid. Returning to main menu.");
        mykb.nextLine();
        return;
    }
    for (int i = 0; i < quantity; i++) {
        myBag.buyItem(item);
        itemsInTrolley.add(item);
        total[0] += item.getPrice();
    }

}

    
/*method that shows the items without empty it. 
 I used "double[] total" instead of a simple double because Java passes primitive types by value
this means that if we passed a regular double to a method, any changes made inside the method
would not affect the original variable in main. By using an array, Java passes a reference to the original data. 
This allows all methods to update the same total value through total[0],
keeping the overall amount accurate throughout the program.*/
   public static void trolleyMenu(Scanner mykb, ShoppingTrolley myBag, double[] total, ArrayList<StoreItem> items) {
    int choice = 0;
    do {
        System.out.println("Your trolley contains:");
        if (items.isEmpty()) {
            System.out.println("Your trolley is empty.");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
            System.out.printf("Total: €%.2f\n", total[0]);//displays the total value formatted to two decimal places
            System.out.println(" ");
        }
        System.out.println("Choose an option:");
        System.out.println("1. Remove item");
        System.out.println("2. Continue shopping");
        System.out.println("3. Finish purchase");

        try {
            choice = mykb.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid. Please enter a number.");
            mykb.nextLine();
            continue;
        }
        switch(choice) {
            case 1:
                if (items.isEmpty()) {
                    System.out.println("Nothing to remove. Your trolley is empty.");
                } else {
                    System.out.println("Enter the number of the item to remove:");
                    int removeIndex = 0;
                    try {
                        removeIndex = mykb.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid.");
                        mykb.nextLine();
                        break;
                    }
                    if (removeIndex < 1 || removeIndex > items.size()) {
                        System.out.println("Invalid item number.");
                    } else {
                       StoreItem removed = items.remove(removeIndex - 1);
                        total[0] -= removed.getPrice();
                        System.out.println("Removed " + removed.getName() + " from your trolley.");
                            myBag.emptyTrolley();
                            for (StoreItem item : items) {
                            myBag.buyItem(item);
                  }
                    }
                }
                break;
            case 2:
                System.out.println("Returning to main menu to continue shopping...");
                choice = 3;
                break;
            case 3:
                System.out.println("Thank you for your purchase!");
                 System.out.printf("Total: €%.2f\n", total[0]);
                     System.out.println(" ");
                displayItemsInTrolley(myBag);
                System.exit(0);
                break;
           
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while(choice != 3);
}

}
 