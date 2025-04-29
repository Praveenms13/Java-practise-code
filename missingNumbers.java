import java.util.*;

public class missingNumbers {
    public static void main(String[] args) {
        int[] nums = {6, 10, 15, 20, 60, 100, 500};
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int start = Arrays.stream(nums).min().getAsInt();
        int end = Arrays.stream(nums).max().getAsInt();
        
        for (int i = start; i <= end; i++) {
            if (!numSet.contains(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
