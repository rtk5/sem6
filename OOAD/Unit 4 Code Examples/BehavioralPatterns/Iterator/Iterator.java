package Iterator;

class Iterator implements AbstractIterator {
    private Collection collection;
    private int current = 0;
    private int step = 1;

    public Iterator(Collection collection) {
        this.collection = collection;
    }

    public Item first() {
        current = 0;
        return collection.get(current);
    }

    public Item next() {
        current += step;
        if (!isDone()) {
            return collection.get(current);
        } else {
            return null;
        }
    }

    public boolean isDone() {
        return current >= collection.size();
    }

    public Item currentItem() {
        return collection.get(current);
    }

    public void setStep(int step) {
        this.step = step;
    }
}

