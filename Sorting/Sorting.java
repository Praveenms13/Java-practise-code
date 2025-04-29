import java.util.ArrayList;
class AllSorting {
    ArrayList<Integer> arr = new ArrayList<>();
    public void setArray(int[] arr) {
        for (int i:arr){
            this.arr.add(i);
        }
        System.out.println("Original Array => " + this.arr);
    }
    public void SelectionSort() {
        if (arr.size() <= 1) {
            System.out.println(arr);
            return;
        }
        for (int i=0;i<arr.size();i++) {
            for (int j=i+1;j<arr.size();j++) {
                if(arr.get(i) > arr.get(j)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        System.out.println("Selection Sort => " + arr);
    }
    public void BubbleSort() {
        // Time Complexity is O(n) in another method, If swapped then break but in this the time complexity is O(n^2)
        if (arr.size() <= 1) {
            System.out.println(arr);
            return;
        }
        for (int i=0;i<arr.size();i++) {
            for (int j=0;j<arr.size()-1-i;j++) {
                if (arr.get(j) > arr.get(j+1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }
        System.out.println("Bubble Sort => " + arr);
    }
    public void InsertionSort() {
        int[] arra = {20, 12, 35, 60, 15};
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i:arra){
            arr1.add(i);
        }
        if (arr1.size() <= 1) {
            System.out.println(arr1);
            return;
        }
        for (int i = 1; i < arr1.size(); i++) {
            int key = arr1.get(i);
            int j = i - 1;
            while (j >= 0 && arr1.get(j) > key) {
                arr1.set(j + 1, arr1.get(j));
                j--;
            }
            arr1.set(j + 1, key);
        }
        
        System.out.println("Insertion Sort => " + arr1);
    }
}
public class Sorting {
    public static void main(String args[]) {
        int[] arr = {20, 12, 35, 60, 15};
        // int[] arr = {1,2,3,4,5};
        AllSorting AllSortingObj = new AllSorting();
        AllSortingObj.setArray(arr);
        AllSortingObj.SelectionSort();
        AllSortingObj.BubbleSort();
        AllSortingObj.InsertionSort();
    }
}