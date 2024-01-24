package src.com.mkp.array.v2.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixII59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int circle=0,count=1,
                rowStart=0,rowEnd= n -1,colStart=0,colEnd=n-1;
//      if we calculate that how many spiral circle with n size matrix is n/2 so we only run the while loop
//      n/2 times

        while(circle <= n/2){
//            inserting first row
            for (int i = rowStart; i <= colEnd; i++)
                matrix[rowStart][i]=count++;
//            inserting last column
            for (int i = rowStart+1; i <= rowEnd; i++)
                matrix[i][colEnd]=count++;

//            inserting last row but if start row and end row is equal means only row in the matrix
//            no need run this for loop.
            if(rowStart != rowEnd)
                for (int i = colEnd-1; i >= rowStart ; i--)
                    matrix[rowEnd][i]=count++;

//            inserting first column but if there is only one column in the matrix then no need to run
//            this loop
            if(colStart != colEnd)
                for (int i = rowEnd-1; i > rowStart ; i--)
                    matrix[i][colStart]=count++;

//          increase row and col variables
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
            circle++;
        }
        return matrix;

    }
}
