public class Account {
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public Account(double initialBalance) {
        if (initialBalance >= 0) this.balance = initialBalance;
        else {
            this.balance = 0.0;
            System.out.println("Initial balance cannot be negative. Balance set to 0.0");
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit (double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            System.out.println("Deposit amount must be positive.");
            return false;
        }
    }

    public boolean withdraw (double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (amount > this.balance) {
            System.out.println("Insufficient funds. Current balance: $" + String.format("%.2f", this.balance));
            return false;
        }
        this.balance -= amount;
        return true;
    }
}


