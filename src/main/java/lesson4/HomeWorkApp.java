package lesson4;

/**
 * Класс для тестов
 */
public class HomeWorkApp {

    public static void main(String[] args) {

        testForEachForLinkedList();
        testDequeLinkedListImpl();

    }

    private static void testForEachForLinkedList() {

        LinkedListImpl<Integer> linkedList = new LinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);

        for (Integer value : linkedList) {
            System.out.println(value);
        }
    }

    private static void testDequeLinkedListImpl() {

        var linkedList = new DequeLinkedListImpl<Integer>();
        linkedList.insertLeft(1);
        linkedList.insertLeft(2);
        linkedList.insertLeft(3);
        linkedList.insertLeft(4);
        linkedList.insertRight(5);
        linkedList.insertRight(6);
        linkedList.insertRight(7);

        linkedList.display();

        linkedList.removeLeft();
        linkedList.removeRight();
        linkedList.removeLeft();
        linkedList.removeRight();

        linkedList.display();
    }
}
