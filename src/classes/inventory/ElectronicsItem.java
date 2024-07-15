package classes.inventory;

public class ElectronicsItem extends InventoryItem {
    private int warrantyPeriod;

    public ElectronicsItem(String name, String category, double price, int quantity, ItemType itemType, int warrantyPeriod) {
        super(name, category, true, false, price, quantity, itemType);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void handleBreakage() {
        System.out.println("Be careful. Extra attention during transportation!");
    }

    @Override
    public String getDetails() {
        return "ID: " + itemId + " " + name + ", Category " + category + ", Type: " + itemType.toString() + ", Price: " + price + ", Quantity: " + quantity;
    }

    @Override
    public String getDescription() {
        return name + ": Warranty period is " + warrantyPeriod + " months";
    }

    @Override
    public void handleExpiration() {
        System.out.println("Electronic items are expiration protected");
    }

    @Override
    public double calculateValue() {
        return (double) Math.round(price * quantity * 1.1 * 100) / 100;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}
