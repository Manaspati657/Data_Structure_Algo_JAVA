package src.com.mkp.theory.DirectedEWG;

import java.util.PriorityQueue;

public class DijkstraDirected {

    private boolean[] visited;

    private PriorityQueue<DirectedEdge> edgeList=new PriorityQueue<>();

    private double[] spt;

    private int vertices;

    public DijkstraDirected(DEdgeWeightedGraph graph) {
        this.vertices= graph.V();
        visited=new boolean[this.vertices];
        spt=new double[this.vertices];
        spt[0]=0;
        for (int i = 1; i < this.vertices; i++) {
            spt[i]=Double.POSITIVE_INFINITY;
        }
        this.computeSPT(graph);
    }

    private void computeSPT(DEdgeWeightedGraph graph) {
        this.visit(graph,0);

        while(!edgeList.isEmpty()){
            DirectedEdge smallestEdge=edgeList.remove();
            int from =smallestEdge.from(),to=smallestEdge.to();
            System.out.println(smallestEdge+" spt : "+spt[to]);
            if(spt[to] > spt[from]+smallestEdge.weight()){
                spt[to]=spt[from]+smallestEdge.weight();
                if(!visited[to]) visit(graph,to);
            }
        }

    }

    private void visit(DEdgeWeightedGraph graph,int v) {
        this.visited[v]=true;
        for (DirectedEdge e: graph.adjecency(v)){
            int to=e.to();
            if(!visited[to]) edgeList.add(e);
        }
    }

    public void display() {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < this.vertices; i++)
            System.out.println(i + " \t\t\t\t " + (int)spt[i]);
    }
}
