import java.io.*;
public class BufferedVsUnbufferedCopy{
    private static final int BUFFER_SIZE = 4096;
    private static final String sourceFile = "largefile.dat";
    public static void main(String[] args) {
        String bufferedDestFile = "bufferedCopy.dat";
        String unBufferedDestFile = "unBufferedCopy.dat";

        long bufferedTime = bufferedCopy(bufferedDestFile);
        System.out.println("Buffered copy time: " + bufferedTime + " ns");
        long unBufferedTime = unBufferedCopy(unBufferedDestFile);
        System.out.println("UnBuffered copy time: " + unBufferedTime + " ns");
    }
    private static long unBufferedCopy(String unBufferedDestFile) {
        long startTime = System.nanoTime();

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            int byteRead;
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()){
                throw new Exception(sourceFile + " does not exists");
            }
            byte[] buffer = new byte[BUFFER_SIZE];
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(unBufferedDestFile);
            while ((byteRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, byteRead);
            }
        } catch (Exception e) {
            System.out.println("UnBuffered Copy Error: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                System.out.println("Error while closing streams: " + ex.getMessage());
            }
        }
        return System.nanoTime() - startTime;
    }
    private static long bufferedCopy(String bufferedDestFile) {
        long startTime = System.nanoTime();

        BufferedInputStream fis = null;
        BufferedOutputStream fos = null;

        try {
            int byteRead;
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                throw new Exception(sourceFile + " does not exists");
            }
            byte[] buffer = new byte[BUFFER_SIZE];
            fis = new BufferedInputStream(new FileInputStream(sourceFile));
            fos = new BufferedOutputStream(new FileOutputStream(bufferedDestFile));
            while ((byteRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, byteRead);
            }
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
            } catch (IOException ex) {
                System.out.println("Error while closing streams: " + ex.getMessage());
            }
        }
        return System.nanoTime() - startTime;
    }
}