/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

import java.util.Scanner;

/**
 *
 * @author endri
 */
public class DrinkItem extends StoreItem {
    private String volume;
    private boolean alcoholic;

    public DrinkItem(String name, double price, String volume, boolean alcoholic) {
        super(name, price);
       this.volume = volume;
        this.alcoholic = alcoholic;
    }

    public String getVolume() {
        return volume;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    /*Attempts to add this drink to the shopping trolley
      If alcoholic, asks the user for age and only adds if the person is older then 18.
      If it`s not alcoholic adds directly.*/
    public boolean addToTrolley(ShoppingTrolley trolley) {
        Scanner myKB = new Scanner(System.in);

        if (this.alcoholic) {
           System.out.println("This is an alcoholic drink. You must be 18 or older to buy it.");
            System.out.print("Please enter your age: ");

            int age = 0;
            try {
                age = Integer.parseInt(myKB.nextLine());
            } catch (NumberFormatException e) {
               System.out.println("Invalid input for age. Purchase cancelled.");
                return false;
            }

            if (age < 18) {  System.out.println("Sorry, you must be at least 18 years old to buy this drink.");
                return false;
            } else {
                trolley.buyItem(this);
                System.out.println(this.getName() + " added to the trolley.");
               return true;
            }
        } else {
            trolley.buyItem(this);
            System.out.println(this.getName() + " added to the trolley.");
            return true;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (Volume: " + volume + ", Alcoholic: " + (alcoholic ? "Yes" : "No") + ")";
    }
}
