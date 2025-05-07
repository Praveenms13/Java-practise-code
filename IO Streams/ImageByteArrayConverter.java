import java.io.*;
public class ImageByteArrayConverter {
    public static void main (String[] args) {
        String SourceImage = "original.png";
        String DestinationImage = "copied.png";
        try {
            byte[] imageByte = readBytesFromImage(SourceImage);
            writeBytesToFile(imageByte, DestinationImage);
            boolean isIdentical = compareFiles(SourceImage, DestinationImage);
            System.out.println("Files are identical: " + isIdentical);
        } catch (Exception e) {
            System.out.println("Error Occurred: " + e.getMessage());
        }
    }
    public static byte[] readBytesFromImage(String SourceImage) throws IOException {
        File file = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        byte[] buffer = new byte[4096];
        try {
            file = new File(SourceImage);
            if (! file.exists()) {
                System.out.println(SourceImage + " is not exists.");
                return buffer;
            }
            fis = new FileInputStream(SourceImage);
            baos = new ByteArrayOutputStream();
            int byteRead;
            while ((byteRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0,  byteRead);
            }
        } catch (Exception e) {
            System.out.println("Error Occurred: " + e.getMessage());
        }  finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                System.out.println("Error Occurred: " + e.getMessage());
            }
        }
        return baos.toByteArray();
    }
    public static void writeBytesToFile(byte[] ImageBytes,String DestinationImage) throws IOException {
        FileOutputStream fos = null;
        ByteArrayInputStream bais = null;
        byte[] buffer = new byte[4096];
        try {
            fos = new FileOutputStream(DestinationImage);
            bais = new ByteArrayInputStream(ImageBytes);
            int byteRead;
            while ((byteRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, byteRead);
            }
        } catch (Exception e) {
            System.out.println("Error Occurred: " + e.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (bais != null) {
                    bais.close();
                }
            } catch (IOException e) {
                System.out.println("Error Occurred: " + e.getMessage());
            }
        }
    }
    public static boolean compareFiles(String SourceImage, String DestinationImage) throws FileNotFoundException {
        try {
            FileInputStream fis1 = new FileInputStream(SourceImage);
            FileInputStream fis2 = new FileInputStream(DestinationImage);
            int b1, b2;
            do {
                b1 = fis1.read();
                b2 = fis2.read();
                if (b1!=b2) return false;
            } while (b1!=-1 && b2!=-1);
            return b1==b2;
        } catch (Exception e) {
            System.out.println("Error Occurred: " + e.getMessage());
            return false;
        }
    }
}