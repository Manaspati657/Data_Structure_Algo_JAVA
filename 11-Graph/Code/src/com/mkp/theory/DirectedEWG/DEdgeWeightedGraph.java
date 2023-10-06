package src.com.mkp.theory.DirectedEWG;

import java.util.ArrayList;

public class DEdgeWeightedGraph {

    private final int vertices;

    private ArrayList<DirectedEdge>[] adjecency;

    private ArrayList<DirectedEdge> edges=new ArrayList<>();

    public DEdgeWeightedGraph(int size) {
        this.vertices = size;
        this.adjecency=new ArrayList[this.vertices];
        this.setAdjecency();
    }

    private void setAdjecency() {
        for (int i = 0; i < this.vertices; i++) {
            this.adjecency[i]=new ArrayList<DirectedEdge>();
        }
    }

    public void addEdge(DirectedEdge e){
        int v=e.from();
        adjecency[v].add(e);
        edges.add(e);
    }

    public int V(){
        return this.vertices;
    }

    public Iterable<DirectedEdge> adjecency(int v){
        return adjecency[v];
    }

    public Iterable<DirectedEdge> edges(){
        return edges;
    }



}
