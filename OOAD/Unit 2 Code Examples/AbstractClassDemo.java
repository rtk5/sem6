/**
 *
 * @author shridevisawant
 */

abstract class BankAccount {

    String accountNumber;
    double balance;
       
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Abstract method
    abstract void calculateInterest();

    // Concrete method
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void displayBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    static double interestRate = 0.06;

    SavingsAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Savings Interest: " + interest);
    }
}

class CurrentAccount extends BankAccount {

    CurrentAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    void calculateInterest() {
        System.out.println("No interest for Current Account");
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {

        BankAccount acc1 = new SavingsAccount("SA101", 10000);
        BankAccount acc2 = new CurrentAccount("CA201", 15000);

        acc1.displayBalance();
        acc1.calculateInterest();

        acc2.displayBalance();
        acc2.calculateInterest();
    }
}