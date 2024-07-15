import classes.inventory.ElectronicsItem;
import classes.inventory.FragileItem;
import classes.inventory.GroceryItem;
import classes.inventory.ItemType;
import classes.menu.InventoryCli;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        InventoryCli menu = new InventoryCli();
        menu.start();
    }
}