/**
 *
 * @author shridevisawant
 */

/**
 * Bad Design Example – No Protected Variation
 * BankSystem directly depends on concrete classes.
 */

class SavingsAccount {
    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount {
    private double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    public double calculateInterest() {
        return balance * 0.02;
    }
}

class BankSystem {

    public void printInterest(String accountType, double balance) {

        if (accountType.equals("Savings")) {
            SavingsAccount acc = new SavingsAccount(balance);
            System.out.println("Interest: " + acc.calculateInterest());
        }
        else if (accountType.equals("Current")) {
            CurrentAccount acc = new CurrentAccount(balance);
            System.out.println("Interest: " + acc.calculateInterest());
        }
    }
}

public class BadPVDemo {
    public static void main(String[] args) {

        BankSystem bank = new BankSystem();

        bank.printInterest("Savings", 10000);
        bank.printInterest("Current", 10000);
    }
}