# 🛒 Supermarket Shopping System

## Description

This project simulates a supermarket system in Java using Object-Oriented Programming (OOP).  
It allows users to purchase items from different categories (Food, Drinks, Clothing, and Store Items), add them to a shopping trolley, view and remove items, and finalize the purchase with automatic total calculation.

The project was originally developed as an academic assignment but is structured so anyone can understand and test it.

## Main Features

- Choose item categories: Food, Drinks, Clothing, Store Items  
- Add items to the shopping trolley  
- Age verification for alcoholic drinks  
- Remove items from the trolley  
- Calculate and display the total purchase amount  
- Modular system with classes separated by item type  

## Project Structure

- `StoreItem.java` → Base class for all products  
- `FoodItem.java` → Inherits from StoreItem, adds `expiryDate`  
- `DrinkItem.java` → Inherits from StoreItem, adds `volume` and `alcoholic`, with `addToTrolley()` method for age verification  
- `ClothingItem.java` → Inherits from StoreItem, adds `size` and `material`  
- `ShoppingTrolley.java` → Manages items added to the trolley  
- `Supermarket.java` → Main class with interactive menu, purchase methods, and trolley display  

## Technologies Used

- **Language:** Java  
- **Concepts:** OOP, inheritance, polymorphism, arrays, lists, Scanner input handling  

## How to Run

1. Clone this repository:

git clone https://github.com/Endrius-Albert/OOP-final-project.git

2. Open the project in a Java IDE (NetBeans, IntelliJ, or Eclipse)  
3. Compile and run `Supermarket.java`  
4. Follow the interactive menu in the console to test the system  

## Code Highlights

- **OOP:** inheritance for differentiating product types  
- **Polymorphism:** overridden methods (`toString()`) to display item-specific information  
- **Exception handling:** `InputMismatchException` and `NumberFormatException` for invalid inputs  
- **Modular design:** each item category has its own purchase method  

## Implementation Decisions and Workarounds

Due to the limitations of the original project (modifying `ShoppingTrolley` was not allowed), the following solutions were applied:

- **Own list of items (`itemsInTrolley`)**  
  `ShoppingTrolley` didn’t allow removing individual items or accessing the list, so a separate list was created for management.  

- **Adding items to both lists**  
  Every item added goes to both `ShoppingTrolley` and `itemsInTrolley`, keeping them synchronized.  

- **Removing items**  
  To remove an item, `ShoppingTrolley` is emptied and only the items that should remain are re-added.  

- **Total price tracking**  
  `ShoppingTrolley` doesn’t calculate totals, so a `double[] total` array keeps the accumulated value updated across methods.  

- **Single Scanner instance**  
  The `Scanner` object is passed to methods instead of creating new ones, avoiding input conflicts in the console.  

These solutions ensure the program works correctly without modifying the provided `ShoppingTrolley` class, maintaining all expected functionality.

## Author

**Endrius Alberto Noronha**
