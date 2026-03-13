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
    private Account account;

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