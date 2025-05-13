public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello, How are you ??";
        String reversedStr = new StringBuilder(str).reverse().toString();
        System.out.print("Reversed the string using inBuilt Function: " + reversedStr);

        String reversed = "";
        for (int i=str.length()-1;i>=0;i--) {
            reversed += str.charAt(i);
        }
        System.out.print("\nReversed the string without inBuilt Function: " + reversed);
    }
}