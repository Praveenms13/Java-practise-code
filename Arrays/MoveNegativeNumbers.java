import java.util.Arrays;

public class MoveNegativeNumbers {
    public static void main(String[] args) {
        int[] arr = {1,-1,3,2,-7,-5,11,6};
        Arrays.sort(arr);
        for (int i:arr){
            System.out.print(i + " ");
        }
    }
}