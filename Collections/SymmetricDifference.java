
import java.util.*;

public class SymmetricDifference {
    static Set<Integer> findSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new TreeSet<>();
        result.addAll(set1);
        result.retainAll(set2);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(10, 20, 30));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(30, 40, 50, 60));

        Set<Integer> SymmetricDifference = findSymmetricDifference(set1, set2);

        System.out.println("SymmetricDifference: " + SymmetricDifference);
    }
}




