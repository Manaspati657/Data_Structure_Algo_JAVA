package src.com.mkp.v1.knapsack_unbound;

import java.util.Arrays;

public class CoinChange_ii_518_memoization {
    /*
     *
     * You are given an integer array coins representing coins of different denominations and
     * an integer amount representing a total amount of money.
     * Return the number of combinations that make up that amount. If that amount of money cannot
     * be made up by any combination of the coins, return 0.
     *
     * */

    public static void main(String[] args) {
        int[] coins={1,2,3};
        int amount=5;
        System.out.println(change(coins,amount));
    }

    private static int change(int[] coins, int amount) {
        int l=coins.length;
        int[][] dp=new int[l+1][amount+1];
        for (int i = 0; i <= l; i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(coins,l,amount,dp);
    }

    private static int helper(int[] coins, int length, int amount,int[][] dp) {
        if(amount == 0 ) return 1;
        if(length == 0) return 0;

        if(dp[length][amount] != -1) return dp[length][amount];

        int notTaken=helper(coins,length-1,amount,dp);
        int takeCoin=0;
        if(coins[length-1] <= amount)
            takeCoin=helper(coins,length,amount-coins[length-1],dp);
        return dp[length][amount]=notTaken+takeCoin;
    }
}
