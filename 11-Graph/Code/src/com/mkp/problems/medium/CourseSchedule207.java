package src.com.mkp.problems.medium;

import java.util.*;

public class CourseSchedule207 {

    public static void main(String[] args) {
//        int[][] pr = {{5,2},{5,0},{4,0},{4,1},{2,3},{3,1}};
//        int course=6;

        int[][] pr = {{0,1},{1,0}};
        int course=2;
//        System.out.println(canFinish(course,pr));
        System.out.println(canFinish2(course,pr));
    }
//   kahns algorithm BFS
    public static boolean canFinish(int numCourses, int[][] pr) {
        ArrayList<Integer>[] adj=new ArrayList[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        int[] indegree=new int[numCourses];
        ArrayList<Integer> prList=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj[i]=new ArrayList<>();
        }
        for (int i = 0; i < pr.length; i++) {
            adj[pr[i][0]].add(pr[i][1]);
            indegree[pr[i][1]]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int current=queue.poll();
            prList.add(current);
            for (Integer a: adj[current]) {
                if(--indegree[a] == 0) queue.add(a);
            }
        }
        return prList.size() == numCourses;
    }

    // DFS approach -not working
    public static boolean canFinish2(int numCourses, int[][] pr) {
        boolean[] visited=new boolean[numCourses];
        Stack<Integer> s=new Stack<>();
        ArrayList<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) adj[i]=new ArrayList();
        for(int i=0;i<pr.length;i++) adj[pr[i][0]].add(pr[i][1]);
        System.out.println(Arrays.toString(adj));
        for(int i=0;i<numCourses;i++) if(!visited[i]) dfs(i,adj,s,visited);
        System.out.println(s);
        return s.size()==numCourses;
    }

    private static void dfs(int v,ArrayList<Integer>[] adj,Stack<Integer> s,boolean[] visited){
        visited[v]=true;
        for(Integer a:adj[v])
            if(!visited[a]) dfs(a,adj,s,visited);
        s.push(v);
    }
}
