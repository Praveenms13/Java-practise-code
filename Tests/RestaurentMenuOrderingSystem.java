import java.util.*;
interface MenuOrderingSystemInterface {
    void displayMenu();
    void selectItem();
    void addToCart();
    void calculateBill();
    void confirmOrder();
    void orderSummary();
}
class Customer {
    protected String customerId;
    Customer(String customerId) {
        this.customerId = customerId;
    }
    public String getCustomerId() {
        return this.customerId;
    }
}
class MenuOrderingSystem extends Customer implements MenuOrderingSystemInterface{
    private Map<String, Integer> menuItems;
    MenuOrderingSystem(){
        super(String customerId);
        menuItems.put("Idli", 10);
        menuItems.put("Dosa", 20);
        menuItems.put("Poori", 40);
        menuItems.put("Pongal", 35);
        menuItems.put("Maggi", 25);
    }
    public void displayMenu(){

    }
    public void selectItem(){}
    public void addToCart(){}
    public void calculateBill(){}
    public void confirmOrder(){}
    public void orderSummary(){}
}
public class RestaurentMenuOrderingSystem {

}