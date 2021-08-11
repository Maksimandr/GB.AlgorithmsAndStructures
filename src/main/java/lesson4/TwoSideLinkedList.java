package lesson4;

/**
 * Интерфейс двунаправленного связного списка (доработанный код с занятия)
 * @param <E>
 */
public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLast(E value);

    E getLast();

    E removeLast();// добавлен метод для удаления последнего элемента

}
