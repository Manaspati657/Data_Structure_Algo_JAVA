package src.com.mkp.theory.DirectedEWG;

public class DirectedEdge implements Comparable<DirectedEdge> {

    private final int from,to;
    private final double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from(){
        return this.from;
    }

    public int to(){
        return this.to;
    }

    public double weight(){
        return this.weight;
    }

    @Override
    public int compareTo(DirectedEdge that) {
//        return Double.compare(this.weight,that.weight);
        if(this.weight > that.weight) return 1;
        else if(this.weight < that.weight) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return from()+" - "+to()+" -> w: "+weight();
    }
}
