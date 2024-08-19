package Graph;

import java.util.LinkedList;

public class Cycle {
    LinkedList<Integer>[] graph;
    public Cycle(int V)
    {
        graph = new LinkedList[V];
        for(int i = 0;i<V;i++)
        {
            graph[i] = new LinkedList<>();
        }
    }
    public void addEdge(int u,int v)
    {
        graph[u].add(v);
    }
    public boolean hasCycle(int i,boolean[] isVisited,boolean[] recStack)
    {
        if(isVisited[i])
        {
            return false;
        }
        if(recStack[i])
        {
            return true;
        }
        isVisited[i] = true;
        recStack[i] = true;
        for(int neighbor:graph[i])
        {
            if(hasCycle(neighbor, isVisited, recStack)){
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }
    public boolean findCycle(int V)
    {
        boolean[] isVisited = new boolean[V];
        boolean[] parent = new boolean[V];
        for(int i =0;i<V;i++)
        {
            if(!isVisited[i] && hasCycle(i, isVisited, parent))
            {
                return true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Cycle g = new Cycle(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        System.out.println(g.findCycle(6));
    }
}
