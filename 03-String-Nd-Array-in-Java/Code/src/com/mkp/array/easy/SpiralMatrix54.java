package src.com.mkp.array.easy;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
//            int[][] matrix={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        //    int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        //    int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix={{1,2,3,4}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int[] ansTemp=new int[matrix.length*matrix[0].length];
        int count=0,rowLength=matrix.length;
        for (int i = 0; i < rowLength; i++) {
            int tempRowLength=rowLength-i-1;
            int tempColLength=matrix[i].length-i-1;
            // upper row : here i always constant
            for (int j = i; j <= tempColLength; j++) {
                ansTemp[count++]=matrix[i][j];
            }
            // last column : here j always constant and j is last column so j = tempColLength;
            for (int j = i+1 ; j <= tempRowLength; j++) {
                ansTemp[count++]=matrix[j][tempColLength];
            }
            // last row : here i always constant and i is last row so i = tempRowLength.
            // note loop should be in reverse order .=
                for (int j = tempColLength-1 ; j >= i; j--) {
                    ansTemp[count++]=matrix[tempRowLength][j];
                }

            // first column: here j always constant and it j = row value.
            // note loop should be in reverse order
                for (int j = tempRowLength-1; j > i; j--) {
                    ansTemp[count++]=matrix[j][i];
                }
        }
        for (int i = 0; i < ansTemp.length; i++) {
            ans.add(ansTemp[i]);
        }
        return ans;
    }
}
