import classes.ElectronicsItem;
import classes.GroceryItem;
import classes.ItemType;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        ElectronicsItem tv = new ElectronicsItem(
                "white technic",
                true,
                false,
                599.99,
                "1",
                4,
                ItemType.ELECTRONICS,
                12);

        System.out.println(tv.calculateValue());
        System.out.println(tv.getDescription());
        System.out.println(tv.getDetails());
        System.out.println(tv.getCategory());
        System.out.println(tv.getPrice());
        System.out.println(tv.getItemId());
        System.out.println(tv.getQuantity());
        System.out.println(tv.isBreakable());
        System.out.println(tv.isPerishable());

        GroceryItem apple = new GroceryItem(
                "Apple",
                true,
                true,
                1.29,
                "2",
                24,
                ItemType.GROCERY,
                LocalDate.of(2024, 7, 22));

        System.out.println("=======================");
        System.out.println(apple.calculateValue());
        System.out.println(apple.getDescription());
        System.out.println(apple.getDetails());
        System.out.println(apple.getCategory());
        System.out.println(apple.getPrice());
        System.out.println(apple.getItemId());
        System.out.println(apple.getQuantity());
        System.out.println(apple.isBreakable());
        System.out.println(apple.isPerishable());
    }
}