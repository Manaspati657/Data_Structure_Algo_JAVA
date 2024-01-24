package src.com.mkp.v1.theory.Undirected;

public class ConnectedComponent {

    private boolean[] marked;
    private int[] comp;
    private int count;

    private boolean hasCycle;

    public ConnectedComponent(UndirectedGraph g) {
        marked=new boolean[g.v()];
        comp=new int[g.v()];
        for (int i = 0; i < marked.length; i++) {
            if(!marked[i]){
                dfs(g,i,i);
                count++;
            }
        }
    }

    private void dfs(UndirectedGraph g,int v,int parent) {
        marked[v]= true;
        comp[v]=count;
        for (Integer w : g.adj(v)){
            if(!marked[w]){
                dfs(g,w,v);
            }else if( w != parent){
                hasCycle=true;
            }
        }
    }

    public boolean isConnected(int v,int w){
        return comp[v] == comp[w];
    }

    public int componentCount(){
        return count;
    }

    public int componentId(int v){
        return comp[v];
    }

    public boolean isHasCycle(){
        return hasCycle;
    }

}
