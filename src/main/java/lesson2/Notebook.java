package lesson2;

/**
 * Класс для ноутбуков имплементирует интерфейс Comparable
 */
public class Notebook implements Comparable<Notebook> {

    private int price;
    private int ramAmount;
    private int brandID;

    public Notebook(Integer price, Integer ramAmount, int brandID) {
        this.price = price;
        this.ramAmount = ramAmount;
        this.brandID = brandID;
    }

    public int getPrice() {
        return price;
    }

    public int getRamAmount() {
        return ramAmount;
    }

    public int getBrandID() {
        return brandID;
    }

    /**
     * Переопределяем метод сравнения согласно заданию
     * Условия для сортировки:
     * 1) по цене. От 500 до 1000 долларов с шагом в 100
     * если цена равная, то
     * 2) по кол-ву оперативной памяти (от 4 до 12 с шагом 4)
     * если памяти тоже равное количество, то
     * 3) по производителю:
     * Lenuvo > Asos > MacNote > Eser > Xamiou
     *
     * @param o ноутбук для сравнения
     * @return возвращает -1, 0 или 1 после сранения по заданным параметрам (меньше, равны, больше)
     */
    @Override
    public int compareTo(Notebook o) {
        if (this.price < o.getPrice()) {
            return -1;
        } else if (this.price > o.getPrice()) {
            return 1;
        } else {
            if (this.ramAmount < o.getRamAmount()) {
                return -1;
            } else if (this.ramAmount > o.getRamAmount()) {
                return 1;
            } else {
                if (this.brandID < o.getBrandID()) {
                    return -1;
                } else if (this.brandID > o.getBrandID()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", ramAmount=" + ramAmount +
                ", brandName=" + BrandNames.getBrandName(brandID) +
                '}';
    }
}
