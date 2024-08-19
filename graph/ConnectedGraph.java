package Graph;

import java.util.LinkedList;

public class ConnectedGraph {
    private LinkedList<Integer>[] graph;
    private int V;

    public ConnectedGraph(int v)
    {
        V=v;
        graph = new LinkedList[V];
        for(int i = 0;i<V;i++)
        {
            graph[i] = new LinkedList<>();
        }
    }
    private void addEdge(int u,int v)
    {
        graph[u].add(v);
        graph[v].add(u);
    }

    private void findConnected(int ele,boolean[] isVisited)
    {
        isVisited[ele] = true;
        System.out.print(ele+" ");
        //LinkedList<Integer> elem = graph[ele];
        for(int i : graph[ele])
        {
            if(!isVisited[i])
            {
                findConnected(i, isVisited);
            }
        }
    }

    private void connected()
    {
        boolean[] isVisited = new boolean[V];
        for(int i = 0;i<V;i++)
        {
            if(!isVisited[i])
            {
                findConnected(i,isVisited);
                System.out.println();
            }
        }

    }
    public static void main(String[] args)
    {
        ConnectedGraph graph = new ConnectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(3, 4);
        graph.connected();

    }
}
