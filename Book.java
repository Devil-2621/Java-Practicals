import java.util.Scanner;

class Publisher {
    String publisherName;
    int publisherId;
    Scanner scanner = new Scanner(System.in);

    void getData() {
        System.out.print("Enter Publisher Name: ");
        publisherName = scanner.nextLine();
        System.out.print("Enter Publisher ID: ");
        publisherId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
    }

    void showData() {
        System.out.println("\nPublisher Details:");
        System.out.println("Publisher Name: " + publisherName);
        System.out.println("Publisher ID: " + publisherId);
    }
}

public class Book extends Publisher {
    String bookName;
    int bookId;
    String authorName;

    @Override
    void getData() {
        super.getData();
        System.out.print("Enter Book Name: ");
        bookName = scanner.nextLine();
        System.out.print("Enter Book ID: ");
        bookId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Author Name: ");
        authorName = scanner.nextLine();
    }

    @Override
    void showData() {
        super.showData();
        System.out.println("\nBook Details:");
        System.out.println("Book Name: " + bookName);
        System.out.println("Book ID: " + bookId);
        System.out.println("Author Name: " + authorName);
    }

    public static void main(String[] args) {
        Book book = new Book();
        System.out.println("Enter Book and Publisher Details:");
        book.getData();
        System.out.println("\nDisplaying All Details:");
        book.showData();
        book.scanner.close();
    }
}