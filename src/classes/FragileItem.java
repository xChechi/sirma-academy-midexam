package classes;

public class FragileItem extends InventoryItem {
    private double weight;

    public FragileItem(String name, String category, boolean breakable, boolean perishable, double price, String itemId, int quantity, ItemType itemType, double weight) {
        super(name, category, breakable, perishable, price, itemId, quantity, itemType);
        this.weight = weight;
    }

    @Override
    public void handleBreakage() {
        System.out.println("Be extremely careful! Fragile items can be broken easily");
    }

    @Override
    public String getDetails() {
        return name + ": Product ID " + itemId + ", Category " + category + ", Type: " + itemType.toString() + ", weight: " + weight + ", Price: " + price + ", Quantity: " + quantity;
    }

    @Override
    public String getDescription() {
        return name + ": Attention fragile item! Weight: " + weight + " kg";
    }

    @Override
    public void handleExpiration() {
        System.out.println("There is no expiration period for this item");
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double calculateValue() {
        return super.calculateValue() + (weight * 1.2);
    }
}
