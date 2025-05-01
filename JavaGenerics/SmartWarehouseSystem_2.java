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

    }
}
public class SmartWarehouseSystem_2 {
    public static void main(String[] args) {
        Storage<Electronics> electronicStorage = new Storage<>(); // One shelf for storing only electronics components
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicStorage.addItems(new Electronics("Smartphone", "Samsung"));
        groceriesStorage.addItems(new Groceries("Apple", "25-05-2025"));
        furnitureStorage.addItems(new Furniture("Bed", "Wood"));

        System.out.println(electronicStorage.getItems());
        System.out.println(groceriesStorage.getItems());
        System.out.println(furnitureStorage.getItems());
    }
}