package lesson1;

import java.math.BigInteger;

public class HomeWorkApp {

    static int i = 1;

    public static void main(String[] args) {

        System.out.println(fib(BigInteger.valueOf(26)));
    }

    public static BigInteger fib(BigInteger n) {
        System.out.println(i++);
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ZERO;
        }
        if (n.equals(BigInteger.TWO)) {
            return BigInteger.ONE;
        }
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));
    }
}
