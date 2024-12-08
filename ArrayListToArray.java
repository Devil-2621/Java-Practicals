import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListToArray {
    public static void main(String[] args) {
        // Create Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Create an ArrayList of Integer
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers (enter -1 to stop):");

        // Add elements to ArrayList
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) {
                break;
            }
            numbers.add(num);
        }

        // Convert ArrayList to Array
        Integer[] arrayNumbers = numbers.toArray(new Integer[0]);

        // Display contents
        System.out.println("\nArray contents:");
        int sum = 0;
        for (int num : arrayNumbers) {
            System.out.print(num + " ");
            sum += num;
        }

        // Display sum
        System.out.println("\nSum of all numbers: " + sum);

        // Close scanner
        scanner.close();
    }
}