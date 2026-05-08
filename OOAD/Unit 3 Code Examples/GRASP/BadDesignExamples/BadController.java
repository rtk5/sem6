/**
 *
 * @author shridevisawant
 */

/**
 * Bad Design Example – No Controller
 * UI class directly handles business logic.
 */

// Domain class
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

// UI class handling everything (Bad practice)
public class BadController {

    public static void main(String[] args) {

        // UI directly creates and manages domain logic
        Account acc = new Account(1000);

        // UI performing business operation
        acc.deposit(500);

        // UI accessing domain logic directly
        System.out.println("Balance: " + acc.getBalance());
    }
}