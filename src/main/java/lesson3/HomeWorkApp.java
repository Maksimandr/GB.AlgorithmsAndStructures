package lesson3;

import java.util.Arrays;

public class HomeWorkApp {

    public static void main(String[] args) {

//        lostElementSearch();
//
//        queueArrayImproved();

        dequeImpl();

    }

    public static void lostElementSearch() {

        Integer[][] arr = new Integer[6][];
        arr[0] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};// 11
        arr[1] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16};//10
        arr[2] = new Integer[]{1, 2, 4, 5, 6};// 3
        arr[3] = new Integer[]{1, 2, 4, 5};// 3
        arr[4] = new Integer[]{2};// 1
        arr[5] = new Integer[]{};// 1

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
            System.out.println(LostElementSearch.search(arr[i]));
        }
    }

    public static void queueArrayImproved() {
        Queue<Integer> queue = new QueueImpl<>(5);
        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));
        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();
        System.out.println("add element: " + queue.insert(117));
        System.out.println("add element: " + queue.insert(127));
        queue.display();
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.println("add element: " + queue.insert(234));
        System.out.println("add element: " + queue.insert(212));
        System.out.println("add element: " + queue.insert(220));
        System.out.println("add element: " + queue.insert(216));
        queue.display();
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.println("add element: " + queue.insert(316));
        System.out.println("add element: " + queue.insert(320));
        queue.display();
    }

    public static void dequeImpl() {
        Deque<Integer> deque = new DequeImpl<>(5);
        System.out.println("add element: " + deque.insertRight(34));
        System.out.println("add element: " + deque.insertRight(12));
        System.out.println("add element: " + deque.insertRight(20));
        System.out.println("add element: " + deque.insertRight(16));
        System.out.println("add element: " + deque.insertRight(14));
        System.out.println("add element: " + deque.insertRight(17));
        deque.display();
        System.out.println("remove: " + deque.removeRight());
        deque.display();
        System.out.println("add element: " + deque.insertLeft(117));
        System.out.println("add element: " + deque.insertLeft(127));
        deque.display();
        System.out.println("remove: " + deque.removeLeft());
        deque.display();
        System.out.println("add element: " + deque.insertLeft(117));
        System.out.println("add element: " + deque.insertLeft(127));
        deque.display();
        System.out.println("remove: " + deque.removeLeft());
        System.out.println("remove: " + deque.removeLeft());
        System.out.println("remove: " + deque.removeLeft());
        System.out.println("remove: " + deque.removeLeft());
        System.out.println("remove: " + deque.removeLeft());
        deque.display();
        System.out.println("add element: " + deque.insertLeft(117));
        System.out.println("add element: " + deque.insertRight(14));
        System.out.println("add element: " + deque.insertRight(17));
        System.out.println("add element: " + deque.insertLeft(127));
        System.out.println("add element: " + deque.insertRight(327));
        deque.display();
    }
}
