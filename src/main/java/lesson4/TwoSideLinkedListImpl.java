package lesson4;

/**
 * Реализация двунаправленного связного списка (доработанный код с занятия)
 * @param <E>
 */
public class TwoSideLinkedListImpl<E> extends LinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Node<E> lastElement;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);

        if (size == 1) {
            lastElement = firstElement;
        } else {
            firstElement.next.previous = firstElement;// устанавливаем ссылку на новый элемент
        }
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null, lastElement);// у создаваемого елемента задаем сразу ссылку на текущий последний элемент

        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }

        lastElement = newNode;
        size++;
    }

    @Override
    public E getLast() {
        return getValue(lastElement);
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = lastElement;
        lastElement = removedNode.previous;
        lastElement.next = null;// обнуляем ссылку на следующий элемент у нового последнего элемента
        removedNode.previous = null;

        size--;

        if (isEmpty()) {
            firstElement = null;
        }
        return removedNode.item;
    }


    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        } else {
            firstElement.previous = null;// обнуляем ссылку на предыдущий элемент у нового первого элемента
        }
        return removedValue;
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
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }
}
