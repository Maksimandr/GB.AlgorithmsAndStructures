package lesson2;

/**
 * Класс для метода мэйн
 * Сортировка массива из 5000 элементов выполняется 2-5 мс
 */
public class HomeWorkApp {

    private static Long time;

    public static void main(String[] args) {
        final int SIZE = 5000;
        Notebook[] arr = MyNotebookArray.getArray(SIZE);

        for (Notebook n : arr) {
            System.out.println(n);
        }

        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();

        int low = 0;
        int high = SIZE - 1;

        startTime();
        ArrayQuickSort.sort(arr, low, high);
        endTime();

        for (Notebook n : arr) {
            System.out.println(n);
        }

        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println(time);
    }

    private static void startTime() {
        time = System.currentTimeMillis();
    }

    private static void endTime() {
        time = System.currentTimeMillis() - time;
    }
}
