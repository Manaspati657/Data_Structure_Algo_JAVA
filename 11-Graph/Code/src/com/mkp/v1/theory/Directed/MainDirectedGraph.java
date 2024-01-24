package src.com.mkp.v1.theory.Directed;

import java.util.ArrayList;
import java.util.Scanner;

public class MainDirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Vertices:: ");
        int v = sc.nextInt();
        DirectedGraph graph = new DirectedGraph(v);
//        System.out.println("Give all connection vertices:: ");
        Integer[][] connection = new Integer[][]
                {
//                       these edges include cycle and one or more component
                        /*{0, 1},{0, 5},
                        {2, 0},{2, 3},
                        {3, 5},{3, 2},
                        {4, 3},{4, 2},{5, 4},
                        {6, 9},{6, 4},{6, 8},{6, 0},
                        {7, 6},{7, 9},
                        {8, 6},
                        {9, 11},{9, 10},{10, 12},
                        {11, 4},{11, 2},{12, 9},*/
//                        these edges don't have any cycle , used for topological sorting
                        /*{0, 2},{0, 5},{0,1},{1,4},
                        {3, 5},{3, 2},{3, 6},{3, 4},
                        {5, 2},
                        {6, 4},{6, 0},*/
//                        these edges don't have any cycle , used for topological sorting
                        {2, 3},{3, 1},{4, 0},{4, 1},
                        {5, 2},{5, 0},
                }
                ;

//        option 1: change the connection at run time
          /*for (int i = 0; i < v; i++) {
            System.out.println("Enter vertices no 1:: ");
            Integer v1=sc.nextInt();
            System.out.println("Enter vertices no 2:: ");
            Integer v2=sc.nextInt();
            System.out.println(v1+" connect with "+v2);
            graph.addEdge(v1,v2);
            }*/

//        option 2 : use the 2-d array connection
        for (Integer[] arr : connection) {
//            System.out.println(arr[0]+" connect with "+arr[1]);
            graph.addEdge(arr[0], arr[1]);
        }
//        print all edges of a vertices
       /* for (Integer n : graph.adjecency(6)) {
            System.out.print(n+" -> ");
        }*/
//        DFS
      /*  DFSDirected d=new DFSDirected(graph);
        ArrayList<Integer> list =new ArrayList<>();
        d.dfs(graph,list,8);
        System.out.println(list);
        System.out.println("is connected : "+d.isConnected(6));*/

//        Connected path
        /*ConnectedComponent c=new ConnectedComponent(graph);
        System.out.println("No of Component : "+c.noOfComponent());
        System.out.println("is connected : "+c.isConnected(2,12));
        System.out.println("is connected : "+c.isConnected(1,5));
        System.out.println("Has cycle : "+c.isHasCycle());*/

//      Topological Sort DFS
        /* Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
        such that for every directed edge u v, vertex u comes before v in the ordering.*/
        /*TopologicalSortDFS t=new TopologicalSortDFS(graph);
        ArrayList<Integer> list=new ArrayList<>();
        t.sort(graph,list);
        System.out.println(list);*/

//      Topological Sort BFS (Kahn’s algorithm)
        KahnsAlgorithm_BFS_TopologicalSort k=new KahnsAlgorithm_BFS_TopologicalSort(graph);
        ArrayList<Integer> list=new ArrayList<>();
        k.sort(graph,list);
        System.out.println(list);


    }
}
