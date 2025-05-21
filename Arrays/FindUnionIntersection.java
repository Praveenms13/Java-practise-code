package Arrays;

import java.util.HashSet;
import java.util.Set;

public class FindUnionIntersection {
    public static void main(String[] args) {
        int[] arr1 = {1,2,4,5};
        int[] arr2 = {2,3,5,6};
        Set<Integer> union = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i:arr1) {
            union.add(i);
            set1.add(i);
        }
        for (int i:arr2) {
            union.add(i);
            if (set1.contains(i)) {
                intersection.add(i);
            }
        }
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}