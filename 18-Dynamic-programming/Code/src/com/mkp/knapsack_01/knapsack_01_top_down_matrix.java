package src.com.mkp.knapsack_01;

import java.util.Arrays;

public class knapsack_01_top_down_matrix {

    /*
    *  In top-down approach we don't use any recursion, we use for loop with matrix of MxN.
    *
    *  we create a matrix with row(w+1) and (n+1).
    *
    * */
    public static void main(String[] args) {
        int wt[]={1,2,4,5},profit[]={5,4,8,6},w=5,n=4;
        System.out.println(computeMaxProfit(wt,profit,w,n));
//        System.out.println(knapSack(w,wt,profit,n));
    }

    private static int computeMaxProfit(int[] wt, int[] profit, int w, int n) {
        int[][] dp=new int[n+1][w+1];

//      use recursion base condition - if any w or n is 0 then max profit is 0 so initialize
//      0 for row first row and every first col of every row
//      we don't run this because by default every value is 0 in java int array.
//        for (int i = 0,j=0; i <= n || j <=w ; i++,j++) {
//            if(i <= n) dp[i][0]=0;
//            if(j <= w) dp[0][j]=0;
//        }

        System.out.println(Arrays.deepToString(dp));

//        use the same recursion choice logic to fill the dp matrix
//        convert n-> i and w->j

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
//                System.out.println(i+" i === j "+j);
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(wt[i-1] > j) dp[i][j]=dp[i-1][j];
                else {
//                    System.out.println("j-wt[i-1] = "+(j-wt[i-1]));
                    dp[i][j]=Math.max(profit[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[n][w];
    }

}
