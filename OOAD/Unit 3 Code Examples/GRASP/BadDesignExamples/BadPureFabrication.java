/**
 *
 * @author shridevisawant
 */
/**
 * Bad Design Example – No Pure Fabrication
 * Domain class handles database responsibility.
 */

// Domain Class doing too many things
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // Database responsibility inside domain class (Bad design)
    public void saveToDatabase() {
        System.out.println("Saving account with balance: " + balance);
    }
}

public class BadPureFabrication {
    public static void main(String[] args) {

        Account acc = new Account(5000);

        // Domain object doing persistence work
        acc.saveToDatabase();
    }
}