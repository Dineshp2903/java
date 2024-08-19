package Graph;

import java.util.*;

public class AdjList {
    
    List<Integer> adjList[];
    public AdjList(int v)
    {
        adjList = new LinkedList[v];
        for(int i = 0;i<v;i++)
        {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    private void addEdge(int u,int v)
    {
        adjList[u].add(v);
    }

    public void printAll()
    {
        int i = 0;
        for(List<Integer> list_ : adjList)
        {
            for(Integer l:list_)
            {
                System.out.println(i+"  "+ l);
            }
            i++;
        }
    }




    public static void main(String[] args) {
        int v = 4;
        AdjList adjList = new AdjList(v);
        adjList.addEdge(0, 1);
        adjList.addEdge(1, 2);
        adjList.addEdge(1,3 );
        adjList.addEdge(2, 3);
        adjList.printAll();

    }


}
