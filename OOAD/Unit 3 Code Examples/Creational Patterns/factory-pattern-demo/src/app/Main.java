package app;

import factory.PaymentFactory;
import payment.PaymentMethod;

public class Main {
    public static void main(String[] args) {

        PaymentMethod payment1 = PaymentFactory.getPaymentMethod("creditcard");
        payment1.pay(500);

        PaymentMethod payment2 = PaymentFactory.getPaymentMethod("upi");
        payment2.pay(300);

        PaymentMethod payment3 = PaymentFactory.getPaymentMethod("paypal");
        payment3.pay(700);
    }
}
