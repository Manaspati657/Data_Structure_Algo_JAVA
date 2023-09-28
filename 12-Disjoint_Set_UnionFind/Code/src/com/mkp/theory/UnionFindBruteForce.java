package src.com.mkp.theory;

import java.util.Arrays;

public class UnionFindBruteForce {

    private int[] ids;

    public UnionFindBruteForce(int size) {
        ids=new int[size];
        for (int i = 0; i < ids.length; i++) {
            ids[i]=i;
        }
    }

    public boolean isConnected(int p,int q){
        return ids[p]==ids[q];
    }

    public void union(int p,int q){
        if(isConnected(p,q)) return;
        int pId=ids[p];
        int qId=ids[q];
        for (int i = 0; i < ids.length; i++) {
            if(ids[i] == qId){
                ids[i]=pId;
            }
        }
        System.out.println(Arrays.toString(ids));
    }


}
