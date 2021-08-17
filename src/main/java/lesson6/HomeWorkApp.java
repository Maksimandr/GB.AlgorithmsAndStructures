package lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 1. Создать и запустить программу для построения двоичного дерева. В цикле построить
 * двадцать деревьев с глубиной в 6(4) уровней. Данные, которыми необходимо заполнить узлы деревьев,
 * представляются в виде чисел типа int. Число, которое попадает в узел, должно генерироваться
 * случайным образом в диапазоне от -100(-25) до 100(25).
 * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
 */
public class HomeWorkApp {

    private static int MAX_LEVEL = 4;
    private static int MAX_NODES_AMOUNT = 10;
    private static int NODES_VALUE = 25;
    private static int TREES_AMOUNT = 20;

    public static void main(String[] args) {

        List<Tree<Integer>> treeList = new ArrayList<>();
        int countBalancedTree = 0;
        for (int i = 0; i < TREES_AMOUNT; i++) {
            treeList.add(createTree());
            treeList.get(i).display();
            boolean isBalanced = treeList.get(i).isBalanced();
            if (isBalanced) {
                countBalancedTree++;
            }
            System.out.println("Дерево сбалансировано: " + isBalanced);
        }
        System.out.println();
        System.out.println("Из " + TREES_AMOUNT + " деревьев сбалансированны " + countBalancedTree + " или " + 100.0 * countBalancedTree / TREES_AMOUNT + "%");
    }

    /**
     * Метод создает дерево с заданными параметрами
     */
    public static Tree<Integer> createTree() {
        Tree<Integer> tree = new TreeImpl<>(MAX_LEVEL);
        Random random = new Random();
        for (int i = 0; i < MAX_NODES_AMOUNT; i++) {
            tree.add(random.nextInt(NODES_VALUE * 2 + 1) - NODES_VALUE);
        }
        return tree;
    }
}
