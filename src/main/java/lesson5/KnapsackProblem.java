package lesson5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * «Задача о рюкзаке» с помощью рекурсии
 */
public class KnapsackProblem {

    // множество содержащее наилучшие наборы вещей
    private static Set<List<Item>> bestItemsListSet = new HashSet<>();
    // цена наиболее дорого набора вещей
    private static int bestItemsPrice = 0;
    //максимальная емкость рюкзака
    private static int maxCapacity;

    /**
     * Метод задает емкость рюкзака, набор вещей и выводит результат
     */
    public static void KnapsackProblemExample() {
        maxCapacity = 15;
        List<Item> items = new ArrayList<>();
        items.add(new Item("1", 4, 12));
        items.add(new Item("2", 12, 12));
        items.add(new Item("3", 2, 2));
        items.add(new Item("4", 2, 3));
        items.add(new Item("5", 12, 9));
        items.add(new Item("6", 5, 5));
        items.add(new Item("7", 4, 3));
        items.add(new Item("8", 12, 5));
        items.add(new Item("9", 8, 7));
        items.add(new Item("10", 3, 3));
        // при таком наборе предметов и емкости лучшая цена 24
        // и возможны два набора предметов 7, 8, 9 с весом 15
        // и  5, 8 с весом 14

        calculate(items);
        System.out.println("Исходный набор предметов -> " + items);
        System.out.println("Емкость рюкзака = " + maxCapacity);
        System.out.println("Лучшая стоимость = " + bestItemsPrice);
        for (List<Item> l : bestItemsListSet) {
            System.out.println("-------------------------------------------");
            System.out.println(l);
            System.out.println("Вес вещей = " + getItemsWeight(l));
        }
    }

    /**
     * Метод перебирает все возможные комбинации вещей при помощи рекурсии
     * @param items список вещей
     */
    public static void calculate(List<Item> items) {
        if (items.size() > 0) {
            checkItemsList(items);
        } else {
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            List<Item> subList = new ArrayList<>(items);
            subList.remove(i);
            calculate(subList);
        }
    }

    private static void checkItemsList(List<Item> items) {
        int itemsPrice = getItemsPrice(items);
        int itemsWeight = getItemsWeight(items);
        if (itemsWeight <= maxCapacity && itemsPrice > bestItemsPrice) {
            bestItemsPrice = itemsPrice;
            if (bestItemsListSet.size() > 0) {
                bestItemsListSet.clear();
            }
            bestItemsListSet.add(new ArrayList<>(items));
        } else if (itemsWeight <= maxCapacity && itemsPrice == bestItemsPrice) {
            bestItemsListSet.add(new ArrayList<>(items));
        }
    }

    private static int getItemsPrice(List<Item> items) {
        int itemsPrice = 0;
        for (Item i : items) {
            itemsPrice += i.price;
        }
        return itemsPrice;
    }

    private static int getItemsWeight(List<Item> items) {
        int itemsWeight = 0;
        for (Item i : items) {
            itemsWeight += i.weight;
        }
        return itemsWeight;
    }

    private static class Item {
        private final String name;
        private final int price;
        private final int weight;

        public Item(String name, int price, int weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", weight=" + weight +
                    '}';
        }
    }
}
