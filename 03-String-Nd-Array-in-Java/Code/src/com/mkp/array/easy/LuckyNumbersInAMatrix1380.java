package src.com.mkp.array.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LuckyNumbersInAMatrix1380 {
    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        List<Integer> minRow=new ArrayList<>();
        List<Integer> maxCol=new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                min=Math.min(min,matrix[i][j]);
            }
            minRow.add(min);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                max=Math.max(max,matrix[j][i]);
            }
            maxCol.add(max);
        }
        System.out.println(minRow);
        System.out.println(maxCol);
        for (int i = 0; i < matrix.length; i++) {
            if(Objects.equals(minRow.get(i), maxCol.get(i))) ans.add(minRow.get(i));
        }

        return ans;
    }
}
