package src.com.mkp.array.easy;

import java.util.Arrays;

public class TransposeMatrix867 {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }

    /*
    *
    *  Brute force approach : TC:O(M*N) and SC :O(M*N)
    *
    * */
    public static int[][] transpose(int[][] matrix) {
        int row= matrix.length,col=matrix[0].length;
//        if we transpose then row becomes column and column becomes row
        int[][] ans=new int[col][row];
        for(int i = 0 ;i < ans.length;i++)
            for(int j = 0;j < ans[i].length;j++)
                    ans[i][j]=matrix[j][i];
        return ans;
    }
}
