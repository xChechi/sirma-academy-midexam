package classes.menu;

import classes.inventory.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryCli {
    private static final String FILENAME = "inventory.txt";
    private List<InventoryItem> items = new ArrayList<>();

    public void displayMenu() {
        System.out.println("============================");
        System.out.println("Inventory Management System");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. List Items");
        System.out.println("4. Categorize Items");
        System.out.println("5. Place Order");
        System.out.println("6. Save Progress");
        System.out.println("7. Load Saved Data");
        System.out.println("8. Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    removeItem(scanner);
                    break;
                case 3:
                    listItems();
                    break;
                case 4:
                    categorizeItems(scanner);
                    break;
                case 5:
                    placeOrder(scanner);
                    break;
                case 6:
                    saveProgress();
                    break;
                case 7:
                    loadInventory();
                    break;
                case 8:
                    saveProgress();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void addItem(Scanner scanner) {
        InventoryItem newItem;
        try {
            scanner.nextLine();

            System.out.println("Enter name:");
            String name = scanner.nextLine();

            System.out.println("Enter category:");
            String category = scanner.nextLine();

            System.out.println("Enter price:");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter type (1. Electronics, 2. Grocery, 3. Fragile):");
            int type = scanner.nextInt();
            scanner.nextLine();

            
            switch (type) {
                case 1:
                    System.out.println("Warranty Period:");
                    int warrantyPeriod = scanner.nextInt();
                    scanner.nextLine();
                    newItem = new ElectronicsItem(name, category, price, quantity, ItemType.ELECTRONICS, warrantyPeriod);
                    break;
                case 2:
                    System.out.println("Expiration date (format: dd/MM/yyyy):");
                    String expirationDateString = scanner.nextLine();
                    LocalDate expirationDate = LocalDate.parse(expirationDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    newItem = new GroceryItem(name, category, price, quantity, ItemType.GROCERY, expirationDate);
                    break;
                case 3:
                    System.out.println("Enter weight:");
                    double weight = scanner.nextDouble();
                    scanner.nextLine();
                    newItem = new FragileItem(name, category, price, quantity, ItemType.FRAGILE, weight);
                    break;
                default:
                    System.out.println("Invalid type");
                    return;
            }

            items.add(newItem);
            System.out.println("Item added successfully.");
            System.out.println("Current items in inventory: " + items.size());

        } catch (Exception e) {
            System.out.println("Error adding item: " + e.getMessage());
        }
    }

    private void removeItem(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter item ID to remove:");
        String id = scanner.nextLine();
        if (items.removeIf(item -> item.getItemId().equals(id))) {
            System.out.println("Item removed successfully.");
        } else System.out.println("ID not found");

    }

    private void listItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the inventory.");
        } else {
            System.out.println("Total items: " + items.size());
            for (InventoryItem item : items) {
                System.out.println(item.getDetails());
            }
        }
    }

    private void categorizeItems(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter item ID to categorize:");
        String id = scanner.nextLine();
        System.out.println("Enter new category:");
        String newCategory = scanner.nextLine();
        for (InventoryItem item : items) {
            if (item.getItemId().equals(id)) {
                item.setCategory(newCategory);
                System.out.println("Item categorized successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    private void placeOrder(Scanner scanner) {

    }

    private void saveProgress() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (InventoryItem item : items) {
                writer.print(item.getClass().getSimpleName() + ",");
                writer.print(item.getName() + ",");
                writer.print(item.getCategory() + ",");
                writer.print(item.getPrice() + ",");
                writer.print(item.getQuantity() + ",");
                writer.print(item.getItemId());

                switch (item) {
                    case GroceryItem groceryItem ->
                            writer.println("," + groceryItem.getExpirationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    case ElectronicsItem electronicsItem -> writer.println("," + electronicsItem.getWarrantyPeriod());
                    case FragileItem fragileItem -> writer.println("," + fragileItem.getWeight());
                    default -> writer.println();
                }
            }
            System.out.println("Progress saved successfully to " + FILENAME);
        } catch (IOException e) {
            System.out.println("Error saving progress: " + e.getMessage());
        }
    }


    private void loadInventory() {
        items.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 6) {
                    System.out.println("Invalid data format: " + line);
                    continue;
                }

                String itemTypeStr = parts[0].trim();
                String name = parts[1].trim();
                String category = parts[2].trim();
                double price = Double.parseDouble(parts[3].trim());
                int quantity = Integer.parseInt(parts[4].trim());
                //String itemId = parts[5].trim();

                switch (itemTypeStr) {
                    case "ElectronicsItem":
                        if (parts.length < 7) {
                            System.out.println("Invalid data format for ElectronicsItem: " + line);
                            continue;
                        }
                        int warrantyPeriod = Integer.parseInt(parts[6].trim());
                        items.add(new ElectronicsItem(name, category, price, quantity, ItemType.ELECTRONICS, warrantyPeriod));
                        break;
                    case "GroceryItem":
                        if (parts.length < 7) {
                            System.out.println("Invalid data format for GroceryItem: " + line);
                            continue;
                        }
                        LocalDate expirationDate = LocalDate.parse(parts[6].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        items.add(new GroceryItem(name, category, price, quantity, ItemType.GROCERY, expirationDate));
                        break;
                    case "FragileItem":
                        if (parts.length < 7) {
                            System.out.println("Invalid data format for FragileItem: " + line);
                            continue;
                        }
                        double weight = Double.parseDouble(parts[6].trim());
                        items.add(new FragileItem(name, category, price, quantity, ItemType.FRAGILE, weight));
                        break;
                    default:
                        System.out.println("Unknown item type: " + itemTypeStr);
                }
            }
            System.out.println("Inventory loaded successfully from " + FILENAME);
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }





}

