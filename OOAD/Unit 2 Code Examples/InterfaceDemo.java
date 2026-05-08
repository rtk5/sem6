

/**
 *
 * @author shridevisawant
 */
interface Payment {
    void pay(int amount);
   }

class CreditCardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UpiPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class CashPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}


public class InterfaceDemo {

public static void main(String[] args) {
   

        Payment p;

        p = new CreditCardPayment();
        p.pay(1000);

        p = new UpiPayment();
        p.pay(500);

        p = new CashPayment();
        p.pay(200);

        p.display();
    }
    

}