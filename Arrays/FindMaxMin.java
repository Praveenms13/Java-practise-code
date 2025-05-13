public class FindMaxMin {
    public static void main(String args[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] arr = {10,20,30,40,50,100};

        for (int ar:arr) {
            if (ar<min) {
                min = ar;
            }
            if (ar>max) {
                max = ar;
            }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}