import java.util.Arrays;

public class FindKthMaxMin {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15}; // 4 3 7 10 15 20
        Arrays.sort(arr);
        int k = 3;
        int min = arr[k - 1];
        int max = arr[arr.length - k];
        System.out.println(k+" Min is : " + min);
        System.out.println(k + " Max is : " + max);
    }
}