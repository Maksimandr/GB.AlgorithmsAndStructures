package lesson4;

/**
 * Интерфейс Queue (код с занятия)
 * @param <E>
 */
public interface Queue<E> {

    boolean insert(E value);

    E remove();

    E peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();

}
