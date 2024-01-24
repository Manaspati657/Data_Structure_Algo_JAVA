package src.com.mkp.v1.theory.Undirected;

import java.util.*;

public class MainUniDirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Vertices:: ");
        Integer v = sc.nextInt();
        UndirectedGraph graph = new UndirectedGraph(v);
//        System.out.println("Give all connection vertices:: ");
        Integer[][] connection = new Integer[][]
                {
//                        {0, 5},{5, 3},
                        {9, 12},
                        {4, 3},{0, 1},{6, 4},{5, 4},{0, 2},{11, 12},{9, 10},
                        { 0, 6},{7, 8},{9, 11}}
//                {
//                {0,1},{0,2},{0,5},{0,6},{3,5},{3,4},
//                {4,6},{4,5},{7,8},{9,10},{9,11},{9,12},{11,12},
//        }
                ;

//        option 1: change the connection at run time
/*        for (int i = 0; i < v; i++) {
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
//        for (Integer integer : graph.adj(0)) {
//            System.out.println(integer);
//        }

//         dfs
//        DepthFirstSearch d = new DepthFirstSearch(graph);
//        System.out.println(d.dfsList(graph, 5));

//        no of different component in graph:
//        System.out.println(d.compCount(graph));

//          bfc
//        BreadthFirstSearch b = new BreadthFirstSearch(graph);
//        int[] predecessor=new int[graph.v()];
//        int[] distance=new int[graph.v()];
//        ArrayList<Integer> list=new ArrayList<>();
//        b.bfsList(graph, 0,list,predecessor,distance);
//        System.out.println("bfs : "+list);
//        System.out.println("predecessor : ");
//        for (int i = 0; i < predecessor.length; i++) {
//            System.out.println(predecessor[i]+" - "+i);
//        }

//        Connected component

        ConnectedComponent c=new ConnectedComponent(graph);
        System.out.println("No of Component : "+c.componentCount());
        System.out.println("is connected : "+c.isConnected(2,12));
        System.out.println("is connected : "+c.isConnected(1,6));
        System.out.println("Id is : "+c.componentId(8));
        System.out.println("Has cycle : "+c.isHasCycle());

    }
}
