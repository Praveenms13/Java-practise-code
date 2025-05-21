import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Price: " + price;
    }
}

public class BookstoreInventory {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book by Title");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        books.add(new Book(title, author, price));
        System.out.println("Book added.");
    }

    static void removeBook() {
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine();
        boolean removed = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).title.equalsIgnoreCase(title)) {
                books.remove(i);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Book removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    static void searchBook() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in inventory.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
