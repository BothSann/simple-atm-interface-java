import java.util.Scanner;

public class ATM {
    private Account account;
    private Scanner scanner;

    public ATM () {
        this.account = new Account(1000);
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Select an option (1-4): ");
    }

    public void checkBalance() {
        System.out.println("\n===== BALANCE INQUIRY =====");
        System.out.println("Current balance: $" + String.format("%.2f", account.getBalance()));
    }

    public void deposit() {
        System.out.println("\n===== DEPOSIT MONEY =====");
        System.out.print("Enter amount to deposit: $");

        try {
            double amount = scanner.nextDouble();
            if(account.deposit(amount)) {
                System.out.println("Successfully deposited: $" + String.format("%.2f", amount));
                System.out.println("New balance: $" + String.format("%.2f", account.getBalance()));
                System.out.println("Transaction completed successfully.");
            }
        } catch(Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    public void withdraw() {
        System.out.println("\n===== WITHDRAW MONEY =====");
        System.out.print("Enter amount to withdraw: $");

        try {
            double amount = scanner.nextDouble();
            if(account.withdraw(amount)) {
                System.out.println("Successfully withdrew: $" + String.format("%.2f", amount));
                System.out.println("Remaining balance: $" + String.format("%.2f", account.getBalance()));
                System.out.println("Transaction completed successfully.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    public void exit() {
        System.out.println("Thank you for using the ATM. Goodbye! <3");
    }

    public boolean processChoice(int choice) {
        return switch(choice) {
            case 1 -> {
                checkBalance();
                yield true;
            }
            case 2 -> {
                deposit();
                yield true;
            }
            case 3 -> {
                withdraw();
                yield true;
            }
            case 4 -> {
                exit();
                yield false;
            }
            default -> {
                System.out.println("Invalid choice. Please select a valid option.");
                yield true;
            }
        };
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }

}