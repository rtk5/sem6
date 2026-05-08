package Iterator;

import java.util.ArrayList;

public class Collection implements AbstractCollection {
    private ArrayList<Item> items = new ArrayList<Item>();

    public Iterator createIterator() {
        return new Iterator(this);
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item get(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }
}

