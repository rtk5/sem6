/**
 *
 * @author shridevisawant
 */

/* Low Coupling- designing classes so that changes in one class 
have minimal impact on other classes.

BankSystem works with Account abstraction, 
not with specific account types.

*/

interface Account {
    void calculateInterest();
}

class SavingsAccount implements Account {
    public void calculateInterest() {
        System.out.println("Savings Account Interest");
    }
}

class CurrentAccount implements Account {
    public void calculateInterest() {
        System.out.println("Current Account Interest");
    }
}

class BankSystem {
    private Account account;  // Depends on interface, not concrete class

    public BankSystem(Account account) {
        this.account = account;
    }

    public void processAccount() {
        account.calculateInterest();
    }
}

public class LowCouplingDemo {
    public static void main(String[] args) {
        Account acc = new SavingsAccount();
        BankSystem bank = new BankSystem(acc);
        bank.processAccount();
    }
}