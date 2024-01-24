package src.com.mkp.v1.theory.UnDirectedEWG;

import java.util.ArrayList;

public class EdgeWeightedGraph {

    private int vertices;

    private ArrayList<Edge>[] adjecency;

    private ArrayList<Edge> edgeslist=new ArrayList<>();

    public EdgeWeightedGraph(int size) {
        this.vertices=size;
        this.adjecency=new ArrayList[this.vertices];
        this.setAdjecency();
    }

    private void setAdjecency() {
        for (int i = 0; i < this.adjecency.length; i++) {
            this.adjecency[i]=new ArrayList<Edge>();
        }
    }

    public void addEdge(Edge e){
        int v = e.either(),w=e.other(v);
        this.edgeslist.add(e);
        adjecency[v].add(e);
        adjecency[w].add(e);
    }

    public Iterable<Edge> adjecency(int v){
        return adjecency[v];
    }

    public Iterable<Edge> edges(){
        return edgeslist;
    }
    public int V(){
        return vertices;
    }

}
