package src.com.mkp.array.easy;

public class MatrixDiagonalSum1572 {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] mat = {{1,1,1,1}, {1,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(diagonalSum(mat));
    }

    /*
    *   optimize approach : TC : O(N).
    *
    *   for primary diagonal we know that i and j same with 1 loop we can get the sum .
    *   for secondary diagonal if we observe j is always i and for i the formula is same as
    *   Brute force approach i = n-i-1 .
    *
    *   Note : In this approach if the length is odd then mid-element add in sum for twice.
    *          so for that we check if the length is odd then we just remove middle element once.
    *
    * */

    public static int diagonalSum(int[][] mat) {
        int n=mat.length,sum=0;
        for (int i = 0; i < n; i++) {
            sum+=mat[i][i];
            sum+=mat[n-i-1][i];
        }

        if (n % 2 == 1) sum-= mat[n/2][n/2];
        return sum;
    }
    /*
    *
    * Brute force : O(N^2)
    *
    *  Approach : getting primary diagonal is easy because i and j is same to find secondary diagonal
    *             value we need to check i with n-j-1 if i == n-j-1  then i.e. the secondary diagonal element.
    *
    * */

    public static int diagonalSumV1(int[][] mat) {
        int n=mat.length,sum=0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) sum+=mat[i][j];
                else if( i == n-j-1) sum+=mat[i][j];
            }
        }
        return sum;
    }
}
