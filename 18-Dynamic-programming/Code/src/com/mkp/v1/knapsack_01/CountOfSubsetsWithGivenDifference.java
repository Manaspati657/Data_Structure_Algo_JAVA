package src.com.mkp.v1.knapsack_01;

public class CountOfSubsetsWithGivenDifference {

//    problem statement
    /*
    *    for GFG - Count of Subsets with given Difference
    *   In problem given a difference we have to found how many subset sum differences are
    *   matching the given difference;
    *
    *   Basically we have given s2-s1=diff.
    *   e.g. arr[] = {5, 2, 6, 4}, diff=3 .
    *   here the totalSum (Sum of all the element of an array) is 17
    *   so the given formula is s2-s1 = diff
    *                           s2+s1 = totalSum
    *   s1 is cancel and 2s2 = diff+range => s2 = (diff+totalSum)/2
    *                                        s2 = (3+17)/2 = 10
    *   So we have just to search for how many s2 subset are there in array so that's the answer .
    *
    *   ex: 2
    *   Input: N = 5, arr[] = [1, 2, 3, 1, 2], diff = 1
    *   Output: 5
    *   Explanation: We can have five partitions which is shown below
    *   here the totalSum=9 and diff 1 so s2 = (10/2)=5
    *   {2, 2} and {1, 3, 1} –> S1 = 4, S2 = 5
    *   {1, 3} and {1, 2, 2} –> S1 = 4, S2 = 5
    *   {1, 1, 2} and {3, 2} –> S1 = 4, S2 = 5
    *   {1, 3} and {1, 2, 2} –> S1 = 4, S2 = 5
    *   {1, 1, 2} and {3, 2} –> S1 = 4, S2 = 5
    * */

    /*
    *
    *  494. Target Sum : Leetcode
    *  problem statement - You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer
    *  in nums and then concatenate all the integers.
    *  This problem is same as GFG problem, in gfg problem we have to find the subset but here
    *  we have sign of + and - For example, if nums = [5, 2, 6, 4] and diff is 3 , you can add a '+' before 5,7
    *  and a '-' before 6 ,4 and concatenate them to build the expression "+5+2-6-4" = 3.
    *  if we customize the problem then +5+2-6-4 = 3 => +(5+2) - (6+4) = 3
    *  this is nothing but the gfg problem finding how many subsets difference is given diff.
    *
    * */
    public static void main(String[] args) {
//        int arr[] = {5, 2, 6, 4}, diff=3;
//        int arr[] = {1, 2, 3, 1, 2}, diff=1;
//        int arr[] = {1, 5, 3, 4, 2}, diff=3;
        int arr[] = {0,0,0,0,0,0,0,0,1}, diff= 1;
        System.out.println(countPairsWithDiffK(arr,arr.length,diff));
    }

    private static int countPairsWithDiffK(int[] arr, int n, int diff) {
        int totalSum=0;
        for (int i = 0; i < n; i++) {
            totalSum+=arr[i];
        }

        int s2=(diff+totalSum)/2;
        return countSubsetPair(arr,n,s2);
    }

    private static int countSubsetPair(int[] arr, int n, int sum) {

        int[][] dp=new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0]=1;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] > j) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
            }
        }

        return dp[n][sum];

    }
}













