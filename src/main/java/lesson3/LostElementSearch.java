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
        int base;

        while (start <= end) {
            base = (start + end) / 2;

            if (arr[base] - base == 1) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }

        return start + 1;
    }
}
