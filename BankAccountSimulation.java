import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountSimulation {

    // Account class inside main program
    static class Account {
        private String accountHolder;
        private double balance;
        private List<String> transactionHistory;

        public Account(String accountHolder) {
            this.accountHolder = accountHolder;
            this.balance = 0.0;
            this.transactionHistory = new ArrayList<>();
            transactionHistory.add("Account created for " + accountHolder);
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                transactionHistory.add("Deposited: $" + amount);
                System.out.println("Deposited: $" + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                transactionHistory.add("Withdrew: $" + amount);
                System.out.println("Withdrew: $" + amount);
            } else {
                System.out.println("Invalid withdrawal amount or insufficient balance.");
            }
        }

        public double getBalance() {
            return balance;
        }

        public void printTransactionHistory() {
            System.out.println("\nTransaction History for " + accountHolder + ":");
            for (String record : transactionHistory) {
                System.out.println(record);
            }
        }
    }

    // Main method with menu loop
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name to open a bank account: ");
        String name = scanner.nextLine();

        Account account = new Account(name);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: $" + account.getBalance());
                    break;
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using our bank system!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
