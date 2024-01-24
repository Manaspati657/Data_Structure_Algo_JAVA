package src.com.mkp.v1.theory.DirectedEWG;

public class BellmanFord {
    private double[] spt;

    private int vertices;

    public BellmanFord(DEdgeWeightedGraph graph) {
        this.vertices= graph.V();
        spt=new double[this.vertices];
        spt[0]=0;
        for (int i = 1; i < this.vertices; i++) {
            spt[i]=Double.POSITIVE_INFINITY;
        }
        this.computeSPT(graph);
    }

    private void computeSPT(DEdgeWeightedGraph graph) {
        for (int i = 0; i < graph.V() ; i++) {
            for (int j = 0; j < graph.V(); j++) {
                for (DirectedEdge e: graph.adjecency(j)){
                    int to =e.to(),from=e.from();
                    if(spt[to] > spt[from]+e.weight()){
                        spt[to] = spt[from]+e.weight();
                    }
                }
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
