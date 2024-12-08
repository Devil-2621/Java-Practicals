import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileOperationsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Accept string and store uppercase in file
        try {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            FileWriter fw = new FileWriter("uppercase.txt");
            fw.write(input.toUpperCase());
            fw.close();
            System.out.println("Uppercase string written to uppercase.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // 2. Write double value and date to file
        try {
            System.out.print("Enter a double value: ");
            double value = scanner.nextDouble();
            FileWriter fw = new FileWriter("double_and_date.txt");
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            fw.write("Double value: " + value + "\n");
            fw.write("Date: " + dateFormat.format(currentDate));
            fw.close();
            System.out.println("Double value and date written to double_and_date.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // 3. Delete file or directory
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter file or directory path to delete: ");
        String pathToDelete = scanner.nextLine();
        File fileToDelete = new File(pathToDelete);

        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("Successfully deleted: " + pathToDelete);
            } else {
                System.out.println("Failed to delete: " + pathToDelete);
            }
        } else {
            System.out.println("File or directory does not exist: " + pathToDelete);
        }

        scanner.close();
    }
}