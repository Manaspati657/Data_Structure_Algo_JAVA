package src.com.mkp.array.v2.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
//            int[][] matrix={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//            int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
//            int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] matrix={{1,2,3,4}};
        int[][] matrix={{1},{2},{3},{4}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int rowLength=matrix.length,colLength=matrix[0].length,
                rowStart=0,rowEnd=rowLength-1,colStart=0,colEnd=colLength-1;
        while(ans.size() != rowLength * colLength){
//            inserting first row
            for (int i = rowStart; i <= colEnd; i++)
                ans.add(matrix[rowStart][i]);
//            inserting last column
            for (int i = rowStart+1; i <= rowEnd; i++)
                ans.add(matrix[i][colEnd]);

//            inserting last row but if start row and end row is equal means only row in the matrix
//            no need run this for loop.
            if(rowStart != rowEnd)
                for (int i = colEnd-1; i >= rowStart ; i--)
                    ans.add(matrix[rowEnd][i]);

//            inserting first column but if there is only one column in the matrix then no need to run
//            this loop
            if(colStart != colEnd)
                for (int i = rowEnd-1; i > rowStart ; i--)
                    ans.add(matrix[i][colStart]);

//          increase row and col variables
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return ans;
    }
}
