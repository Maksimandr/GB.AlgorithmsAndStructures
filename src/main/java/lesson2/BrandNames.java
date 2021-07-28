package lesson2;

/**
 * Класс для хранения упорядоченного перечня брендов (сделал для удобства)
 */
public class BrandNames {

    private static String[] brandNames = {"Xamiou", "Eser", "MacNote", "Asos", "Lenuvo"};

    public static int getBrandNamesArrayLength() {
        return brandNames.length;
    }

    public static String getBrandName(int i) {
        return brandNames[i];
    }

    public static String[] getBrandNames() {
        return brandNames;
    }

}
