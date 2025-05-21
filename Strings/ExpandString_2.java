public class ExpandString_2 {
    public static void main(String[] args) {
        String input = "a3b1cd2";
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                int count = 1;
                if (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                    count = input.charAt(i + 1) - '0';
                    i++;
                }
                for (int j = 0; j < count; j++) {
                    result += ch;
                }
            }
        }
        System.out.println(result);
    }
}