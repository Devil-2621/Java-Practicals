import java.util.Scanner;

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create three threads
        Thread thread1 = new Thread(new WorkerThread(), "High Priority Thread");
        Thread thread2 = new Thread(new WorkerThread(), "Normal Priority Thread");
        Thread thread3 = new Thread(new WorkerThread(), "Low Priority Thread");

        // Set different priorities
        thread1.setPriority(Thread.MAX_PRIORITY); // Priority 10
        thread2.setPriority(Thread.NORM_PRIORITY); // Priority 5
        thread3.setPriority(Thread.MIN_PRIORITY); // Priority 1

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Display thread information
        System.out.println("Thread 1 Name: " + thread1.getName() + ", Priority: " + thread1.getPriority());
        System.out.println("Thread 2 Name: " + thread2.getName() + ", Priority: " + thread2.getPriority());
        System.out.println("Thread 3 Name: " + thread3.getName() + ", Priority: " + thread3.getPriority());

        // Wait for user input before closing
        System.out.println("\nPress Enter to exit...");
        scanner.nextLine();
        scanner.close();
    }
}

class WorkerThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " is running task " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}