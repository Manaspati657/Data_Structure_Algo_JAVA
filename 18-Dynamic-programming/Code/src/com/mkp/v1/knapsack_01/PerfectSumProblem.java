package src.com.mkp.v1.knapsack_01;

import java.util.Arrays;

public class PerfectSumProblem {

    /*
    *
    *  In subset sum problem we have to find the sum subset is on the array or not
    *  so that we just compare the result with || operator of take the number and no taking the number
    *
    *  But in this example we have to return how many subset can generate in array.
    *  so we have to sum the result and return it.
    * */

    public static void main(String[] args) {
//        int arr[] = {2, 5, 1, 4, 3}, sum = 10;
        int arr[] = {9,7,0,3,9,8,6,5,7,6}, sum = 31;
        System.out.println(calculatePerfectSum(arr,arr.length,sum));
    }

    private static int calculatePerfectSum(int[] arr, int n, int sum) {
        int[][] dp=new int[n+1][sum+1];

//        initialize the base condition in matrix as we return 1 if there is a sum subset and
//        if no sum subset then return 0

        for (int i = 0; i <= n; i++) {
            dp[i][0]=1;
        }

//        System.out.println(Arrays.deepToString(dp));
//       convert the recursion logic n --> i and sum --> j
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] > j) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j-arr[i-1]] + dp[i-1][j];
            }
        }
        return dp[n][sum];
    }

}
