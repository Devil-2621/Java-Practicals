import java.util.Scanner;

public class NumberCalculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a positive number: ");
            int num = scanner.nextInt();

            // Calculate sum
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += i;
                System.out.print("Adding " + i + "...");
                Thread.sleep(500); // Sleep for 500 milliseconds
            }
            System.out.println("\nSum of numbers from 1 to " + num + " is: " + sum);

            // Calculate factorial
            long factorial = 1;
            for (int i = 1; i <= num; i++) {
                factorial *= i;
                System.out.print("Multiplying by " + i + "...");
                Thread.sleep(500); // Sleep for 500 milliseconds
            }
            System.out.println("\nFactorial of " + num + " is: " + factorial);

        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close(); // Properly close the Scanner
        }
    }
}