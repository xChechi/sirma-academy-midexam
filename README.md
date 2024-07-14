# Inventory Management System

## Project Overview

You are tasked with developing a comprehensive Inventory Management System for a small store. This system should manage various types of items, handle payments, and process orders. The implementation should include interfaces, abstract classes, and multiple concrete classes.

## Requirements

### Interfaces and Abstract Classes

1. **Item Interface (15 points):**
   - Create an `Item` interface to represent items in the inventory.
   - Define methods for getting item details, calculating value, and displaying the item's description.

2. **Categorizable Interface (10 points):**
   - Create a `Categorizable` interface that represents items that can be categorized.
   - Include methods for setting and getting the item category.

3. **Breakable Interface (10 points):**
   - Create a `Breakable` interface to indicate items that can break.
   - Include methods for checking if an item is breakable and for handling item breakage.

4. **Perishable Interface (10 points):**
   - Create a `Perishable` interface to represent items that can perish.
   - Include methods for checking if an item is perishable and for handling item expiration.

5. **Sellable Interface (10 points):**
   - Create a `Sellable` interface to represent items that can be sold.
   - Include methods for setting and getting item prices.

6. **Abstract Item Class (15 points):**
   - Create an abstract class `AbstractItem` that implements the `Item`, `Categorizable`, `Breakable`, `Perishable`, and `Sellable` interfaces.
   - Implement common functionality such as getting item details.
   - Provide default implementations for category, breakable, perishable, and sellable attributes.

### Superclasses and Inheritance

7. **Inventory Superclass (20 points):**
   - Create an `InventoryItem` superclass that extends `AbstractItem`.
   - Add instance variables for item ID and quantity.
   - Implement getters and setters for ID and quantity.

8. **Item Types (30 points):**
   - Create subclasses for specific item types like `ElectronicsItem`, `GroceryItem`, and `FragileItem` that inherit from `InventoryItem`.
   - Implement constructors for these subclasses to set specific attributes like weight for fragile items.
   - Override relevant methods to calculate item values differently for each type.

### File I/O, User Interface, Payments, and Orders

9. **File I/O (15 points):**
   - Implement methods to save and load inventory data to/from text files.
   - Use a well-defined file format for data storage.

10. **User Interface (15 points):**
    - Create a command-line interface (CLI) to interact with the inventory system.
    - Allow users to add items, remove items by ID, display a list of items, categorize items, and place orders.
    - Display a menu for user choices and handle user input gracefully.

11. **Payments and Orders (20 points):**
    - Implement classes for `Payment` and `Order`.
    - Allow users to create orders, calculate order totals, and process payments.
    - Update inventory quantities after orders are placed.

### Error Handling and Documentation

12. **Error Handling (10 points):**
    - Implement robust error handling to address potential issues, such as invalid user input, file I/O errors, and handling exceptions properly.

13. **Documentation (10 points):**
    - Document your code with meaningful comments and explanations.
    - Include comments explaining the purpose and usage of each class, interface, and method.

### Extra Credit (10 points)

- Implement additional features, such as searching for items by name or category, updating item quantities, sorting items by name, category, or price, or implementing discount codes for orders.

## Example Usage of the Application

1. **Add Items to Inventory:**
   - `Add` to add a new item.
   - Specify item details, including name, category, price, quantity, and item type.

2. **List Inventory Items:**
   - `List` to display a list of all inventory items.

3. **Categorize Items:**
   - `Categorize` to categorize items based on their type or category.

4. **Place an Order:**
   - `Order` to start the order process.
   - Add items to the order and specify quantities.
   - Calculate the total cost and apply payments.

5. **Error Handling:**
   - Ensure that the application handles invalid input, out-of-stock items, and file I/O errors gracefully.

---

This README provides an overview of the requirements and functionality for the Inventory Management System project. Follow the instructions to implement the necessary features and ensure proper error handling and documentation throughout your code.
