package src.com.mkp.theory.directed;

import java.util.ArrayList;
import java.util.Iterator;

public class DirectedGraph {
    
    private ArrayList<Integer>[] adjecency;

    private int vertices;
    
    DirectedGraph(int v){
        vertices=v;
        adjecency=new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjecency[i]=new ArrayList<>();
        }
    }

    public void addEdge(int v,int w){
        adjecency[v].add(w);
    }

    public ArrayList<Integer> adjecency(int v) {
        return adjecency[v];
    }

    public int V(){
        return vertices;
    }
}
