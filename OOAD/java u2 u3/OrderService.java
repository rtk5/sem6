public class OrderService{
    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public void createOrder(Order order) {
        // Validate the order
        if (order == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order cannot be null or empty");
        }
        // Save the order to the repository
        orderRepository.save(order);
    }
}

class OrderItem(String productName, int quantity, double price) {
    this.productName = productName;
    this.quantity = quantity;
    this.price = price;
}

public double getTotalPrice() {
    return quantity * price;
}

@Override
public String toString() {
    return "OrderItem{" +
            "productName='" + productName + '\'' +
            ", quantity=" + quantity +
            ", price=" + price +
            '}';
}
}

class Order {
    private List<OrderItem> items;
    public Order(List<OrderItem> items) {
        this.items = items;
    }
    public List<OrderItem> getItems() {
        return items;
    }
    public double getTotalPrice() {
        return items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }
    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }   







}interface OrderRepository {
    void save(Order order);
}

class InMemoryOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();
    @Override
    public void save(Order order) {
        orders.add(order);
        System.out.println("Order saved: " + order);
    }
}

// Example usage
public class Main { 
    public static void main(String[] args) {
        OrderRepository orderRepository = new InMemoryOrderRepository();
        OrderService orderService = new OrderService(orderRepository);
        
        List<OrderItem> items = Arrays.asList(
            new OrderItem("Laptop", 1, 999.99),
            new OrderItem("Mouse", 2, 25.50)
        );
        Order order = new Order(items);
        
        orderService.createOrder(order);
    }
}   

public class Main { 
    public static void main(String[] args) {
        OrderRepository orderRepository = new InMemoryOrderRepository();
        OrderService orderService = new OrderService(orderRepository);
        
        List<OrderItem> items = Arrays.asList(
            new OrderItem("Laptop", 1, 999.99),
            new OrderItem("Mouse", 2, 25.50)
        );
        Order order = new Order(items);
        
        orderService.createOrder(order);
    }
}   