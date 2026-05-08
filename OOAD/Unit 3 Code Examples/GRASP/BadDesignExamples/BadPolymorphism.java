/**
 *
 * @author shridevisawant
 */
/**
 * Bad Design Example – No Polymorphism
 * Uses conditional statements instead of letting objects handle behavior.
 */

class PaymentProcessor {

    public void processPayment(String paymentType) {

        if (paymentType.equals("CreditCard")) {
            System.out.println("Processing Credit Card payment");
        } 
        else if (paymentType.equals("UPI")) {
            System.out.println("Processing UPI payment");
        } 
        else {
            System.out.println("Invalid payment type");
        }
    }
}

public class BadPolymorphism {
    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        processor.processPayment("CreditCard");
        processor.processPayment("UPI");
    }
}