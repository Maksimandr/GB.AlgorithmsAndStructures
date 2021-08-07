package lesson4;

/**
 * Реализация Deque
 * @param <E>
 */
public class DequeLinkedListImpl<E> extends QueueLinkedListImpl<E> implements Deque<E> {

    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        return data.removeLast();
    }
}
