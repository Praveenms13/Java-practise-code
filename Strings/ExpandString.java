public class ExpandString{
    public static void main(String[] args) {
        String input = "b3c6d15";
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i<input.length()) {
            StringBuilder numstr = new StringBuilder();
            char ch = input.charAt(i);
            i++;
            while (i<input.length() && Character.isDigit(input.charAt(i))) {
                numstr.append(input.charAt(i));
                i++;
            }
            int count = Integer.parseInt(numstr.toString());
            for (int j=0;j<count;j++) {
                result.append(ch);
            }
        } System.out.println(result);
    }
}