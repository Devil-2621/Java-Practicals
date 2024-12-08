import java.util.Scanner;

class SuperClass {
    int x;

    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value for superclass x: ");
        x = scanner.nextInt();
        System.out.println("Value of x in superclass: " + x);
        scanner.close();
    }
}

class SubClass extends SuperClass {
    int x;

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value for subclass x: ");
        x = scanner.nextInt();
        System.out.println("Value of x in subclass: " + x);
        super.show();
        scanner.close();
    }

    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.show();
    }
}