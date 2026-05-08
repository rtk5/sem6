/**
 *
 * @author shridevisawant
 */

/*
The Controller principle assigns responsibility for handling system 
events to a non-UI class that represents the system or a use-case.
*/

//Account (Domain Class)
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

//BankController (Controller Class)
class BankController {
    private Account account;

    public BankController(Account account) {
        this.account = account;
    }

    public void depositMoney(double amount) {
        account.deposit(amount);
    }

    public double getBalance() {
        return account.getBalance();
    }
}

// Simulating UI
public class ControllerDemo {
 
    public static void main(String[] args) {
        Account acc = new Account(1000);
        BankController controller = new BankController(acc);

        controller.depositMoney(500);
        System.out.println("Balance: " + controller.getBalance());
    }
}