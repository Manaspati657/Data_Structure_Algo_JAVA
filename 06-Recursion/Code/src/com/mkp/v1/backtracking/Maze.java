package src.com.mkp.v1.backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(countPath(3, 3));
//        path("", 3, 3);
//        System.out.println(pathRet("", 3, 3));

//        System.out.println(pathRetDiagonal("", 3, 3));

        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        System.out.println(pathRestrictions("", board, 0, 0));;
    }

    private static ArrayList<String> pathRestrictions(String in, boolean[][] board, int r, int c) {
        if(r == 2 && c==2){
//            System.out.println(in);
            ArrayList<String> list=new ArrayList<>();
            list.add(in);
            return list;
        }
        if(!board[r][c]) return new ArrayList<>();
        ArrayList<String> list=new ArrayList<>();
////        if( c > 1 && r > 1 ) list.addAll(pathRestrictions(in+'D',r-1,c-1));
        if( c < 2 ) list.addAll(pathRestrictions(in+'H',board,r,c+1));
        if( r < 2 ) list.addAll(pathRestrictions(in+'V',board,r+1,c));
        return list;
    }

    private static ArrayList<String> pathRetDiagonal(String in, int r, int c) {
        if(r == 1 && c==1){
//            System.out.println(in);
            ArrayList<String> list=new ArrayList<>();
            list.add(in);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if( c > 1 && r > 1 ) list.addAll(pathRetDiagonal(in+'D',r-1,c-1));
        if( c > 1 ) list.addAll(pathRetDiagonal(in+'H',r,c-1));
        if( r > 1 ) list.addAll(pathRetDiagonal(in+'V',r-1,c));
        return list;
    }

    private static ArrayList<String> pathRet(String in, int r, int c) {
        if(r == 1 && c==1){
//            System.out.println(in);
            ArrayList<String> list=new ArrayList<>();
            list.add(in);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if( c > 1 ) list.addAll(pathRet(in+'R',r,c-1));
        if( r > 1 ) list.addAll(pathRet(in+'D',r-1,c));
        return list;
    }

    private static int countPath(int r, int c) {
        if (r == 1 && c == 1) {
            return 1;
        }
        int left=0,right=0;
        if( c > 1 ) left  = countPath(r, c-1);
        if( r > 1 ) right = countPath(r-1, c);
        return left + right;
        /*
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return left + right;
        */
    }

    private static void path(String in, int r, int c) {
        if(r == 1 && c==1){
            System.out.println(in);
            return;
        }
        if( c > 1 ) path(in+'R',r,c-1);
        if( r > 1 ) path(in+'D',r-1,c);
    }
}
