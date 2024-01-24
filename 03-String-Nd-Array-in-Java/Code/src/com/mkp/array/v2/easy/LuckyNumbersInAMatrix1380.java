package src.com.mkp.array.v2.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LuckyNumbersInAMatrix1380 {
    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }
    /*
    *
    *  optimize approach : Time complexity- O(mn).
    *  Basically we check first min number index in the row after that we check that min index column max
    *  value if both match then we got the lucky number.
    *
    *
    * */
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minIndex=getMinIndexFromRow(matrix[i]);
            if(matrix[i][minIndex] == getMaxFromCol(matrix, minIndex)) ans.add(matrix[i][minIndex]);
        }
        return ans;
    }

    public static int getMaxFromCol(int[][] matrix , int col){
        int max=matrix[0][col];
        for (int i = 1; i < matrix.length; i++) {
            if(max < matrix[i][col]) max=matrix[i][col];
        }
        return max;
    }

    public static int getMinIndexFromRow(int[] arr){
        int min=0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[min]) min=i;
        }
        return min;
    }
}
