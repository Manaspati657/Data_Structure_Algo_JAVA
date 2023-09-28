package src.com.mkp.theory;

import java.util.Arrays;

public class UnionFind {

    private int[] numbers;
    private int[] rank;

    public UnionFind(int size) {
        this.numbers=new int[size];
        this.rank=new int[size];
        for (int i = 0; i < numbers.length; i++) {
            this.numbers[i]=i;
        }
    }

    private int root(int v ){
        if(v == numbers[v]) return v;
        return root(numbers[v]);
    }

    public boolean isConnected(int v ,int w){
        return root(v) == root(w);
    }

    public void union(int v ,int w ){
        int vR=root(v),wR=root(w);
        if(vR == wR) return;
        if(rank[vR] > rank[wR]){
            numbers[wR]=vR;
        }else if(rank[vR] < rank[wR]){
            numbers[vR]=wR;
        }else{
            numbers[wR]=vR;
            rank[vR]++;
        }
    }

}
