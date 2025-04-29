import java.util.Arrays;
class Searching {
    public int linearSearch(int[] arr, int target) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            System.err.println("Element Not Found");
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target){
            return binarySearch(arr, target, mid+1, end);
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid-1);
        }
        return -1;
    }
    public int binarySearchRotationPointer(int arr[], int target, int start, int end) {
        int high = end;
        int low = start;
        while (low<=high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target){ return mid; }
            if (arr[low] >= arr[mid]) {
                // right sorted
                if (target >= arr[mid] && target <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // left sorted 
                if (target >= arr[low] && target <= arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    public boolean binarySearchRotationPointerWithDuplicateElements(int arr[], int target, int start, int end) {
        int high = end;
        int low = start;
        while (low<=high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target){ return true; }
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) { 
                low++;
                high--;
                continue;
            }
            if (arr[low] >= arr[mid]) {
                // right sorted
                if (target >= arr[mid] && target <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // left sorted 
                if (target >= arr[low] && target <= arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
    public int[] rotatedSortedArray(int[] arr, int index) {
        int[] rotated = new int[arr.length];
        int j = 0;
        for (int i=index;i<arr.length;i++) {
            rotated[j++] = arr[i];
        }
        for (int i=0;i<index;i++) {
            rotated[j++] = arr[i];
        }
        return rotated;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {34, 32, 45, 67, 2, 77, 88, 4, 99, 100};
        Searching SearchingObj = new Searching();
        int target = 100;
        int foundAtInLinear = SearchingObj.linearSearch(arr, target);
        if (foundAtInLinear == -1) {
            System.err.println("Element is not found !!");
        } else {
            System.out.println("Linear Search target element " + target + " is found at Index " + foundAtInLinear);
        }
        Arrays.sort(arr);
        int foundAtInBinary = SearchingObj.binarySearch(arr, target, 0, arr.length - 1);
        if (foundAtInBinary == -1) {
            System.err.println("Element is not found !!");
        } else {
            System.out.println("Binary Search target element " + target + " is found at Index " + foundAtInBinary);
        }
        int[] rotatedSortedArray = SearchingObj.rotatedSortedArray(arr, 5);
        // System.out.println(Arrays.toString(rotatedSortedArray));
        int foundAtInBinaryRSA = SearchingObj.binarySearchRotationPointer(rotatedSortedArray, target, 0, rotatedSortedArray.length - 1);
        if (foundAtInBinaryRSA == -1) {
            System.err.println("Element is not found !!");
        } else {
            System.out.println("Binary Search target element " + target + " is found at Index " + foundAtInBinaryRSA);
        }
        int[] rotatedSortedArrayWithDuplicates = {67, 77, 88, 88, 99, 99, 100, 2, 2, 4, 4, 32, 34, 45};
        boolean foundAtInBinaryRSAWithDuplicateElements = SearchingObj.binarySearchRotationPointerWithDuplicateElements(rotatedSortedArrayWithDuplicates, 101, 0, rotatedSortedArrayWithDuplicates.length - 1);
        boolean foundAtInBinaryRSAWithDuplicateElements_2 = SearchingObj.binarySearchRotationPointerWithDuplicateElements(rotatedSortedArrayWithDuplicates, 100, 0, rotatedSortedArrayWithDuplicates.length - 1);
        System.out.println("Is Element Found: " + foundAtInBinaryRSAWithDuplicateElements);
        System.out.println("Is Element Found: " + foundAtInBinaryRSAWithDuplicateElements_2);
    }
}
