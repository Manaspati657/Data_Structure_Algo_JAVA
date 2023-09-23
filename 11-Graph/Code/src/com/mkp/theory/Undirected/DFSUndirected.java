package src.com.mkp.theory.Undirected;

import java.util.ArrayList;

public class DFSUndirected {

    private boolean[] visited;


    public DFSUndirected(UndirectedGraph g) {
        visited=new boolean[g.v()];
//        dfs(g,0);
    }

    public ArrayList<Integer> dfsList(UndirectedGraph g, int v){
        ArrayList<Integer> list=new ArrayList<>();
        for (int w=v;w < visited.length;w++){
            if(!visited[w]){
                   dfs(g,w,list);
            }
        }
        if(v != 0){
            for (int w=0;w < v;w++){
                if(!visited[w]){
                    dfs(g,w,list);
                }
            }
        }

        visited=new boolean[g.v()];
        return list;
    }
    public void dfs(UndirectedGraph g, int v,ArrayList<Integer> list){
        visited[v]=true;
        list.add(v);
        for (Integer w: g.adj(v)){
            if(!visited[w]){
//                System.out.println(v+"--"+e);
                dfs(g,w,list);
            }
        }
    }

    private void dfs(UndirectedGraph g, int v){
        visited[v]=true;
        for (Integer w: g.adj(v)){
            if(!visited[w]){
//                System.out.println(v+"--"+e);
                dfs(g,w);
            }
        }
    }

    public int compCount(UndirectedGraph g) {
        int count = 0;
        for (int i=0;i < visited.length;i++){
            if(!visited[i]){
                count++;
                dfs(g,i);
            }
        }
        return count;
    }
}
