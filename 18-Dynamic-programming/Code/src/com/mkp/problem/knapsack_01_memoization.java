package src.com.mkp.problem;

import java.util.Arrays;

public class knapsack_01_memoization {

//
/*
*   Dp is basically Recursion + memoization
*
*   knapsack 01 - knapsack means bag and 0 1 means either we take it (1) or
*   don't  take it(0)
*
*   In memoization concept we have store the previous tree answer in
*   a temp area use it in future recursion call.
*
*   In this algorithm we use dp matrix for memoization . before we return the max profit
*   to the previous recursion call, we just store that answer dp and if any other
*   recursion call that matrix index have already answer then we just return that
*   answer.
*
* */

    public static void main(String[] args) {
        int wt[]={1,2,4,5},profit[]={5,4,8,6},w=5,n=4;
        System.out.println(computeMaxProfit(wt,profit,w,n));
    }

    private static int computeMaxProfit(int[] wt, int[] profit, int w, int n) {

        int[][] dp=new int[n+1][w+1];
        for (int i = 0; i <w+1; i++) {
            for (int j = 0; j <n+1; j++) {
                dp[i][j]=-1;
            }
        }
        int ans= helper(wt,profit,w,n,dp);
        System.out.println(Arrays.deepToString(dp));
        return ans;
    }

    private static int helper(int[] wt, int[] profit, int w, int n,int[][] dp) {
        System.out.println(n+" n -- w "+(w));
//        base condition - if n =0 or weight is 0 then max profit will be 0
        if(n==0 || w==0) return 0;

//        dp memoization - if already result find for that n and w then return that result
        if(dp[n][w] != -1) return dp[n][w];

//         recursion code with choice tree

//        System.out.println(w+" w -- n "+(n));
//        if the wt index weight is greater than the bag weight then skip that index
        if(wt[n-1] > w) return dp[n][w]= helper(wt,profit,w,n-1,dp);
//      else if(wt[n-1] <= w)
//        if the wt index weight is less than equals the bag weight then we get max profit from 0 | 1.
//        1 - we take that weight, if we take the weight we add that profit and search for
//        remaining indexes with weight - current index weight .
//        0 - we don't take that weight so just skip that weight and search for remaining indexes with
//        current weight .
        else
            return dp[n][w] = Math.max(profit[n-1]+helper(wt,profit,w-wt[n-1],n-1,dp),
                    helper(wt,profit,w,n-1,dp));
    }
}
