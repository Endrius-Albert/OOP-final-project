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
        
    // Create a FoodItem object
    FoodItem milk = new FoodItem("Milk", 2.50, "10/06/2025");

    // Add the item to the shopping trolley
    myBag.buyItem(milk);

    //Print the trolley contents
    System.out.println("Items in your trolley:");
    System.out.println(myBag.emptyTrolley());

        
        
        /*
          YOU MUST COMPLETE THIS CODE - REMEMBER TO COMMENT WHAT YOU HAVE DONE AND TRY TO MODULARISE YOUR CODE (i.e. create your own methods)
        */
    }
    
}
