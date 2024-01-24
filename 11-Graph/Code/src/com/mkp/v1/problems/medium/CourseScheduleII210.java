package src.com.mkp.v1.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII210 {

    public static void main(String[] args) {
//        [[1,0],[2,0],[3,1],[3,2]]
                int[][] pr = {{5,2},{5,0},{4,0},{4,1},{2,3},{3,1}};
        int course=6;
//        int[][] pr = {{1,0},{2,0},{3,1},{3,2}};
//        int course=4;

//        int[][] pr = {{0,1},{1,0}};
//        int course=2;
        System.out.println(Arrays.toString(findOrder(course, pr)));
    }

//    BFS approach kahns algorithm
    public static int[] findOrder(int numCourses, int[][] pr) {
        int[] ans=new int[0];
        ArrayList<Integer> ansList=new ArrayList<>();
//       we create a graph adjacency list
        ArrayList<Integer>[] adj=new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i]=new ArrayList<>();
        }
//        take a in-degree array
        int[] in_degree=new int[numCourses];
        for (int i = 0; i < pr.length; i++) {
            adj[pr[i][1]].add(pr[i][0]);
            in_degree[pr[i][0]]++;
        }
//        take a Queue for storing 0 in-degree vertices and decrease all adj by 1
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < in_degree.length; i++) {
            if(in_degree[i] == 0) q.add(i);
        }
//      start from 0 in-degree vertices
        while(!q.isEmpty()){
            int current=q.poll();
            ansList.add(current);
            for (Integer v:adj[current]){
                if(--in_degree[v] == 0){
                    q.add(v);
                }
            }
        }
        if(ansList.size() == numCourses){
            ans=new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i]=ansList.get(i);
            }
        }
        return ans;
    }
}
