package lesson4;

/**
 * Реализация Queue (код с занятия)
 * @param <E>
 */
public class QueueLinkedListImpl<E> implements Queue<E> {

    protected final TwoSideLinkedList<E> data;

    public QueueLinkedListImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedQueueImpl{" + "data=" + data + '}';
    }
}
