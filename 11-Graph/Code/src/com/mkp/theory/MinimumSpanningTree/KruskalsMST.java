package src.com.mkp.theory.MinimumSpanningTree;

import src.com.mkp.theory.UnionFind;

import java.util.*;

public class KruskalsMST {

    private Queue<Edge> mst=new LinkedList<>();

    private double totalWeight;

    private int[] vertices;
    private int[] ranks;

    public KruskalsMST(EdgeWeightedGraph graph) {
        this.vertices=new int[graph.V()];
        this.ranks=new int[graph.V()];
        this.computeMst(graph);
    }

    private void computeMst(EdgeWeightedGraph graph) {
//        Time Complexity: O(V)
        for (int i = 0; i < this.vertices.length; i++) {
            this.vertices[i]=i;
        }

        PriorityQueue<Edge> pq=new PriorityQueue<>();
//        Time Complexity: O(E logE)
        for (Edge e: graph.edges()) {
            pq.add(e);
        }
//        Time Complexity: O(V)
        while(!pq.isEmpty() && (mst.size() < graph.V()-1)){
//            Time Complexity: O(logE)
            Edge current=pq.poll();
            int v=current.either(),w=current.other(v);
//            Time Complexity: O(logV)
            if( root(v) != root(w)){
                union(v,w);
                mst.add(current);
                this.totalWeight+= current.weight();
            }
        }

    }

    private int root(int v){
        if(vertices[v] == v) return v;
        return root(vertices[v]);
    }

    private void union(int v , int w ){
        int vR=root(v),wR=root(w);

        if(vR == wR) return;

        if(ranks[vR] > ranks[wR]){
            vertices[wR]=vR;
        }else if(ranks[vR] < ranks[wR]){
            vertices[vR]=wR;
        }else{
            vertices[vR]=wR;
            ranks[wR]++;
        }

    }

    public Iterable<Edge> mst(){
        return mst;
    }
    public double weight(){
        return totalWeight;
    }
}
