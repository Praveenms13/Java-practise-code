import com.sun.source.doctree.SystemPropertyTree;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
    private String name;
    WarehouseItem(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public abstract void showDetails();
}
class Electronics extends WarehouseItem {
    private String brand;
    Electronics(String name,String brand) {
        super(name);
        this.brand = brand;
    }
    @Override
    public void showDetails() {
        System.out.println("Electronics: " + getName() + ", Brand: " + brand);
    }
}
class Groceries extends WarehouseItem {
    private String expirationDate;
    Groceries(String name, String expirationDate) {
        super(name);
        this.expirationDate = expirationDate;
    }

    @Override
    public void showDetails() {
        System.out.println("Groceries: " + getName() + ", Expiration Date: " + expirationDate);
    }
}
class Furniture extends WarehouseItem {
    private String material;
    Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public void showDetails() {
        System.out.println("Furniture: " + getName() + ", Material: " + material);
    }
}
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItems(T item){
        items.add(item);
    }
    public List<T> getItems() { return items; }
}
class WarehouseUtils{
    public static void displayDetails(List<? extends WarehouseItem> items) {
        for (WarehouseItem item: items) {
            item.showDetails();
        }
    }
}

/**
 * Wildcards are used only in methods parameters, usually read only(can't safely add)
 * T Extends are used only in class or methods definition, you can add and read
 *
 * Upper Bounded (extends): Restricts to a specific type or its subclasses.
 * Lower Bounded (super): Restricts to a specific type or its superclasses.
 * Multiple Bounds (&): Allows specifying multiple constraints, but only one class can be extended.
 */
public class SmartWarehouseSystem_2 {
    private static <T> void sayHey(T name) {
        System.out.println("Hey "+name);
    }
    private static void printList(List<?> myList){
        System.out.println(myList);
    }
    public static void main(String[] args) {
        Storage<Electronics> electronicStorage = new Storage<>(); // One shelf for storing only electronics components
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicStorage.addItems(new Electronics("Smartphone", "Samsung"));
        groceriesStorage.addItems(new Groceries("Apple", "25-05-2025"));
        furnitureStorage.addItems(new Furniture("Bed", "Wood"));

        WarehouseUtils.displayDetails(electronicStorage.getItems());
        WarehouseUtils.displayDetails(groceriesStorage.getItems());
        WarehouseUtils.displayDetails(furnitureStorage.getItems());

        sayHey("Praveen");
        sayHey(new Electronics("tv", "sony"));
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        printList(myList);

        List<String> myList2 = new ArrayList<>();
        myList2.add("10");
        myList2.add("20");
        myList2.add("309");
        printList(myList2);

    }
}