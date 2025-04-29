import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static <T> void print(T val) {
        System.out.print(val);
    }
    public static <T> void println(T val) {
        System.out.println(val);
    }
    // Use Upper Bounded Wildcards (? extends T) for Read-Only Access
    public static void printNumbers(List<? extends Number> numbers) {
        // numbers.set(1,1000);
        for (Number number : numbers) {
            System.out.println(number);
        }
    }
    // Use Lower Bounded Wildcards (? super T) for Write Operations
    public static void addNumbers(List<? super Integer> list) {
        list.add(1000); 
    }
    public static void main (String[] args) {
        try {
            List<Integer> list = new ArrayList<>();
            list.add(10);
            list.add(20);
            list.add(30);
            System.out.println(list);

            Box<Integer> box = new Box<>();
            box.set(10);
            println(box.get());
            printNumbers(list);
            addNumbers(list);
            println(list);

            List<Object> list2 = new ArrayList<>();
            list2.add(10);
            list2.add("98");

            println("Before Type Casting");
            println((list2.get(0)).getClass().getName());
            println((list2.get(1).getClass()).getName());

            Integer firstElement = (Integer) list2.get(0); 
            String secondElement = (String) list2.get(1);  

            println("After Type Casting");
            println(firstElement.getClass().getName());
            println(secondElement.getClass().getName());

            println("Actual Datas");
            println("First Element: " + firstElement); 
            println("Second Element: " + secondElement); 
            
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
class Box<T> {
    T val;
    public T get() {
        return this.val;
    }
    public void set(T val) {
        this.val = val;
    }
}
