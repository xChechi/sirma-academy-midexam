package classes;

public abstract class InventoryItem extends AbstractItem {
    protected String itemId;
    protected int quantity;
    protected ItemType itemType;

    public InventoryItem(String category, boolean breakable, boolean perishable, double price, String itemId, int quantity, ItemType itemType) {
        super(category, breakable, perishable, price);
        this.itemId = itemId;
        this.quantity = quantity;
        this.itemType = itemType;
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

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
