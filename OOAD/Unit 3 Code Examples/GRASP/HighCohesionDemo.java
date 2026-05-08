/**
 *
 * @author shridevisawant
 */

/*
High Cohesion:
A class should have closely related responsibilities and focus on 
doing one well-defined task.

The Account class manages only balance-related operations.
*/

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class HighCohesionDemo {
    public static void main(String[] args) {
        Account acc = new Account(1000);
        acc.deposit(500);
        acc.displayBalance();
    }
}