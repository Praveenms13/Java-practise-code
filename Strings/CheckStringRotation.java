public class CheckStringRotation {
    public static void main(String[] args) {
        String str1 = "Thankyou";
        String str2 = "kyouTha";
        if (isRotation(str1, str2)) {
            System.out.println(str2 + " is a rotation of " + str1);
        } else {
            System.out.println(str2 + " is NOT a rotation of " + str1);
        }
    }
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String combined = s1 + s1;
        return combined.contains(s2);
    }
}