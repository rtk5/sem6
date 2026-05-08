package factory;

import payment.*;

public class PaymentFactory {

    public static PaymentMethod getPaymentMethod(String type) {

        if (type == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }

        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment();
            case "paypal":
                return new PayPalPayment();
            case "upi":
                return new UpiPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type: " + type);
        }
    }
}
