package classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GroceryItem extends InventoryItem {
    private LocalDate expirationDate;

    public GroceryItem(String category, boolean breakable, boolean perishable, double price, String itemId, int quantity, ItemType itemType, LocalDate expirationDate) {
        super(category, breakable, perishable, price, itemId, quantity, itemType);
        this.expirationDate = expirationDate;
    }

    @Override
    public void handleBreakage() {
        System.out.println("You can smash it buy hardly break it");
    }

    @Override
    public String getDetails() {
        return "Product ID " + itemId + ", Category " + category + ", Type: " + itemType.toString() + ", Price: " + price + ", Quantity: " + quantity;
    }

    @Override
    public String getDescription() {
        return "Grocery Item: " + category + ", Best before " + expirationDate;
    }

    @Override
    public void handleExpiration() {
        System.out.println("Best before " + expirationDate);
    }

    @Override
    public double calculateValue() {
        LocalDate today = LocalDate.now();
        long daysToExpiration = ChronoUnit.DAYS.between(today, expirationDate);
        double value = price * quantity;

        if (daysToExpiration <= 0) {
            value = 0;
        } else if (daysToExpiration <= 7) {
            value *= 0.5;
        } else if (daysToExpiration <= 30) {
            value *= 0.75;
        }

        return Math.round(value * 100) / 100.0;
    }
}
