package lesson2;

import java.util.Random;

/**
 * Класс для генерации случайного массива с ноутбуками (основан на классе с занятия)
 */
public class MyNotebookArray {

    private static final Random random = new Random();
    private static final int minPrice = 500;
    private static final int maxPrice = 1000;
    private static final int gapPrice = 100;
    private static final int minRamAmount = 4;
    private static final int maxRamAmount = 12;
    private static final int gapRamAmount = 4;
    public static boolean isShuffle = false;

    public static Notebook[] getArray(int length) {
        Notebook[] arr = new Notebook[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Notebook(minPrice + random.nextInt(((maxPrice - minPrice) / gapPrice) + 1) * gapPrice,
                    minRamAmount + random.nextInt(((maxRamAmount - minRamAmount) / gapRamAmount) + 1) * gapRamAmount,
                    random.nextInt(BrandNames.getBrandNamesArrayLength()));
        }
        if (isShuffle) {
            shuffleArray(arr);
        }
        return arr;
    }

    public static void shuffleArray(Notebook[] arr) {
        if (!isShuffle) {
            return;
        }
        int n = arr.length;
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(arr, i, change);
        }
    }

    private static void swap(Notebook[] a, int i, int change) {
        Notebook temp = a[i];
        a[i] = a[change];
        a[change] = temp;
    }
}
