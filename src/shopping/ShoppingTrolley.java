/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import java.util.ArrayList;  //Cloning test

/**
 * A simple ShoppingTrolley
 * 
 * Stores items in an ArrayList
 * 
 * Possible to add  items
 * Also can "empty" the trolley
 * 
 * You should NOT need to amend this code at all!
 * 
 * NOTE: 'Object' is the main base class for everything in Java. This means that everything 'is an' Object
 * ANy class you create will work with the shopping trolley - you don't need to change this code!
 * 
 * @author Ken
 */
public class ShoppingTrolley {
    
    private ArrayList<Object> items;
    
    /**
     * Create a shopping bag by initialising the items to an empty arraylist
     */
    public ShoppingTrolley(){
        
        items = new ArrayList<Object>();
    }
    
    /**
     * Add an item to the shopping trolley
     * @param someItem the item that has been bought
     */
    public void buyItem(Object someItem){
        
        this.items.add(someItem);
    }
    
 
    /**
     * create a formatted String containing all the items in the ShoppingTrolley
     * @return the formatted String
     * Also clears the items list -- 'empties the bag'
     */
    public String emptyTrolley(){
        
        String itemList = "";
        
        for(Object item: this.items){
            
            itemList = itemList + item.toString() + "\n";
        }
        
        this.items.clear();
        
        return itemList;
    }
}
