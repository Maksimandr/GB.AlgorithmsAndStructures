package lesson2;

/**
 * Класс реализующий "Быструю сортировку" массива из Notebook`ов (для простоты обобщения реализовывать не стал)
 * Основан на коде "подсмотреном" в сети.
 */
public class ArrayQuickSort {

    public static void sort(Notebook[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Notebook base = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i].compareTo(base) < 0) {
                i++;
            }

            while (array[j].compareTo(base) > 0) {
                j--;
            }

            if (i <= j) {//меняем местами
                Notebook temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            sort(array, low, j);

        if (high > i)
            sort(array, i, high);
    }
}
