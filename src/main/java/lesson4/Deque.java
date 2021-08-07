package lesson4;

/**
 * Интерфейс Queue (код с занятия)
 * @param <E>
 */
public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();
}