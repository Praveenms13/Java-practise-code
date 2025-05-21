import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        try {
            String s = Integer.toString(n);
            System.out.print("Good job");
        } catch (Exception e) {
            System.out.print("Wrong Answer");
        }
    }
}