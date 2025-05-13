import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        String str = "hello";
        String originalString;
        str = originalString = str.toLowerCase();
        boolean isPalindrome = true;
        str = new StringBuilder(str).reverse().toString();
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i)!=originalString.charAt(i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.print("Given String is a Palindrome ? " + isPalindrome);
    }
}