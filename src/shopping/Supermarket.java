/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shopping;

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
            System.out.println("2. Clothing");
            System.out.println("3. Drinks");
            System.out.println("4. Store Items");
            System.out.println("5. View trolley");
            System.out.println("6. Finish shopping");

            try {
                option = mykb.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
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
     case 1:buyFoodItem(mykb, myBag, total, milk, bread, cheese);break;
     case 2:buyClothingItem(mykb, myBag, total, tshirt, jeans, jacket); break;
     case 3:buyDrinkItem(mykb, myBag, total, wine, juice, beer, water);break;
     case 4:buyStoreItem(mykb, myBag, total, toaster, headphones, vacuumCleaner);break;
     case 5:viewTrolley(myBag, total);break;
     case 6: break;
     default:System.out.println("Invalid option. Please try again.");}
     } while(option != 6);
        displayItemsInTrolley(myBag); 
    }

    /*displays all items in the shopping trolley and empties it afterwards.*/
    public static void displayItemsInTrolley(ShoppingTrolley trolley) {
        System.out.println("Items in your trolley:");
        System.out.println(trolley.emptyTrolley());
    }

    /*method to display food items and let the user choose which one to buy*/
    public static void buyFoodItem(Scanner mykb, ShoppingTrolley myBag, double[] total, FoodItem milk, FoodItem bread, FoodItem cheese) {
        System.out.println("Choose a food item to buy:");
        System.out.println("1. " + milk);
        System.out.println("2. " + bread);
        System.out.println("3. " + cheese);
        System.out.println("4. Cancel");
        int choice = 0;
        try {
            choice = mykb.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Returning to main menu.");
            mykb.nextLine();
            return;
        }
        switch(choice) {
            case 1: howMany(mykb, myBag, milk, total,0); break;
            case 2: howMany(mykb, myBag, bread, total,0); break;
            case 3: howMany(mykb, myBag, cheese, total,0); break;
            case 4: break;
            default: System.out.println("Invalid choice.");
        }
    }

    /*method to display clothing items and let the user choose which one to buy*/
    public static void buyClothingItem(Scanner mykb, ShoppingTrolley myBag, double[] total, ClothingItem tshirt, ClothingItem jeans, ClothingItem jacket) {
        System.out.println("Choose a clothing item to buy:");
        System.out.println("1. " + tshirt);
        System.out.println("2. " + jeans);
        System.out.println("3. " + jacket);
        System.out.println("4. Cancel");
        int choice = 0;
        try {
            choice = mykb.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Returning to main menu.");
            mykb.nextLine();
            return;
        }
        switch(choice) {
            case 1: howMany(mykb, myBag, tshirt, total,0); break;
            case 2: howMany(mykb, myBag, jeans, total,0); break;
            case 3: howMany(mykb, myBag, jacket, total,0); break;
            case 4: break;
            default: System.out.println("Invalid choice.");
        }
    }

    /*method to display drink items and let the user choose which one to buy, using addToTrolley to check age if needed*/
    public static void buyDrinkItem(Scanner mykb, ShoppingTrolley myBag, double[] total, DrinkItem wine, DrinkItem juice, DrinkItem beer, DrinkItem water) {
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
            System.out.println("Invalid input. Returning to main menu.");
            mykb.nextLine();
            return;
        }
       switch(choice) {
 /* The if checks if the age was okay and the first item was added.
 If yes, then we ask how many more the user wants to add*/   
    case 1: if (wine.addToTrolley(myBag)){ howMany(mykb, myBag, wine, total,1);} break;
    case 2: if (juice.addToTrolley(myBag)) {howMany(mykb, myBag, juice, total,1);}break;
    case 3: if (beer.addToTrolley(myBag)) {howMany(mykb, myBag, beer, total,1);}break;
    case 4:if (water.addToTrolley(myBag)) {howMany(mykb, myBag, water, total,1);}break;
    case 5: break;
    default: System.out.println("Invalid choice.");
}

    }

    /*method to display generic store items and let the user choose which one to buy*/
    public static void buyStoreItem(Scanner mykb, ShoppingTrolley myBag, double[] total, StoreItem toaster, StoreItem headphones, StoreItem vacuumCleaner) {
        System.out.println("Choose a store item to buy:");
        System.out.println("1. " + toaster);
        System.out.println("2. " + headphones);
        System.out.println("3. " + vacuumCleaner);
        System.out.println("4. Cancel");
        int choice = 0;
        try {
            choice = mykb.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Returning to main menu.");
            mykb.nextLine();
            return;
        }
        switch(choice) {
            case 1: howMany(mykb, myBag, toaster, total,0); break;
            case 2: howMany(mykb, myBag, headphones, total,0); break;
            case 3: howMany(mykb, myBag, vacuumCleaner, total,0); break;
            case 4: break;
            default: System.out.println("Invalid choice.");
        }
    }

    /*method to ask how many units to add
    I created this added parameter because when I was buying drinks the system already added 1, 
    and then asked how many they wanted, so I can control how many will be purchased with the change min.*/
  public static void howMany(Scanner mykb, ShoppingTrolley myBag, StoreItem item, double[] total, int added) {
    System.out.print("How many do you want to buy? ");
    int quantity = 0;
    try {
        quantity = mykb.nextInt();
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero. Returning to main menu.");
            return;
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Returning to main menu.");
        mykb.nextLine();
        return;
    }
    for (int i = 0; i < quantity - added; i++) {
        myBag.buyItem(item);
        total[0] += item.getPrice();
    }
}
    
/*method that shows the items without empty it. 
 I used "double[] total" instead of a simple double because Java passes primitive types by value
this means that if we passed a regular double to a method, any changes made inside the method
would not affect the original variable in main. By using an array, Java passes a reference to the original data. 
This allows all methods to update the same total value through total[0],
keeping the overall amount accurate throughout the program.*/
    public static void viewTrolley(ShoppingTrolley trolley, double[] total) {
        System.out.println("Your Items:");
        System.out.println(trolley.showItems()); 
        System.out.printf("Total: €%.2f\n", total[0]); 
    }
}
 