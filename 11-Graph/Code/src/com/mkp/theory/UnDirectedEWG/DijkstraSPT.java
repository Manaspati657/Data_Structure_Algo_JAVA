package src.com.mkp.theory.UnDirectedEWG;

import java.util.PriorityQueue;

public class DijkstraSPT {

//    visited vertices
//    Space complexity: O(V)
    private boolean[] visited;

//    list of edges for getting min edge every time
    //    Space complexity: O(E)
    private PriorityQueue<Edge> edgesList=new PriorityQueue<>();

//    for store Shortest path
    //    Space complexity: O(E)
    private double[] spt;

    private int vertices;

    public DijkstraSPT(EdgeWeightedGraph graph) {
        this.vertices=graph.V();
        this.visited=new boolean[this.vertices];
        this.spt=new double[this.vertices];
        this.spt[0]=0;
        //        Time complexity: O(V)
        for (int i = 1; i < this.vertices; i++) {
            this.spt[i]=Double.POSITIVE_INFINITY;
        }
        this.computeSPT(graph);
    }

    private void computeSPT(EdgeWeightedGraph graph) {
        this.visit(graph,0);
//        Time complexity: O(E)
        while(!edgesList.isEmpty()){
            //        Time complexity: O(log E)
            Edge smallestEdge=edgesList.remove();
            int v=smallestEdge.either(),w=smallestEdge.other(v);
            int nextItem=v,prevItem=w;
            if(visited[v]){
                nextItem=w; prevItem=v;
            }
            if(spt[nextItem] > spt[prevItem]+smallestEdge.weight()){
                spt[nextItem] = spt[prevItem]+smallestEdge.weight();
                if(!visited[nextItem]) visit(graph,nextItem);
            }
        }

//        System.out.println(Arrays.toString(spt));

    }

    private void visit(EdgeWeightedGraph graph, int v) {
        this.visited[v]=true;
        //        Time complexity: O(E logE)
        for (Edge e:graph.adjecency(v)){
            int w=e.other(v);
            if(!visited[w]){
                edgesList.add(e);
            }
        }
    }

    public void display() {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < this.vertices; i++)
            System.out.println(i + " \t\t\t\t " + (int)spt[i]);
    }
}
