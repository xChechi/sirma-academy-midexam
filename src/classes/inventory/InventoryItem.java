package classes.inventory;

public abstract class InventoryItem extends AbstractItem {
    protected String itemId;
    protected int quantity;
    protected ItemType itemType;
    private static int nextItemId = 1;

    public InventoryItem(String name, String category, boolean breakable, boolean perishable, double price, int quantity, ItemType itemType) {
        super(name, category, breakable, perishable, price);
        this.itemId = generateItemId();
        this.quantity = quantity;
        this.itemType = itemType;
    }

    private String generateItemId() {
        return "ITEM-" + nextItemId++;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
