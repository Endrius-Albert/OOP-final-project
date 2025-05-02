/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

public class FoodItem extends StoreItem {
    private String expiryDate;

    public FoodItem(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
 
    @Override
    public String toString() {
        return super.toString() + " (Validade: " + expiryDate + ")";
    }
}