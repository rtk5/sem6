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

public class ControllerDemo {
    public static void main(String[] args) {
        Account account = new Account(1000);
        account.deposit(500);
        System.out.println("Current Balance: " + account.getBalance());
    }
}