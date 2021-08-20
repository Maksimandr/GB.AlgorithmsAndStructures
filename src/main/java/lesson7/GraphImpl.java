package lesson7;

import java.util.*;

public class GraphImpl implements Graph {
    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);
        for (String other : others) {
            result &= addEdge(startLabel, other);
        }
        return result;
    }

    public boolean addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = 1;
        adjMatrix[endIndex][startIndex] = 1;

        return true;
    }


    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
//        System.out.println(vertex.getLabel());
        stack.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
    }

    /**
     * Метод находит кратчайший путь с помощью поиска в ширину для не взвешенного графа.
     * В этом случае кратчайший путь содержит наименьшее количество вершин/ребер,
     * т.е первый из маршрутов достигший финиша кратчайший.
     *
     * @param startLabel  начало пути
     * @param finishLabel точка назначения
     */
    @Override
    public Stack<String> findShortPathViaBfs(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        } else if (finishIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + finishLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        Vertex previousVertex;

        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            previousVertex = queue.peek();
            vertex = getNearUnvisitedVertex(previousVertex);
            if (vertex != null) {
                vertex.setPreviousVertex(previousVertex);
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        // создаем стек с кратчайшим путем, для этого проходим от конечного пункта до старта через ссылку на предыдущий узел
        Stack<String> vertexStack = new Stack<>();
        vertex = vertexList.get(finishIndex);
        vertexStack.add(finishLabel);
        while (vertex.getPreviousVertex() != null) {
            vertex = vertex.getPreviousVertex();
            vertexStack.add(vertex.getLabel());
        }
        return vertexStack;
    }

    /**
     * Выводит на экран кратчайший путь
     * @param stringStack стек содержащий названия вершин
     * @param withWeight для взвешенного графа выводится расстояние минимального пути
     */
    public void displayShortPath(Stack<String> stringStack, boolean withWeight) {

        if (withWeight) {
            System.out.println("Кратчайший путь от " + stringStack.peek() + " до " + stringStack.firstElement() + " : " + vertexList.get(indexOf(stringStack.firstElement())).getDistanceFromStart());
        } else {
            System.out.println("Кратчайший путь от " + stringStack.peek() + " до " + stringStack.firstElement() + " : ");
        }

        while (!stringStack.isEmpty()) {
            System.out.print(stringStack.pop());
            if (!stringStack.isEmpty()) {
                System.out.print(" -> ");
            } else {
                System.out.println();
                System.out.println("------------------------------");
            }
        }
    }

    /**
     * Метод задает задает ребра с указанным весом
     *
     * @param startLabel первая вершина ребра
     * @param endLabel   вторая вершина ребра
     * @param edgeWeight вес ребра
     * @return true если удалось добавить
     */
    public boolean addEdgeWithWeight(String startLabel, String endLabel, int edgeWeight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = edgeWeight;
        adjMatrix[endIndex][startIndex] = edgeWeight;

        return true;
    }

    /**
     * Метод находит кратчайший путь с помощью поиска в ширину для взвешенного графа
     *
     * @param startLabel  начало пути
     * @param finishLabel точка назначения
     * @return стек с вершинами пути
     */
    @Override
    public Stack<String> findShortPathWithWeightEdge(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        } else if (finishIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + finishLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex baseVertex = vertexList.get(startIndex);
        baseVertex.setDistanceFromStart(0);
        queue.add(baseVertex);

        int currentIndex = startIndex;

        // обходим вершины от стартовой и находим для каждой минимальную дистанцию от старта, запоминаем
        // предшествующий узел для этого пути, отмечаем вершину как просмотренную, продолжаем пока не пройдем все
        // вершины кроме финишной для пути
        while (!queue.isEmpty()) {
            baseVertex = queue.peek();
            baseVertex.setVisited(true);
            currentIndex = indexOf(baseVertex.getLabel());
            int currentMinDistance = Integer.MAX_VALUE;
            for (int i = 0; i < getSize(); i++) {
                int vertexMinDistance = vertexList.get(i).getDistanceFromStart();
                int baseVertexMinDistance = baseVertex.getDistanceFromStart();
                int currentEdgeWeight = adjMatrix[currentIndex][i];
                if (currentEdgeWeight > 0 && !vertexList.get(i).isVisited()) {
                    if (!vertexList.get(i).getLabel().equals(finishLabel)) {
                        queue.add(vertexList.get(i));
                    }
                    if (baseVertexMinDistance + currentEdgeWeight < vertexMinDistance) {
                        if (baseVertexMinDistance + currentEdgeWeight < currentMinDistance) {
                            currentMinDistance = baseVertexMinDistance + currentEdgeWeight;
                        }
                        vertexList.get(i).setDistanceFromStart(baseVertexMinDistance + currentEdgeWeight);
                        vertexList.get(i).setPreviousVertex(baseVertex);
                    }
                }
            }
            queue.remove();
        }

        // создаем стек с кратчайшим путем, для этого проходим от конечного пункта до старта
        // через ссылку на предыдущий узел
        Stack<String> vertexStack = new Stack<>();
        Vertex vertex = vertexList.get(finishIndex);
        vertexStack.add(finishLabel);
        while (vertex.getPreviousVertex() != null) {
            vertex = vertex.getPreviousVertex();
            vertexStack.add(vertex.getLabel());
        }
        return vertexStack;
    }
}
