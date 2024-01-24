package src.com.mkp.v1.knapsack_01;

public class MinimumSumPartition {

//    problem statement
    /*
    *
    *   2035. Partition Array Into Two Arrays to Minimize Sum Difference
    *
    *   Basically we have to find the minimum difference between two subset of the array.
    *   e.g. if s1 and s2 are two subset then s2-s1 is difference.
    *
    *   Taking this example int n = 4, arr[] = {1, 6, 11, 5};
    *   Here the sum of the array is 23 so the s1 and s2 subset sum lies between 0 and 23. then
    *   the range of highest sum is sum of the array i.e. 23.
    *
    *   we have to find the minimum difference but greater than 0. so we will do the difference of
    *   s2-s1 = minimum difference , here s2 is greater sum than s1 then we can get positive minimum difference.
    *
    *   if s2 and s1 are two subset of array then there sum is Range of the array.
    *   So s2 + s1 = range then s2 = range - s1
    *
    *   Now the minimum difference formula is range - s1 - s1 = minimum diff => range - 2s1=minimum diff.
    *   So only we have to find all the s1 subset sum between 0 and range i.e. 23 .then find the minimum
    *   difference.
    *
    *   Now the problems is smaller. we have to all subset that is sum of 0 to 23 with n is array length. this is basically
    *   last row of the topdown knapsack problem.
    *
    * */

    public static void main(String[] args) {
//        int arr[] = {1, 6, 11, 5};
        int arr[] = {3, 9, 7, 3};
//        int arr[] = {1, 4};
        System.out.println(minDifference(arr, arr.length));
    }

    private static int minDifference(int[] arr, int n) {
        int range=0;
//      calculate the range
        for (int i = 0; i < n; i++) {
            range+=arr[i];
        }

//        topdown knapsack
        boolean[][] dp=new boolean[n+1][range+1];
        knapsack(arr,dp);

//       using this formula we have to find the minimum difference
//       range - 2s1=minimum diff

        int diffMin=Integer.MAX_VALUE;
        for (int i = 0; i <= range/2; i++) {
            if(dp[n][i]){
                diffMin=Math.min(diffMin,range-2*i);
            }
        }
        return diffMin;
    }

    private static void knapsack(int[] arr,boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(arr[i-1] > j) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
            }
        }
    }
}












