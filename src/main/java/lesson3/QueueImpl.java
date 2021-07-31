package lesson3;

/**
 * Доработанная реализация Queue, с циклической перезаписью в массив
 * @param <E>
 */
public class QueueImpl<E> implements Queue<E> {

    public static final int HEAD_DEFAULT = 0;
    public static final int TAIL_DEFAULT = -1;
    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = TAIL_DEFAULT;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        E value = data[head++];
        size--;

        if (head == data.length) {
            head = HEAD_DEFAULT;
        }

        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--> [");
        int index = head;
        for (int i = 0; i < size; i++) {
            sb.append(data[index]);
            if (index != tail) {
                sb.append(", ");
            }
            index++;
            if (index == data.length) {
                index = 0;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
