// Interface for basic shape operations

import java.util.Scanner;

interface ShapeOperations {
    double calculateArea();
    double calculateCircumference();
}

// Interface for 3D shape operations
interface Shape3DOperations {
    double calculateVolume();
}

// Abstract class implementing basic shape methods
abstract class Shape implements ShapeOperations {
    protected final double PI = Math.PI;
}

// Final class for Circle
final class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public double calculateCircumference() {
        return 2 * PI * radius;
    }
}

// Final class for Rectangle
final class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculateCircumference() {
        return 2 * (length + width);
    }
}

// Final class for Sphere (3D shape)
final class Sphere extends Shape implements Shape3DOperations {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 4 * PI * radius * radius;
    }

    @Override
    public double calculateCircumference() {
        return 2 * PI * radius;
    }

    @Override
    public double calculateVolume() {
        return (4.0/3.0) * PI * Math.pow(radius, 3);
    }
}

// Final class for Cube (3D shape)
final class Cube extends Shape implements Shape3DOperations {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return 6 * side * side;
    }

    @Override
    public double calculateCircumference() {
        return 12 * side;
    }

    @Override
    public double calculateVolume() {
        return Math.pow(side, 3);
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Enter radius for Circle:");
            double radius = scanner.nextDouble();
            Circle circle = new Circle(radius);
            System.out.println("\nCircle:");
            System.out.println("Area: " + circle.calculateArea());
            System.out.println("Circumference: " + circle.calculateCircumference());

            System.out.println("\nEnter length and width for Rectangle:");
            double length = scanner.nextDouble();
            double width = scanner.nextDouble();
            Rectangle rectangle = new Rectangle(length, width);
            System.out.println("\nRectangle:");
            System.out.println("Area: " + rectangle.calculateArea());
            System.out.println("Perimeter: " + rectangle.calculateCircumference());

            System.out.println("\nEnter radius for Sphere:");
            radius = scanner.nextDouble();
            Sphere sphere = new Sphere(radius);
            System.out.println("\nSphere:");
            System.out.println("Surface Area: " + sphere.calculateArea());
            System.out.println("Circumference: " + sphere.calculateCircumference());
            System.out.println("Volume: " + sphere.calculateVolume());

            System.out.println("\nEnter side length for Cube:");
            double side = scanner.nextDouble();
            Cube cube = new Cube(side);
            System.out.println("\nCube:");
            System.out.println("Surface Area: " + cube.calculateArea());
            System.out.println("Perimeter: " + cube.calculateCircumference());
            System.out.println("Volume: " + cube.calculateVolume());

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}