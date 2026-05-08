
public class CommandPatternDemo {

    public static void main(String[] args) {
        Stock googleStock = new Stock("Google", 24);
        Stock appleStock = new Stock("Apple Inc", 10);
        BuyStock buyStockOrder = new BuyStock(appleStock);
        SellStock sellStockOrder = new SellStock(googleStock);
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.placeOrders();
    }
}
