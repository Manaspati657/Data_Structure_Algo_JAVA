package src.com.mkp.v1.theory.UnDirectedEWG;

public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertix){
        if(vertix== v) return w;
        return v;
    }

    public double weight(){
        return this.weight;
    }

    @Override
    public int compareTo(Edge that) {
        if      (this.weight > that.weight) return  1;
        else if (this.weight < that.weight) return -1;
        else                                return  0;
    }

    @Override
    public String toString() {
        return  v +"-" + w +" "+ weight ;
    }
}
