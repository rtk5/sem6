package Iterator;

public interface AbstractIterator {
	Item next();
    boolean isDone();
    Item currentItem();
    void setStep(int step);
}
