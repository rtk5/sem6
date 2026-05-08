/**
 *
 * @author shridevisawant
 */
/**
 * Bad Design Example – High Coupling
 * BankSystem depends directly on concrete classes.
 */

class SavingsAccount {
    public void calculateInterest() {
        System.out.println("Savings Account Interest");
    }
}

class CurrentAccount {
    public void calculateInterest() {
        System.out.println("Current Account Interest");
    }
}

class BankSystem {

    private SavingsAccount savings;
    private CurrentAccount current;

    public BankSystem() {
        savings = new SavingsAccount();
        current = new CurrentAccount();
    }

    public void processSavingsAccount() {
        savings.calculateInterest();
    }

    public void processCurrentAccount() {
        current.calculateInterest();
    }
}

public class BadLowCoupling {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();
        bank.processSavingsAccount();
        bank.processCurrentAccount();
    }
}