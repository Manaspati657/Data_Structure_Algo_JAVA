package src.com.mkp.v1.backtracking;

import java.util.Arrays;

public class AllPath {
    public static void main(String[] args) {
//        boolean[][] board = {
//                {false, false, false},
//                {false, false, false},
//                {false, false, false}
//        };
        boolean[][] board = new boolean[3][3];
//        allPathPrint("", board, 0, 0);
        int[][] path = new int[board.length][board[0].length];
            allPathPrintWithNoAndArray("", board, 0, 0, path, 1);
    }

    private static void allPathPrintWithNoAndArray(String in, boolean[][] board, int r, int c, int[][] path, int count) {
        if(r == board.length-1 && c == board[0].length-1 ){
            path[r][c]=count;
            for (int[] arr:path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(in);
            return;
        }
        if(board[r][c]) return;
        board[r][c]=true;
        path[r][c]=count;
        if(r > 0) allPathPrintWithNoAndArray(in+'U',board,r-1,c,path,count+1);
        if(c < board[0].length-1) allPathPrintWithNoAndArray(in+'R',board,r,c+1,path,count+1);
        if(r < board.length-1) allPathPrintWithNoAndArray(in+'D',board,r+1,c,path,count+1);
        if(c > 0) allPathPrintWithNoAndArray(in+'L',board,r,c-1,path,count+1);
        path[r][c]=0;
        board[r][c]=false;
    }

    private static void allPathPrint(String in, boolean[][] board, int r, int c) {
        if(r == board.length-1 && c == board[0].length-1 ){
            System.out.println(in);
            return;
        }
        if(board[r][c]) return;
        board[r][c]=true;
        if(r > 0) allPathPrint(in+'U',board,r-1,c);
        if(c < board[0].length-1) allPathPrint(in+'R',board,r,c+1);
        if(r < board.length-1) allPathPrint(in+'D',board,r+1,c);
        if(c > 0) allPathPrint(in+'L',board,r,c-1);
        board[r][c]=false;

    }
}
