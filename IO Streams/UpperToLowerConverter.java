import java.io.*;
public class UpperToLowerConverter{
    private static String sourceFile = "source.txt";
    private static String DestinationFile = "destSmallCase.txt";
    public static void main(String[] args) {
        String content = readFile();
        writeFile(content);
    }
    public static void writeFile(String content) {
        OutputStreamWriter osr = null;
        FileOutputStream fos = null;
        BufferedWriter writer = null;
        try{
            fos = new FileOutputStream(DestinationFile);
            osr = new OutputStreamWriter(fos, "UTF-8");
            writer = new BufferedWriter(osr);
            writer.write(content);
            writer.flush();
            readAndDisplayFileContents();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    public static void readAndDisplayFileContents() {
        File file = null;
        BufferedReader br = null;
        try{
            file = new File(DestinationFile);
            if (! file.exists()) {
                System.out.print("file does not exists");
                return;
            }
            br = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("Reading " + DestinationFile + " Contents.");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String readFile() {
        InputStreamReader isr = null;
        FileInputStream fis = null;
        BufferedReader reader = null;
        File file = null;
        StringBuilder sb = new StringBuilder();
        try {
            file = new File(sourceFile);
            if (! file.exists()) {
                System.out.println(sourceFile + " file doesn't exists.");
                return "";
            }
            fis = new FileInputStream(sourceFile);
            isr = new InputStreamReader(fis, "UTF-8");
            reader = new BufferedReader(isr);
            int ch;
            while ((ch = reader.read()) != -1) {
                sb.append((char)Character.toLowerCase(ch));
            }
        } catch (Exception e) {
            System.out.println("Error Occurred: " + e.getMessage());
        }
        return sb.toString();
    }
}