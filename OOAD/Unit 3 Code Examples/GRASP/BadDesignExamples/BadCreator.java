/**
 *
 * @author shridevisawant
 */

import java.util.ArrayList;
import java.util.List;

class OrderItem {
    private String productName;
    private int quantity;
    private double price;

    public OrderItem(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return productName + " x" + quantity + " = $" + getTotal();
    }
}

class Order {
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {   // receives object instead of creating it
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public void showOrder() {
        for (OrderItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total = $" + calculateTotal());
    }
}

public class BadCreator {
    public static void main(String[] args) {

        Order order = new Order();

        // BAD DESIGN: main class creating OrderItem
        OrderItem item1 = new OrderItem("Laptop", 1, 1000);
        OrderItem item2 = new OrderItem("Mouse", 2, 25);

        order.addItem(item1);
        order.addItem(item2);

        order.showOrder();
    }
}