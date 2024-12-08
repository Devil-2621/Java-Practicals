import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num;
        try {
            num = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.close();
            return;
        }

        int originalNum = num;
        int reversedNum = 0;

        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }

        if (originalNum == reversedNum) {
            System.out.println(originalNum + " is a palindrome.");
        } else {
            System.out.println(originalNum + " is not a palindrome.");
        }

        scanner.close(); // Close the scanner after use
    }
}