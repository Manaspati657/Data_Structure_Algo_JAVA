package src.com.mkp.theory.directed;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm_BFS_TopologicalSort {
    private int[] visited;

    public KahnsAlgorithm_BFS_TopologicalSort(DirectedGraph g) {
        visited=new int[g.V()];
        for (int i = 0; i < visited.length; i++) {
            for (Integer v: g.adjecency(i)) visited[v]++;
        }
//        System.out.println(Arrays.toString(visited));
    }

    public void sort(DirectedGraph g, ArrayList<Integer> list){
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) q.add(i);
        }
        for (int i : visited) {

        }
        while(!q.isEmpty()){
            int current=q.poll();
            list.add(current);
            for (Integer v:g.adjecency(current)) {
                if(--visited[v] == 0) q.add(v);
            }
        }
    }

}
