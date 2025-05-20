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
        
        ShoppingTrolley myBag = new ShoppingTrolley(); //this is myBag. I can buy things to put in it 
        Scanner mykb = new Scanner(System.in); 
        
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
        
        //create generic store items 
        StoreItem toaster = new StoreItem("Toaster", 25.00); //electrical appliance
        StoreItem headphones = new StoreItem("Headphones", 75.00); //electronics
        StoreItem vacuumCleaner = new StoreItem("Vacuum Cleaner", 120.00); //home utility

        /*create a simple menu to let the user choose which category of items to buy */
        int option = 0;
        do {
            System.out.println("Welcome to the Supermarket!");
            System.out.println("Choose a category to buy from:");
            System.out.println("1. Food");
            System.out.println("2. Clothing");
            System.out.println("3. Drinks");
            System.out.println("4. Store Items");
            System.out.println("5. Finish shopping");

            try {
                option = mykb.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                mykb.nextLine(); //clear invalid input
                option = 0; //force repeat
                continue;
            }
/*We pass "mykb" and "myBag" as parameters to these methods 
because they were created in the main method and we want to keep using the same instances. 
This way, all items added in different methods go to the same trolley, and we use a single 
Scanner for user input throughout the program. 
If we created new objects inside each method, they would be different from the ones in 'main' 
 and we would lose the items or have multiple Scanners causing input issues.*/

            switch(option) {
                case 1:
                    buyFoodItem(mykb, myBag, milk, bread, cheese);
                    break;
                case 2:
                    buyClothingItem(mykb, myBag, tshirt, jeans, jacket);
                    break;
                case 3:
                    buyDrinkItem(mykb, myBag, wine, juice, beer, water);
                    break;
                case 4:
                    buyStoreItem(mykb, myBag, toaster, headphones, vacuumCleaner);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while(option != 5);

        displayItemsInTrolley(myBag); //this is a modularised method to print and empty the trolley
    }

    /*displays all items in the shopping trolley and empties it afterwards.*/
    public static void displayItemsInTrolley(ShoppingTrolley trolley) {
        System.out.println("Items in your trolley:");
        System.out.println(trolley.emptyTrolley());
    }

    /*method to display food items and let the user choose which one to buy*/
    public static void buyFoodItem(Scanner mykb, ShoppingTrolley myBag, FoodItem milk, FoodItem bread, FoodItem cheese) {
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
            case 1: howMany(mykb, myBag, milk); break;
             case 2: howMany(mykb, myBag, bread); break;
             case 3: howMany(mykb, myBag, cheese); break;
            case 4: break;
            default: System.out.println("Invalid choice.");
        }
    }

    /*method to display clothing items and let the user choose which one to buy*/
    public static void buyClothingItem(Scanner mykb, ShoppingTrolley myBag, ClothingItem tshirt, ClothingItem jeans, ClothingItem jacket) {
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
           case 1: howMany(mykb, myBag, tshirt); break;
           case 2: howMany(mykb, myBag, jeans); break;
            case 3: howMany(mykb, myBag, jacket); break;
           case 4: break;
            default: System.out.println("Invalid choice.");
        }
    }

    /*method to display drink items and let the user choose which one to buy, using addToTrolley to check age if needed*/
    public static void buyDrinkItem(Scanner mykb, ShoppingTrolley myBag, DrinkItem wine, DrinkItem juice, DrinkItem beer, DrinkItem water) {
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
            case 1: wine.addToTrolley(myBag); break;
            case 2: juice.addToTrolley(myBag); break;
           case 3: beer.addToTrolley(myBag); break;
            case 4: water.addToTrolley(myBag); break;
            case 5: break;
            default: System.out.println("Invalid choice.");
        }
    }

    /*method to display generic store items and let the user choose which one to buy*/
    public static void buyStoreItem(Scanner mykb, ShoppingTrolley myBag, StoreItem toaster, StoreItem headphones, StoreItem vacuumCleaner) {
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
           case 1: howMany(mykb, myBag, toaster); break;
            case 2: howMany(mykb, myBag, headphones); break;
           case 3: howMany(mykb, myBag, vacuumCleaner); break;
            case 4: break;
            default: System.out.println("Invalid choice.");
        }
    }

    /*method to ask how many units to add of a selected item*/
    public static void howMany(Scanner mykb, ShoppingTrolley myBag, StoreItem item) {
        System.out.print("How many do you want to buy? ");
        int quantity = 0;
        try {
            quantity = mykb.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Returning to main menu.");
            mykb.nextLine();
            return;
        }
        for (int i = 0; i < quantity; i++) {
            myBag.buyItem(item);
        }
    }
}
