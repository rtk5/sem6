// Subsystem classes
class AuthService {
    public void login(String user) {
        System.out.println("User logged in: " + user);
    }
}

class ProductService {
    public void selectProduct(String product) {
        System.out.println("Product selected: " + product);
    }
}

class PaymentService {
    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed successfully.");
    }
}

class OrderService {
    public void trackOrder(String orderId) {
        System.out.println("Order " + orderId + " is now being tracked.");
    }
}

// Facade — single unified interface for the complex purchase flow
class ECommerceFacade {
    private AuthService auth       = new AuthService();
    private ProductService product = new ProductService();
    private PaymentService payment = new PaymentService();
    private OrderService order     = new OrderService();

    public void completePurchase(String user, String productName,
                                 double amount, String orderId) {
        System.out.println("=== Starting Purchase Flow ===");
        auth.login(user);
        product.selectProduct(productName);
        payment.makePayment(amount);
        order.trackOrder(orderId);
        System.out.println("=== Purchase Completed Successfully ===");
    }
}

// Client — interacts only with the Facade
public class ECommerceApp {
    public static void main(String[] args) {
        ECommerceFacade facade = new ECommerceFacade();
        facade.completePurchase("Alice", "Wireless Headphones", 2999.99, "ORD-00421");
    }
}