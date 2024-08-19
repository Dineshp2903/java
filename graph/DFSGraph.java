package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFSGraph {

    List<Integer> graph[];
    int nodes =0;

    public DFSGraph(int v)
    {
        graph = new LinkedList[v];
        nodes = v;
        for(int i = 0;i<v;i++)
        {
            graph[i] = new LinkedList<Integer>();
        }
    }

    private void addEdge(int u,int v)
    {
        graph[u].add(v);
    }

    private void bfs(int start)
    {
        Stack<Integer> qu = new Stack<>();
        boolean isVisited[] = new boolean[nodes];
        qu.push(start);
        isVisited[start] = true;
        
        while(!qu.isEmpty())
        {
            Integer parent = qu.pop();
            List<Integer> pa = graph[parent];
            System.out.println(parent);
            for(Integer i : pa)
            {
                if(!isVisited[i])
                {
                    isVisited[i] = true;
                    qu.add(i);
                }
            }


           
            
        }
    }    

    public static void main(String[] args) {
        int v = 4;
        DFSGraph adjList = new DFSGraph(v);
        adjList.addEdge(0, 1);
        adjList.addEdge(1, 2);
        adjList.addEdge(1,3 );
        adjList.addEdge(2, 3);
        adjList.bfs(0);

    }
}
