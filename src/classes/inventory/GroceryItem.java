package classes.inventory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GroceryItem extends InventoryItem {
    private LocalDate expirationDate;

    public GroceryItem(String name, String category, double price, int quantity, ItemType itemType, LocalDate expirationDate) {
        super(name, category, false, true, price, quantity, itemType);
        this.expirationDate = expirationDate;
    }

    @Override
    public void handleBreakage() {
        System.out.println("You can smash it buy hardly break it");
    }

    @Override
    public String getDetails() {
        return "ID: " + itemId + " " + name + ", Category " + category + ", Type: " + itemType.toString() + ", Price: " + price + ", Quantity: " + quantity + ", Expiration Date: " + expirationDate;
    }

    @Override
    public String getDescription() {
        return name + ": " + category + ", Best before " + expirationDate;
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
