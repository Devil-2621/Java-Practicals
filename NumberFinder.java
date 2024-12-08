import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println("Enter a string containing numbers: ");
            String input = scanner.nextLine();

            // Pattern for integers and decimal numbers
            String regex = "-?\\d+(\\.\\d+)?";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            boolean foundNumber = false;

            while (matcher.find()) {
                foundNumber = true;
                String number = matcher.group();
                if (number.contains(".")) {
                    System.out.println("Decimal: " + Double.parseDouble(number));
                } else {
                    System.out.println("Integer: " + Integer.parseInt(number));
                }
            }

            if (!foundNumber) {
                System.out.println("No numbers found in the string.");
            } else {
                System.out.println("Numbers found in the string.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}