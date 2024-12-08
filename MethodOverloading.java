import java.util.Scanner;

public class MethodOverloading {
    // Method with integer parameters
    public double addfunc(int num1, int num2) {
        return num1 + num2;
    }
    
    // Method with double parameters
    public double addfunc(double num1, double num2) {
        return num1 + num2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MethodOverloading obj = new MethodOverloading();
        
        try {
            // Test with integers
            System.out.print("Enter first integer: ");
            int int1 = scanner.nextInt();
            System.out.print("Enter second integer: ");
            int int2 = scanner.nextInt();
            System.out.println("Sum of integers: " + obj.addfunc(int1, int2));
            
            // Test with doubles
            System.out.print("Enter first double: ");
            double double1 = scanner.nextDouble();
            System.out.print("Enter second double: ");
            double double2 = scanner.nextDouble();
            System.out.println("Sum of doubles: " + obj.addfunc(double1, double2));
            
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close(); // Properly closing the scanner
        }
    }
}