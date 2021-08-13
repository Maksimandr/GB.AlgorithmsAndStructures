package lesson5;

/**
 * Класс содержит метод для возведения числа в степень с помощью рекурсии
 */
public class Exponentiation {

    public static int calculate(int base, int index) {

        System.out.println("*");
        if (index == 1) {
            return base;
        } else if (index % 2 == 1) {
            return base * calculate(base, index - 1);
        } else {
            int x = calculate(base, index / 2);// если степень четная, то можно сократить глубину рекурсии
            return x * x;
        }

    }
}
