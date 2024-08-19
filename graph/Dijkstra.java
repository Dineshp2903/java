package Graph;
import java.util.Arrays;

public class Dijkstra {

    // Method to find the shortest path using Dijkstra's algorithm
    public static int[] dijkstra(int[][] graph, int start) {
        int V = graph.length;
        int[] dist = new int[V];  // Array to store the shortest distance from start to each vertex
        boolean[] visited = new boolean[V];  // Array to keep track of visited vertices

        // Initialize distances with infinity and start vertex distance with 0
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < V - 1; i++) {
            // Find the vertex with the minimum distance that has not been visited
            int u = minDistance(dist, visited);

            // Mark the chosen vertex as visited
            visited[u] = true;

            // Update the distance value of the neighboring vertices of the chosen vertex
            for (int v = 0; v < V; v++) {
                // Update dist[v] if and only if it is not in the visited set, there is an edge from u to v,
                // and the total weight of path from start to v through u is less than the current value of dist[v]
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE 
                    && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return dist;
    }

    // Utility method to find the vertex with the minimum distance value from the set of vertices not yet processed
    private static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Example usage
    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 0, 30, 100},
            {10, 0, 50, 0, 0},
            {0, 50, 0, 20, 10},
            {30, 0, 20, 0, 60},
            {100, 0, 10, 60, 0}
        };

        int start = 0;
        int[] distances = dijkstra(graph, start);
        
        System.out.println("Shortest distances from vertex " + start + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + " : " + (distances[i] == Integer.MAX_VALUE ? "Infinity" : distances[i]));
        }
    }
}
