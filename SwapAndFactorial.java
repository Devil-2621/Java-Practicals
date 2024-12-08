import java.util.Scanner;

public class SwapAndFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Swapping two numbers without a third variable
        System.out.print("Enter two numbers to swap: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println("Before swapping: num1 = " + num1 + ", num2 = " + num2);

        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;

        System.out.println("After swapping: num1 = " + num1 + ", num2 = " + num2);

        // Finding the factorial of a number
        System.out.print("Enter a number to find its factorial: ");
        int number = scanner.nextInt();

        // Handle negative numbers
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long factorial = 1; // Use long to avoid integer overflow
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("Factorial of " + number + " is " + factorial);
        }

        scanner.close();
    }
}