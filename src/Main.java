import classes.ElectronicsItem;
import classes.ItemType;

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


    }
}