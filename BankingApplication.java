import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + " | New balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + " | New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance for withdrawal of " + amount);
        }
    }
}

class TransactionThread extends Thread {
    private BankAccount account;
    private boolean isDeposit;
    private double amount;

    public TransactionThread(BankAccount account, boolean isDeposit, double amount, String name) {
        super(name);
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            BankAccount jointAccount = new BankAccount(initialBalance);

            System.out.print("Enter number of transactions: ");
            int numTransactions = scanner.nextInt();

            Thread[] threads = new Thread[numTransactions];

            for (int i = 0; i < numTransactions; i++) {
                System.out.print("Transaction " + (i + 1) + " (1 for deposit, 2 for withdrawal): ");
                int type = scanner.nextInt();
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();

                threads[i] = new TransactionThread(jointAccount, type == 1, amount, "Transaction " + (i + 1));
            }

            // Start all threads
            for (Thread thread : threads) {
                thread.start();
            }

            // Wait for all threads to complete
            for (Thread thread : threads) {
                thread.join();
            }

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}