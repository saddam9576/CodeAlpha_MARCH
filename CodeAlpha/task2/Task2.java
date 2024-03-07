import java.util.Scanner;

public class task2 
{
    private static double balance = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
{
        System.out.println("Welcome to Simple Banking App!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using Simple Banking App!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }
    }

    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private static void checkBalance() {
        System.out.println("Your balance is: $" + balance);
}
}
