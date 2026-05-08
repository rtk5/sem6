/**
 *
 * @author shridevisawant
 */

/*
Pure Fabrication - Assign responsibilities to an artificial class 
    that does not represent a domain concept, 
    to achieve High Cohesion and Low Coupling.
*/

// Domain Class – Only Business Logic
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}

//Artificial Class (Pure Fabrication)
// Pure Fabrication creates an artificial class to handle responsibilities that do not naturally belong to domain objects.
// AccountRepository is created to handle database operations.
class AccountRepository {
    public void save(Account account) {
        System.out.println("Saving account with balance: " + account.getBalance());
    }
}

public class PureFabricationDemo {
    public static void main(String[] args) {
        Account acc = new Account(5000);

        AccountRepository repo = new AccountRepository();
        repo.save(acc);
    }
}