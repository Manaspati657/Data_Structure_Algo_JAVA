package src.com.mkp.v1.knapsack_unbound;

import java.util.Arrays;

public class CoinChange_i_322_topdown {
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
//        initialize array as base condition from memoization approach
        for (int i = 0; i <= amount; i++) {
            dp[0][i]=Integer.MAX_VALUE-1;
        }
        for (int i = 1; i <= l; i++) {
            dp[i][0]=0;
        }

        for (int i = 1; i <= amount; i++) {
            if(i % coins[0] == 0)
                dp[1][i]= i/coins[0];
            else
                dp[1][i]=Integer.MAX_VALUE-1;
        }

        for (int i = 2; i <= l; i++) {
            for (int j = 1; j <= amount; j++) {
                int notTakingCoins=dp[i-1][j];
                int takingCoins=Integer.MAX_VALUE-1;
                if(coins[i-1] <= j)
                    takingCoins=1+dp[i][j-coins[i-1]];
                dp[i][j]= Math.min(notTakingCoins,takingCoins);
            }
        }

        return  dp[l][amount] >= Integer.MAX_VALUE-1 ? -1 : dp[l][amount];
    }
}
