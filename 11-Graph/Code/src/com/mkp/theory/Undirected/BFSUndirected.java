package src.com.mkp.theory.Undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSUndirected {
    private boolean[] visited;

    public BFSUndirected(UndirectedGraph g) {
        visited=new boolean[g.v()];
//        bfs(g,0);
    }

    public void bfsList(UndirectedGraph g, int v,ArrayList<Integer> list,int[] pred,int[] dist) {
        for (int i = v; i < visited.length; i++) {
            if(!visited[i]) bfs(g,i,list,pred,dist);
        }
        if(v!=0){
            for (int i = 0; i < v; i++) {
                if(!visited[i]) bfs(g,i,list,pred,dist);
            }
        }
    }

    private void bfs(UndirectedGraph g, int v, ArrayList<Integer> list,int[] pred,int[] dist) {
        Queue<Integer> q=new LinkedList<>();
        q.add(v);
        visited[v]=true;
        pred[v]=v;
        while(!q.isEmpty()){
            Integer current= q.poll();
            list.add(current);
            for(Integer w : g.adj(current)){
                if(!visited[w]){
                    visited[w]=true;
                    pred[w]=current;
                    q.add(w);
                }
            }

        }
    }


}
