/**
 *
 * @author shridevisawant
 */

/*
Protected / Controlled Variation:
Identify points of variation (future changes) and create a stable 
interface around them so that changes do not affect other parts of 
the system.

*/


//Stable Interface (Protection Layer)
//The Account interface protects BankSystem from changes in 
//interest logic.
interface Account {
    double calculateInterest();
}

//Different Variations Implement Stable interface
class SavingsAccount implements Account {
    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}


class CurrentAccount implements Account {
    private double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    public double calculateInterest() {
        return balance * 0.02;
    }
}

//Depends on Stable Interface
class BankSystem {
    public void printInterest(Account account) {
        System.out.println("Interest: " + account.calculateInterest());
    }
}

public class ProtectedVariationDemo {
    public static void main(String[] args) {
        Account acc = new SavingsAccount(10000);
        BankSystem bank = new BankSystem();
        bank.printInterest(acc);
    }
}