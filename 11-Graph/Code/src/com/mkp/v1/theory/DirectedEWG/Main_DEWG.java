package src.com.mkp.v1.theory.DirectedEWG;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_DEWG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Vertices:: ");
        int v = sc.nextInt();
        DEdgeWeightedGraph graph = new DEdgeWeightedGraph(v);
//        System.out.println("Give all connection vertices:: ");
        ArrayList<DirectedEdge> listConn=new ArrayList<>();
//        for finding SPT
        listConn.add(new DirectedEdge(0,1,5));
        listConn.add(new DirectedEdge(0,4,9));
        listConn.add(new DirectedEdge(0,7,8));
        listConn.add(new DirectedEdge(1,2,12));
        listConn.add(new DirectedEdge(1,3,15));
        listConn.add(new DirectedEdge(1,7,4));
        listConn.add(new DirectedEdge(2,3,3));
        listConn.add(new DirectedEdge(2,6,11));
        listConn.add(new DirectedEdge(3,6,9));
        listConn.add(new DirectedEdge(4,5,4));
        listConn.add(new DirectedEdge(4,6,20));
        listConn.add(new DirectedEdge(4,7,5));
        listConn.add(new DirectedEdge(5,2,1));
        listConn.add(new DirectedEdge(5,6,13));
        listConn.add(new DirectedEdge(7,5,6));
        listConn.add(new DirectedEdge(7,2,7));


//        option 1: change the connection at run time
        /*for (int i = 0; i < v; i++) {
            System.out.println("Enter vertices no 1:: ");
            int v1=sc.nextInt();
            System.out.println("Enter vertices no 2:: ");
            int v2=sc.nextInt();
            System.out.println("Enter edge weight:: ");
            double weight=sc.nextDouble();
            System.out.println(v1+" connect with "+v2);
            graph.addDirectedEdge(new DirectedEdge(v1,v2,weight));
        }*/

//        option 2 : use the 2-d array connection
        for (DirectedEdge e : listConn) {
            System.out.println(e);
            graph.addEdge(e);
        }


//        Dijkstra Algorithm for directed graph (give wrong ans bcz of index priority queue.)
        /*
        *   Time complexity :
        *   Space complexity:
        * */
     /*   DijkstraDirected dd=new DijkstraDirected(graph);
        dd.display();*/

//        Bellman Ford algorithm give write ans but Time complexity is O(VE);

        BellmanFord bf=new BellmanFord(graph);
        bf.display();

    }
}












