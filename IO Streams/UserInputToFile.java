import java.io.*;
public class UserInputToFile{
    public static void main (String[] args) {
        FileWriter writer = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favourite programming language: ");
            String language = reader.readLine();

            writer = new FileWriter("UserInfo.txt");
            writer.write("User's name is " + name);
            writer.write("\nUser's age is " + age);
            writer.write("\nUser's favourite language is " + language);
            System.out.println("Information saved to userinfo.txt file");
        } catch (Exception e) {
            System.out.println("An Error Occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing the resources: " + e.getMessage());
            }
        }
    }
}