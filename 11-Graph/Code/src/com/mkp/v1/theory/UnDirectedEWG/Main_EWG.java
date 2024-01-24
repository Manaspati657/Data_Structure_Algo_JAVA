package src.com.mkp.v1.theory.UnDirectedEWG;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_EWG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Vertices:: ");
        int v = sc.nextInt();
        EdgeWeightedGraph graph = new EdgeWeightedGraph(v);
//        System.out.println("Give all connection vertices:: ");
        ArrayList<Edge> listConn=new ArrayList<>();
//        for finding MST
        /*listConn.add(new Edge(1,3,0.29));
        listConn.add(new Edge(1,5,0.32));
        listConn.add(new Edge(2,7,0.34));
        listConn.add(new Edge(4,5,0.35));
        listConn.add(new Edge(1,2,0.36));
        listConn.add(new Edge(4,7,0.37));
        listConn.add(new Edge(0,4,0.38));
        listConn.add(new Edge(6,2,0.40));
        listConn.add(new Edge(0,7,0.16));
        listConn.add(new Edge(2,3,0.17));
        listConn.add(new Edge(1,7,0.19));
        listConn.add(new Edge(0,2,0.26));
        listConn.add(new Edge(5,7,0.28));
        listConn.add(new Edge(3,6,0.52));
        listConn.add(new Edge(6,0,0.58));
        listConn.add(new Edge(6,4,0.93));*/
//        for finding SPT
        /*listConn.add(new Edge(0,3,2));
        listConn.add(new Edge(0,4,3));
        listConn.add(new Edge(3,5,6));
        listConn.add(new Edge(3,2,4));
        listConn.add(new Edge(4,2,5));
        listConn.add(new Edge(2,1,2));
        listConn.add(new Edge(1,5,1));*/
//        for finding SPT
        listConn.add(new Edge(0,1,2));
        listConn.add(new Edge(0,2,6));
        listConn.add(new Edge(1,3,5));
        listConn.add(new Edge(2,3,8));
        listConn.add(new Edge(3,5,15));
        listConn.add(new Edge(3,4,10));
        listConn.add(new Edge(5,4,6));
        listConn.add(new Edge(5,6,6));
        listConn.add(new Edge(4,6,2));


//        option 1: change the connection at run time
        /*for (int i = 0; i < v; i++) {
            System.out.println("Enter vertices no 1:: ");
            int v1=sc.nextInt();
            System.out.println("Enter vertices no 2:: ");
            int v2=sc.nextInt();
            System.out.println("Enter edge weight:: ");
            double weight=sc.nextDouble();
            System.out.println(v1+" connect with "+v2);
            graph.addEdge(new Edge(v1,v2,weight));
        }*/

//        option 2 : use the 2-d array connection
        for (Edge e : listConn) {
//            System.out.println(e);
            graph.addEdge(e);
        }

//        Kruskal's Algorithm : Minimum Spanning Tree
        /*
        Time complexity - O (V + E logE + V log E +V log V) --> O(E log E)
        Space complexity - O (V + V+ E) --> O(2V + E) --> O(V+E)
        */
         /* KruskalsMST mst=new KruskalsMST(graph);
         Iterable<Edge> ans=mst.mst();
         ans.forEach(System.out::println);
         System.out.println(mst.weight()); */

//         Prim's Algorithm : Minimum Spanning Tree
        /*
        Time complexity - O (E logE + V log E ) --> O(E log E)
        Space complexity - O (V + E) --> O(V + E)
        */
        /*PrimsMST mst=new PrimsMST(graph);
        Iterable<Edge> ans=mst.mst();
        ans.forEach(System.out::println);
        System.out.println(mst.weight());*/

//        Dijkstra Algorithm : Shortest Path Tree
        /*
        Time complexity - O( V+ E logE +E logE) --> O(E logE)
        Space complexity - O( V+ E +E ) -->  O(V+E)
        */
        DijkstraSPT spt=new DijkstraSPT(graph);
        spt.display();
    }
}
