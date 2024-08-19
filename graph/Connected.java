package Graph;

public class Connected {
    

    private void findDfs(int[][] graph,boolean[] isVisited,int i)
    {
        isVisited[i] = true;
        for(int j = 0;j<graph.length;j++)
        {
            if(!isVisited[j] && graph[i][j] == 1)
            {
                findDfs(graph, isVisited, j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected)
    {
        int size = isConnected.length;
        boolean isVisited[] = new boolean[size];
        int no_of_connected = 0;
        for(int i = 0;i<size;i++)
        {
            if(!isVisited[i])
            {
                findDfs(isConnected,isVisited,i);
                no_of_connected++;
            }
        }
        return no_of_connected;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] { {1,1,0},{1,1,0},{0,0,1}};
        int size = graph.length;
        boolean isVisited[] = new boolean[size];
        int no_of_connected = 0;
        for(int i = 0;i<size;i++)
        {
            if(!isVisited[i])
            {
                findDfs(graph,isVisited,i);
                no_of_connected++;
            }
        }
        System.out.println(no_of_connected);
    }
}
