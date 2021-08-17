package lesson7;

/**
 * 1. Реализовать программу, в которой задается граф из 10 вершин.
 * Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 */
public class HomeWorkApp {

    public static void main(String[] args) {
        testShortPathSearch();
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
        graph.addEdge("Москва", "Рязань");
        graph.addEdge("Москва", "Калуга");
        graph.addEdge("Воронеж", "Липецк");
        graph.addEdge("Воронеж", "Саратов");
        graph.addEdge("Воронеж", "Курск");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");

        graph.displayShortPath(graph.findShortPathViaBfs("Москва", "Воронеж"));
    }
}
