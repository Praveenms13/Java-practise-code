import java.util.ArrayList;
import java.util.HashMap;

class Test {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4,5,8,1,5,6,3,2,9};
        HashMap<Integer, Integer> e = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            if (e.containsKey(arr[i])){
                e.put(arr[i], e.get(arr[i]) + 1 );
            } else {
                e.put(arr[i], 1);
            }
        }
        ArrayList <ArrayList<Integer>> d = new ArrayList <>();
        for (HashMap.Entry<Integer, Integer> a : e.entrySet()) {
            System.out.println(a.getKey() + " => " + a.getValue());
            ArrayList<Integer> row1 = new ArrayList<>();
            int z = a.getKey();
            for (int i=0;i<a.getValue();i++) {
                row1.add(z);
            }
            d.add(row1);
        }
        System.err.println(d);
    }
}