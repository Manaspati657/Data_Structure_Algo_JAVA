package src.com.mkp.problems.easy;

public class FindIfPathExistsInGraph1971 {

    public static void main(String[] args) {
//        int[][] edge = {{0,1},{1,2},{2,0}};
//        int n=3,s=0,d=2;
        int[][] edge = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int n=6,s=0,d=5;
        System.out.println(validPath(n,edge,s,d));
    }

    private static int connSet[];

    private static int findParent(int v){
        if(connSet[v] == v) return v;
        return findParent(connSet[v]);
    }

    private static void connect(int v,int w){
        int pv=findParent(v),pw=findParent(w);
        connSet[pv]=pw;
    }

//    Disjoint set solution
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        connSet=new int[n];
        for (int i = 0; i < n; i++) {
            connSet[i]=i;
        }

        for (int i = 0; i < edges.length; i++) {
            connect(edges[i][0],edges[i][1]);
        }
        return findParent(source) == findParent(destination);
    }


}
