package lesson7;

/**
 * 1. Реализовать программу, в которой задается граф из 10 вершин.
 * Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 */
public class HomeWorkApp {

    public static void main(String[] args) {
        testShortPathSearch();
        testShortPathSearchWithWeightEdge();
    }

    public static void testShortPathSearch() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Москва");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Воронеж");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");

        graph.addEdge("Москва", "Рязань");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");

        graph.addEdge("Москва", "Калуга");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");

        graph.displayShortPath(graph.findShortPathViaBfs("Москва", "Воронеж"), false);
    }

    private static void testShortPathSearchWithWeightEdge() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Москва");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Воронеж");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdgeWithWeight("Москва", "Тула", 20);
        graph.addEdgeWithWeight("Тула", "Липецк", 20);
        graph.addEdgeWithWeight("Липецк", "Воронеж", 10);

        graph.addEdgeWithWeight("Москва", "Рязань", 3);
        graph.addEdgeWithWeight("Рязань", "Тамбов", 6);
        graph.addEdgeWithWeight("Тамбов", "Саратов", 30);
        graph.addEdgeWithWeight("Саратов", "Воронеж", 3);

        graph.addEdgeWithWeight("Москва", "Калуга", 4);
        graph.addEdgeWithWeight("Калуга", "Орел", 30);
        graph.addEdgeWithWeight("Орел", "Курск", 4);
        graph.addEdgeWithWeight("Курск", "Воронеж", 3);

        graph.displayShortPath(graph.findShortPathWithWeightEdge("Москва", "Воронеж"), true);
    }
}
