package src.com.mkp.theory.directed;

import java.util.ArrayList;

public class DFSDirected {
    private ArrayList<Integer> connectedList;
    private boolean[] visited;
    DFSDirected(DirectedGraph g){
        visited=new boolean[g.V()];
    }

    public void dfs(DirectedGraph g,ArrayList<Integer> list,int v){
        visited[v]=true;
        list.add(v);
        for (Integer w : g.adjecency(v)){
            if(!visited[w]) dfs(g,list,w);
        }
    }

    public boolean isConnected(int v){
        return visited[v];
    }

}
