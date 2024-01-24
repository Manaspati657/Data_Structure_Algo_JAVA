package src.com.mkp.v1.knapsack_unbound;

import java.util.Arrays;

public class CoinChange_ii_518_topdown {
    public static void main(String[] args) {
        int[] coins={1,2,3};
        int amount=5;
        System.out.println(change(coins,amount));
    }

    private static int change(int[] coins, int amount) {
        int l=coins.length;
        int[][] dp=new int[l+1][amount+1];
        for (int i = 0; i <= l; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <= l ; i++) {
            for (int j = 1; j <= amount ; j++) {
                if(coins[i-1] > j) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[l][amount];
    }


}
