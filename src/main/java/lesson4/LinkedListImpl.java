package lesson4;

import java.util.Iterator;

/**
 * Реализация однонаправленного связного списка с итератором (доработанный код с занятия)
 *
 * @param <E>
 */
public class LinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected Node<E> firstElement;
    protected int size = 0;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;

        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
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
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    protected E getValue(Node<E> value) {
        return value != null ? value.item : null;
    }

    /**
     * Метод возвращает итератор
     *
     * @return итератор
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator(this);
    }

    /**
     * Реализация итератора для однонаправленного связного списка
     */
    private class LinkedListIterator implements Iterator<E> {

        private Node<E> returnedElement;
        private Node<E> current;


        public LinkedListIterator(LinkedListImpl<E> list) {
            current = list.firstElement;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {

            returnedElement = current;
            current = current.next;
            return returnedElement.item;
        }
    }
}
