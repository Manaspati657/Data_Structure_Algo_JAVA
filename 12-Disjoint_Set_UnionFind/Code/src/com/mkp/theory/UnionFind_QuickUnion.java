package src.com.mkp.theory;

import java.util.Arrays;

public class UnionFind_QuickUnion {

    private int[] ids;

    public UnionFind_QuickUnion(int size) {
        this.ids=new int[size];
        for (int i = 0; i < ids.length; i++) {
            ids[i]=i;
        }
    }

    private int root(int v){
        while (ids[v] != v) v=ids[v];
        return v;
    }

    public boolean isConnected(int v,int w){
        return root(v) == root(w);
    }

    public void union(int v,int w){
        int vR=root(v);
        int wR=root(w);
        ids[vR]=wR;
        System.out.println(Arrays.toString(ids));
    }

}
