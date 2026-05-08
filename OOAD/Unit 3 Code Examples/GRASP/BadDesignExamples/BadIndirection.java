/**
 *
 * @author shridevisawant
 */

/**
 * Bad Design Example – No Indirection
 * Customer directly depends on Bank.
 */

class Bank {
    public void processPayment() {
        System.out.println("Payment processed by Bank");
    }
}

// Customer directly interacts with Bank
class Customer {
    private Bank bank = new Bank();

    public void pay() {
        bank.processPayment();
    }
}

public class BadIndirection {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.pay();
    }
}