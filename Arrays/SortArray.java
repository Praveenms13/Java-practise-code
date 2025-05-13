import java.util.Arrays;

public class SortArray {
    public static void main (String[] args) {
        int[] arr = {0,2,1,2,0};
        Arrays.sort(arr);
        for (int i:arr){
            System.out.print(i + " ");
        }
    }
}