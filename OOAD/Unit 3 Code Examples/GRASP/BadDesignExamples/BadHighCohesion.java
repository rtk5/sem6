/**
 *
 * @author shridevisawant
 */
/**
 * Bad Design Example – Low Cohesion
 * One class is doing too many unrelated tasks.
 */

class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // Balance operation
    public void deposit(double amount) {
        balance += amount;
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    // Unrelated responsibility – printing account report
    public void printReport() {
        System.out.println("Generating Account Report...");
    }

    // Unrelated responsibility – sending email notification
    public void sendEmailNotification() {
        System.out.println("Sending email to customer...");
    }

    // Unrelated responsibility – calculating tax
    public void calculateTax() {
        System.out.println("Calculating tax on account...");
    }
}

public class BadHighCohesion {
    public static void main(String[] args) {
        Account acc = new Account(1000);
        acc.deposit(500);
        acc.displayBalance();
        acc.printReport();
        acc.sendEmailNotification();
        acc.calculateTax();
    }
}