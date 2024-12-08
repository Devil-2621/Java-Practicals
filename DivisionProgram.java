import java.util.Scanner;

public class DivisionProgram {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            // If command line arguments are provided
            if (args.length == 2) {
                int num1 = Integer.parseInt(args[0]);
                int num2 = Integer.parseInt(args[1]);
                System.out.println("Result of division: " + (num1 / num2));
            }
            // If no command line arguments, use Scanner
            else {
                scanner = new Scanner(System.in);
                System.out.print("Enter first number: ");
                int num1 = scanner.nextInt();
                System.out.print("Enter second number: ");
                int num2 = scanner.nextInt();
                System.out.println("Result of division: " + (num1 / num2));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Please provide two numbers as arguments");
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integer numbers");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}