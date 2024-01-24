package src.com.mkp.v1.theory.Undirected;

import java.util.ArrayList;

public class UndirectedGraph {

    private int vertices;

    private ArrayList[] adjacency;

    public UndirectedGraph(int v) {
        this.vertices=v;
        this.adjacency=  new ArrayList[this.vertices];
        for (int i =0;i< adjacency.length;i++){
            adjacency[i]=new ArrayList<>();
        }
    }

    public void addEdge(Integer v,Integer w){
        adjacency[v].add(w);
        adjacency[w].add(v);
    }

    public ArrayList<Integer> adj(Integer v){
        return adjacency[v];
    }

    public int v(){
        return vertices;
    }

}
