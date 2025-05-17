/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shopping;

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
        
        //create a food itens object 
        FoodItem milk = new FoodItem("Milk", 2.50, "10/06/2025");
        FoodItem bread = new FoodItem("Bread", 1.80, "09/06/2025");
        FoodItem cheese = new FoodItem("Cheddar Cheese", 3.75, "15/06/2025");

        //add the new food itens to the shopping trolley
        myBag.buyItem(bread);
        myBag.buyItem(cheese);
        myBag.buyItem(milk);
        
        //create clothing itens objects
        ClothingItem tshirt = new ClothingItem("T-shirt", 15.00, "M", "Cotton");
        ClothingItem jeans = new ClothingItem("Jeans", 45.00, "L", "Denim");
        ClothingItem jacket = new ClothingItem("Jacket", 80.00, "XL", "Leather");

        //add the clothing items to the shopping trolley
        myBag.buyItem(tshirt);
        myBag.buyItem(jeans);
        myBag.buyItem(jacket);

        //create drink itens objects
        DrinkItem wine = new DrinkItem("Red Wine", 12.00, "750ml", true);
        DrinkItem juice = new DrinkItem("Orange Juice", 3.00, "1L", false);
        DrinkItem beer = new DrinkItem("Craft Beer", 5.50, "500ml", true);
        DrinkItem water = new DrinkItem("Water", 2.00, "2L", false);

        //add the drink items to the shopping trolley using addToTrolley() method to check the age
        wine.addToTrolley(myBag);
        juice.addToTrolley(myBag);
        beer.addToTrolley(myBag);
        water.addToTrolley(myBag);
        
        //print the trolley contents
        displayItemsInTrolley(myBag); //this is a modularised method to print and empty the trolley
        
        /*
          YOU MUST COMPLETE THIS CODE - REMEMBER TO COMMENT WHAT YOU HAVE DONE AND TRY TO MODULARISE YOUR CODE (i.e. create your own methods)
        */
    }

    /*Displays all items in the shopping trolley and empties it afterwards.*/
    public static void displayItemsInTrolley(ShoppingTrolley trolley) {
        System.out.println("Items in your trolley:");
        System.out.println(trolley.emptyTrolley());
    }
}