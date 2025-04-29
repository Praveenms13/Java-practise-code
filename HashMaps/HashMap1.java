import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class HashMap1 {
    public static void main(String args[]) {
        // ----------- HashSet Example -----------
        HashSet<String> fruitsSet = new HashSet<>();
        fruitsSet.add("Apple");
        fruitsSet.add("Banana");
        fruitsSet.add("Mango");
        fruitsSet.add("Apple"); // Duplicate, will be ignored
        System.out.println("HashSet (Unique Values Only):"  + fruitsSet);

        // ----------- Hashtable Example -----------
        
        Hashtable<String, Integer> fruitStock = new Hashtable<>();
        fruitStock.put("Apple", 50);
        fruitStock.put("Banana", 30);
        fruitStock.put("Mango", 100);
        fruitStock.put("Banana", 40); // This will overwrite the old value
        System.out.println("\nHashtable (Key-Value Pairs): " + fruitStock);

        // ----------- HashMap Example -----------
        HashMap<String, Integer> fruitMap = new HashMap<>();
        fruitMap.put("Apple", 10);
        fruitMap.put("Banana", 20);
        fruitMap.put("Mango", 30);
        fruitMap.put("Banana", 25); // This will overwrite the previous value of "Banana"
        System.out.println("\nHashMap (Key-Value Pairs): " + fruitMap);

        // ----------- Set Example (Using HashSet) -----------
        Set<String> fruitSet = fruitsSet; // Using the Set interface to reference HashSet
        System.out.println("\nSet (Unique Values from HashSet): " + fruitSet);
        /*
        if (map.containsKey("B")){
            System.out.print("B Is Contains");
        } else {
            System.out.print("B Is Not Contained ..");
        }
        for (Map.Entry<String, Integer> e: map.entrySet()){ // map.entrySet() => Gives all the key Value Pairs of the dictionary.
            System.out.println(e.getKey() + " => " + e.getValue());
        }
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }*/
    }
}
