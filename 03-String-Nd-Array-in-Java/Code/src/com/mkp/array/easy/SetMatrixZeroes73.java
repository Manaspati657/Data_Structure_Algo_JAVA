package src.com.mkp.array.easy;

import java.util.Arrays;
import java.util.Stack;

public class SetMatrixZeroes73 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void setZeroes(int[][] matrix) {
        Stack<Integer> rowIndex=new Stack<>();
        Stack<Integer> colIndex=new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    rowIndex.push(i);
                    colIndex.push(j);
                }
            }
        }
        while(!rowIndex.isEmpty())
            setZeroes(matrix,rowIndex.pop(),colIndex.pop());
    }

    public static void setZeroes(int[][] matrix,int row,int col){
        // set row 0
//        Arrays.fill(matrix[row], 0);
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i]=0;
        }
        // set col 0
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col]=0;
        }
    }
}
