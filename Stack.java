import java.util.Scanner;

public class Stack {
    private int[] stackArray;
    private int top;

    public Stack() {
        stackArray = new int[10];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            stackArray[top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int value = stackArray[top];
            top--;
            return value;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stackArray.length - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    int poppedValue = stack.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped value: " + poppedValue);
                    }
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);

        scanner.close();
    }
}