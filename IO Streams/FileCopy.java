import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class FileCopy {
    public static void main (String[] args) {
        String SourceFile = "source.txt";
        String DestinationFile = "destination.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File inputFile = new File(SourceFile);
            if (!inputFile.exists()) {
                System.out.println(SourceFile + " File does not Exists.");
                return;
            }
            fis = new FileInputStream(SourceFile);
            fos = new FileOutputStream(DestinationFile);
            int byteData;
            while ( (byteData = fis.read()) != -1 ){
                fos.write(byteData);
            }
            System.out.println("File Copied Successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}