package Iterator;

public class IteratorRealWorldExample {

    public static void main(String[] args) {
        // Build a collection
        Collection collection = new Collection();
        collection.add(new Item("Item 0"));
        collection.add(new Item("Item 1"));
        collection.add(new Item("Item 2"));
        collection.add(new Item("Item 3"));
        collection.add(new Item("Item 4"));
        collection.add(new Item("Item 5"));
        collection.add(new Item("Item 6"));
        collection.add(new Item("Item 7"));
        collection.add(new Item("Item 8"));

        // Create iterator
        Iterator iterator = collection.createIterator();

        // Skip every other item
        iterator.setStep(2);

        System.out.println("Iterating over collection:");
        while (!iterator.isDone()) {
            Item item = iterator.next();
            if (item != null) {
                System.out.println(item.getName());
            }
        }

    }
}
