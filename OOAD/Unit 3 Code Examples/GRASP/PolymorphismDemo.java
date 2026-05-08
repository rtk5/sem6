/**
 *
 * @author shridevisawant
 */

/*
GRASP polymorphism - When behavior varies based on type, 
assign responsibility to the types for which the behavior varies.


*/
// common interface
interface Payment {
    void processPayment();
}

//Different payment types implement behavior
class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing Credit Card payment");
    }
}

class UPIPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing UPI payment");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment();
        payment.processPayment();

        payment = new UPIPayment();
        payment.processPayment();
    }
}