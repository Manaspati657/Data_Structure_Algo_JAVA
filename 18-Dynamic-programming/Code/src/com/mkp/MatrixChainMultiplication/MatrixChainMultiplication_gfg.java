package src.com.mkp.MatrixChainMultiplication;

import java.util.Arrays;

public class MatrixChainMultiplication_gfg {

    /*
    *   For any problem is like we have to find the minimum cost or maximum cost with taking multiple
    *   example with k changes in between a range ( i to j ) in that problem we can take mcm technique.
    *
    *   MCM format :
    *
    *   int mcmFunc(int[] arr,int i ,int j){
    *       //base condition : i and j are index of array . i start from left side and j start from right side
    *       //so if i cross j then we can find k in between them.
    *       if ( i > j) return 0;
    *
    *
    *       int ans = Integer.MAX_VALUE;
    *       // k = i , k <= j , k++ --> all are vary as per the problem requirements.
    *       for(int k = i ;k <= j;k++){
    *           //calculate temporary answer for (i to k and k+1 to j) Or (i to k-1 and k to j)  .
    *           //but this logic also be changed as per problem.
    *           // recursion answer will be + , - , *  depends on problem.
    *           int tempAns = mcmFunc(arr,i ,k) + mcmFunc(arr,k+1,j);
    *
    *           //compare the tempAns with answer .
    *           ans=max/min/-/+ anything with temp ans ;
    *        }
    *        return ans;
    *   }
    *
    *   Problem :
    *    Given a sequence of matrices, find the most efficient way to multiply these matrices together.
    *    The efficient way is the one that involves the least number of multiplications.
    *    The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1)
    *    where the ith matrix has the dimensions (arr[i-1] x arr[i]).
    *    e.g. arr={1,2,3,4,3}; n = 5 then there is 4 matrix. i start from 1 because n is 5 matrix 4 ;
    *    Mi matrix dimensions is (arr[i-1] x arr[i])
    *    M1 matrix dimensions is ( 1 x 2)
    *    M2 matrix dimensions is ( 2 x 3)
    *    M1 matrix dimensions is ( 3 x 4)
    *    M1 matrix dimensions is ( 4 x 3)
    *
    *    Note :
    *      -> Two matrix multiplication is only possible if first matrix row and second matrix column number is
    *         same.
    *      -> Two matrices of size m*n and n*p when multiplied, they generate a matrix of size m*p and the number
    *         of multiplications performed are m*n*p.
    *      -> After matrix multiplication new matrix is M1 row x m2 column.
    *         e.g. M1 (2 x 3) * M2 (3 x 4) => M (2 x 4)
    *      -> the no of multiplication between the matrix is .
    *         e.g. M1 (2 x 3) * M2 (3 x 4) => 2 * 3 * 4
    *
    * */


    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
//        int[] arr = {1, 2, 3, 4, 3};
        System.out.println(matrixMultiplication(arr.length,arr));
    }
    public static int matrixMultiplication(int N, int arr[])
    {
//        Without memoization
//        return helper(arr,1,N-1);

//        with memoization
        int[][] dp=new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j ) dp[i][j]= 0;
                else dp[i][j]=-1;
            }
        }
        return helper2(arr,1,N-1,dp);
    }

//    With Memoization
    private static int helper2(int[] arr, int i, int j,int[][] dp) {
//        base condition if i == j we can't create a matrix as per the matrix create formula.and if i > j
//        we can't create a k between then .
        if(i >= j ) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans= Integer.MAX_VALUE;
//       we can take k = i or k = i +1 but for both difference logic will be used
//       if k = i then k <= j-1 and recursion call will be from ( i , k) and (k+1 , j)
//       if k = i+1 then k < j and recursion call will be from ( i , k-1) and (k , j)
        for (int k = i; k <= j-1; k++) {
            int temp=helper2(arr,i , k ,dp)+helper2(arr,k+1,j,dp)+(arr[i-1]*arr[k]*arr[j]);
//          (arr[i-1]*arr[k]*arr[j]) - this is the no of multiplication between the matrix current two matrix.

//          compare the result with the ans
            if(temp < ans) ans=temp;
        }

        return dp[i][j]=ans;

    }


//    without memoization
    private static int helper(int[] arr, int i, int j) {
//        base condition if i == j we can't create a matrix as per the matrix create formula.and if i > j
//        we can't create a k between then .
        if(i >= j ) return 0;

        int ans= Integer.MAX_VALUE;
//       we can take k = i or k = i +1 but for both difference logic will be used
//       if k = i then k <= j-1 and recursion call will be from ( i , k) and (k+1 , j)
//       if k = i+1 then k < j and recursion call will be from ( i , k-1) and (k , j)
        for (int k = i; k <= j-1; k++) {
            int temp=helper(arr,i , k )+helper(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);
//          (arr[i-1]*arr[k]*arr[j]) - this is the no of multiplication between the matrix current two matrix.

//          compare the result with the ans
            if(temp < ans) ans=temp;
        }

        return ans;

    }
}
