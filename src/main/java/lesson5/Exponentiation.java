package lesson5;

/**
 * Класс содержит метод для возведения числа в степень с помощью рекурсии
 */
public class Exponentiation {

    public static int calculate(int base, int index) {

        if (index == 1) {
            return base;
        }
        return base * calculate(base, index - 1);
    }
}
