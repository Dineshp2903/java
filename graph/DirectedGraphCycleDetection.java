package Graph;
import java.util.*;

public class DirectedGraphCycleDetection {
    private final List<Integer>[] adjList;
    private final boolean[] isVisited;
    private final boolean[] recStack;

    @SuppressWarnings("unchecked")
    public DirectedGraphCycleDetection(int vertices) {
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
        isVisited = new boolean[vertices];
        recStack = new boolean[vertices];
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public boolean hasCycle() {
        for (int i = 0; i < adjList.length; i++) {
            if (!isVisited[i]) {
                if (hasCycleUtil(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int v) {
        if (recStack[v]) {
            return true;
        }
        if (isVisited[v]) {
            return false;
        }
        isVisited[v] = true;
        recStack[v] = true;

        for (Integer neighbor : adjList[v]) {
            if (hasCycleUtil(neighbor)) {
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }

    public static void main(String[] args) {
        DirectedGraphCycleDetection g = new DirectedGraphCycleDetection(6);
        //Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.println("Graph has cycle: " + g.hasCycle());
    }
}
