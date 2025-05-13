import java.util.HashMap;
import java.util.Map;
public class duplicateCharacter{
    public static void main(String[] args) {
        String str = "Programming";
        str = str.toLowerCase().replaceAll("\\s", "");
        Map<Character, Integer> wordCount = new HashMap<>();
        int i = 0;
        while (str.length() > i) {
            wordCount.put(str.charAt(i), wordCount.getOrDefault(str.charAt(i), 0) + 1);
            i++;
        }
        for (Map.Entry<Character, Integer> data : wordCount.entrySet()) {
            if (data.getValue()>1) {
                System.out.println(data.getKey() + " Occurs " + data.getValue() + " times.");
            }
        }
    }
}