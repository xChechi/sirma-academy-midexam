package classes;

public class ElectronicsItem extends InventoryItem {
    private int warrantyPeriod;

    public ElectronicsItem(String category, boolean breakable, boolean perishable, double price, String itemId, int quantity, ItemType itemType, int warrantyPeriod) {
        super(category, breakable, perishable, price, itemId, quantity, itemType);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void handleBreakage() {
        System.out.println("Be careful. Extra attention during transportation!");
    }

    @Override
    public String getDetails() {
        return "Product ID " + itemId + ", Category" + category + ", Type: " + itemType.toString() + ", Price: " + price + ", Quantity: " + quantity;
    }

    @Override
    public String getDescription() {
        return "Warranty period is " + warrantyPeriod + " months";
    }

    @Override
    public void handleExpiration() {
        System.out.println("Electronic items are expiration protected");
    }

    @Override
    public double calculateValue() {
        return (double) Math.round(price * quantity * 1.1 * 100) / 100;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
