package src.com.mkp.theory;

public class MainUF {
    public static void main(String[] args) {

        int size=10;
        int[][] connection = {
                {0, 5},{5, 6},{2, 1},{7, 2},
                {3, 8},{9, 4},{4, 3}
//
//                        ,{8, 9},
//                        {6, 1},{1, 0},
//                        {6, 7}
        };
//        Brute force approach - creation O(N) , union O(N), connected O(1);
        /*UnionFindBruteForce uf=new UnionFindBruteForce(size);
        for (int[] pair: connection) {
            int v=pair[0];
            int w=pair[1];
            if(!uf.isConnected(v,w)){
//                System.out.println(v+" - "+w);
                uf.union(v,w);
            }
        }
        System.out.println(uf.isConnected(1,5));
        System.out.println(uf.isConnected(3,6));
        uf.union(9,2);
        System.out.println(uf.isConnected(8,7));*/

//      Quick union also expensive because height of the tree will be increase so long
//        so creation O(N) , union O(N), connected O(N)
        /*UnionFind_QuickUnion uf=new UnionFind_QuickUnion(size);
        for (int[] pair: connection) {
            int v=pair[0];
            int w=pair[1];
            if(!uf.isConnected(v,w)){
//                System.out.println(v+" - "+w);
                uf.union(v,w);
            }
        }
        System.out.println(uf.isConnected(1,5));
        System.out.println(uf.isConnected(3,6));
        uf.union(9,2);
        System.out.println(uf.isConnected(8,7));*/
//        Weighted Quick union - height of the tree will not be increase because of rank comparison
//        so creation O(N) , union O(log n), connected O(log n)
        UnionFind uf=new UnionFind(10);
        for (int[] pair: connection) {
            int v=pair[0];
            int w=pair[1];
            if(!uf.isConnected(v,w)){
                System.out.println(v+" - "+w);
                uf.union(v,w);
            }
        }
        System.out.println(uf.isConnected(1,5));
        System.out.println(uf.isConnected(3,6));
        uf.union(9,2);
        System.out.println(uf.isConnected(8,7));
    }
}
