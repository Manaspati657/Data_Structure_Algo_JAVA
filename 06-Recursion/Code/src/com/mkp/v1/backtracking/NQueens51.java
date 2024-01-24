package src.com.mkp.v1.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens51 {

//    this solution not working for more than 4 Queens
    public static void main(String[] args) {
        int n=4;
        List<List<String>> ans=solveNQueens(n);
//        System.out.println(ans);

    }

    public static List<List<String >> solveNQueens(int n) {
        boolean[][] maze=new boolean[n][n];
        return solve(maze,0);
    }

    private static List<List<String>> solve(boolean[][] maze, int row) {
        if(row == maze.length){
              display(maze);
            System.out.println();
            List<List<String>> ans=new ArrayList<>();
            ans.add(convertToArrayList(maze));
            return ans;
        }
        List<List<String>> ansList=new ArrayList<>();
        for (int col = 0; col < maze.length; col++) {
            if(isSafe(maze,col,row)){
                maze[row][col]=true;
                ansList.addAll(solve(maze,row+1));
                maze[row][col]=false;
            }
        }
        return ansList;
    }

    private static boolean isSafe(boolean[][] maze, int col, int row) {

//        check vertical row ( means queen same upper column)
        for (int i = 0; i < row; i++) {
            if(maze[i][col]) return false;
        }

//        check left side diagonal
        int maxLeft=Math.min(row,col);
        for (int i = 1 ; i <= maxLeft; i++) {
            if(maze[row-1][col-1]) return false;
        }

//        check right side diagonal
        int maxRight=Math.min(row,maze.length-col-1);
        for (int i = 1; i <= maxRight; i++) {
            if(maze[row-i][col+i]) return false;
        }

        return true;
    }

    private static void display(boolean[][] maze) {
        for (boolean[] arr: maze) {
            for(boolean element : arr) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();

        }
    }

    private static List<String> convertToArrayList(boolean[][] maze) {
        List<String> ans=new ArrayList<>();
        for (boolean[] arr:maze){
            String strAns= "";
            for (boolean e:arr){
                if(e) strAns+="Q";
                else strAns+=".";
            }
            ans.add(strAns);
        }
        return ans;
    }
}
