/**
 *
 * @author shridevisawant
 */


/*
Indirection - Assign responsibility to an intermediate object to 
avoid direct coupling between two classes.
*/

class Bank {
    public void processPayment() {
        System.out.println("Payment processed by Bank");
    }
}

// Indirection Layer
class PaymentService {
    private Bank bank = new Bank();

    public void makePayment() {
        bank.processPayment();
    }
}

//Customer Depends on PaymentService - Not Bank
class Customer {
    private PaymentService paymentService = new PaymentService();

    public void pay() {
        paymentService.makePayment();
    }
}

public class IndirectionDemo {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.pay();
    }
}