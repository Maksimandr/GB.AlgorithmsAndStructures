package lesson3;

import java.util.Arrays;

public class HomeWorkApp {

    public static void main(String[] args) {

        lostElementSearch();



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
}
