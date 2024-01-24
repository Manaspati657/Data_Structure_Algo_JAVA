package src.com.mkp.v1.theory.UnDirectedEWG;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsMST {

//    Space complexity: O(V)
    private boolean[] visited;

    private Queue<Edge> mst=new LinkedList<>();

//    Space complexity: O(E)
    private PriorityQueue<Edge> pq=new PriorityQueue<>();

    private double totalWeight;

    public PrimsMST(EdgeWeightedGraph graph) {
        this.visited=new boolean[graph.V()];
        this.computeMST(graph);
    }

    private void computeMST(EdgeWeightedGraph graph) {
        visit(graph,0);
//        Time complexity: O(V)
        while(!pq.isEmpty() && (mst.size() < graph.V()-1)){
//          Time complexity: O(log E)
            Edge current=pq.remove();
            int v=current.either(),w=current.other(v);
            if(visited[v] && visited[w]) continue;
            mst.add(current);
            this.totalWeight+=current.weight();
            if(!visited[v]) visit(graph,v);
            if(!visited[w]) visit(graph,w);
        }
    }

//    Time complexity: O(E log E (log E for pq add operation))
    private void visit(EdgeWeightedGraph graph, int v){
        visited[v]=true;
        for (Edge w :graph.adjecency(v))
            if(!visited[w.other(v)])
                pq.add(w);
    }

    public Iterable<Edge> mst(){ return mst; }

    public double weight(){return totalWeight;}
}
