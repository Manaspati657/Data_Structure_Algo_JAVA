package src.com.mkp.knapsack_unbound;

import java.util.Arrays;

public class CoinChange_i_322_memoization {

    public static void main(String[] args) {
//        int coins[] = {1,2,5}, amount = 11;
        int[] coins = {1,2,3};
        int amount = 5;
//        int coins[] = {1,7,5}, amount = 18;
//        int coins[] = {2}, amount = 3;
//        int coins[] = {430,360,440,204,206,194,150,443}, amount = 3580;
        System.out.println(coinChange(coins,amount));
    }

    private static int coinChange(int[] coins, int amount) {
        int l=coins.length;
        int[][] dp=new int[l+1][amount+1];
        for (int i = 0; i <= l; i++) {
            Arrays.fill(dp[i],-1);
        }
        int ans = coinChange(coins,coins.length,amount,dp);
        return  ans >= Integer.MAX_VALUE-1 ? -1 : ans;
    }

    private static int coinChange(int[] coins, int l, int amount,int[][] dp) {
//      if we don't have any amount and no array so in that case we need infinite number of coins.
        if(amount == 0 && l == 0) return Integer.MAX_VALUE-1;
//      if the amount 0 and length of the array is more than 0 we need 0 coins to get the amount.
        if(amount == 0) return 0;
//      if the array length is 1 means we have only one coins in that case we have two choices
//        case 1 : if the coins is divisible by the amount so in that case we can take that coins (how many
//        times that coin is multiple of the amount).
//        case 2 : if the coins is not divisible in that case we need infinite coins to get the amount.
        if(l == 1){
            if(amount % coins[0]  == 0 )
                return amount/coins[0];
            else
                return Integer.MAX_VALUE-1;
        }

        if(dp[l][amount] != -1) return dp[l][amount];

        int notTakingCoins=coinChange(coins,l-1,amount,dp);
        int takingCoins=Integer.MAX_VALUE-1;
        if(coins[l-1] <= amount) takingCoins=1+coinChange(coins,l,amount-coins[l-1],dp);
        return dp[l][amount] =  Math.min(notTakingCoins,takingCoins);
    }
}
