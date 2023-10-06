package src.com.mkp.theory.Directed;

public class ConnectedComponent {

    private boolean[] visited;
    private int[] compIdentifier;

    private int connCount;

    private boolean hasCycle;

    ConnectedComponent(DirectedGraph g){
        visited=new boolean[g.V()];
        compIdentifier=new int[g.V()];
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                connCount++;
                dfs(g,i);
            }
        }
    }

    private void dfs(DirectedGraph g, int v) {
        visited[v]=true;
        compIdentifier[v]=connCount;
        for (Integer w:g.adjecency(v)) {
            if (!visited[w]) dfs(g, w);
            else if (compIdentifier[v] == compIdentifier[w]) hasCycle = true;
        }
    }

    public int noOfComponent(){
        return connCount;
    }

    public boolean isConnected(int v,int w){
        return compIdentifier[v] == compIdentifier[w];
    }

    public boolean isHasCycle(){
        return hasCycle;
    }

}




















