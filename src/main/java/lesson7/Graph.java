package lesson7;

import java.util.Stack;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    boolean addEdgeWithWeight(String startLabel, String endLabel, int edgeWeight);

    Stack<String> findShortPathViaBfs(String startLabel, String finishLabel);

    Stack<String> findShortPathViaBfs2(String startLabel, String finishLabel);

    void displayShortPath(Stack<String> vertexList, boolean withWeight);

    Stack<String> findShortPathWithWeightEdge(String startLabel, String finishLabel);
}
