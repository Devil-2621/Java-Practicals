import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class GregorianCalendarDemo {
    public static void main(String[] args) {
        // Create Gregorian Calendar instance
        GregorianCalendar gc = new GregorianCalendar();

        // Get current date and time
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm:ss");
        System.out.println("Current Date and Time: " + sdf.format(gc.getTime()));

        // Get current year and check if it's a leap year
        int currentYear = gc.get(Calendar.YEAR);
        System.out.println("\nChecking if " + currentYear + " is a leap year...");
        if (gc.isLeapYear(currentYear)) {
            System.out.println(currentYear + " is a leap year.");
        } else {
            System.out.println(currentYear + " is not a leap year.");
        }

        // Check custom year
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a year to check if it's a leap year: ");
        int customYear = scanner.nextInt();
        
        if (gc.isLeapYear(customYear)) {
            System.out.println(customYear + " is a leap year.");
        } else {
            System.out.println(customYear + " is not a leap year.");
        }

        // Close the scanner
        scanner.close();
    }
}