package src.com.mkp.theory.Directed;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {

    private boolean[] visited;

    public TopologicalSortDFS(DirectedGraph g) {
        visited=new boolean[g.V()];
    }

    public void sort(DirectedGraph g , ArrayList<Integer> list){
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                dfs(g,stack,i);
            }
        }
        while (!stack.isEmpty()) list.add(stack.pop());
    }

    private void dfs(DirectedGraph g, Stack<Integer> list, int v) {

        visited[v]=true;
        for (Integer w: g.adjecency(v)){
            if(!visited[w]) dfs(g,list,w);
        }
        list.push(v);
    }
}
