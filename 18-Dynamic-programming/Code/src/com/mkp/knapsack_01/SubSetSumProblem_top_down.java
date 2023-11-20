package src.com.mkp.knapsack_01;

import java.util.Arrays;

public class SubSetSumProblem_top_down {
    /*
     *   Problem - find the sum 11 subset is present in the array or not.
     */

    public static void main(String[] args) {
//        int arr[]={2,3,7,8,10},sum=11,n=arr.length;
        int arr[]={1,1},sum=1,n=arr.length;
        System.out.println(permuteResults(arr,sum,n));
    }

    private static boolean permuteResults(int[] arr, int sum, int n) {

        boolean[][] dp=new boolean[n+1][sum+1];

//        as base condition initialize the array

//        index 0 of first row and index 0 of first column is True because with 0 number we generate 0 sum
//        but rest of the first row of every column is false because we can't generate any sum with 0 numbers.

        for (int i = 1; i < sum+1; i++) {
            dp[0][i]=false;
        }
//        index 0 of every row is true because with any number we can generate 0 sum subset.
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=true;
        }
//        System.out.println(Arrays.deepToString(dp));

//        as choice diagram of recursion converts the logic to n --> i and sum --> j
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] > j) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
