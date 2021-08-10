package lesson3;

/**
 * Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
 * Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
 * Примеры:
 * [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
 * [1, 2, 4, 5, 6] => 3
 * [] => 1
 */
public class LostElementSearch {

    public static int search(Integer[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int base = 0;
        int i = 0;

        while (end >= start) {
            i++;
            base = (start + end) / 2;

            if (arr[base] > base + 1) {
                end = base - 1;
            } else {
                start = base + 1;
            }
        }

        if (arr.length != 0 && arr[base] <= base + 1) {
            return base + 2;
        }
        return base + 1;
    }
}
