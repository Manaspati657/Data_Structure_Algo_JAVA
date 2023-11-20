package src.com.mkp.knapsack_unbound;

public class knapsack_unbound_topdown{

    public static void main(String[] args) {
//        int wt[]={1,2,4,5},profit[]={5,4,8,6},w=5,n=4;
        int wt[]={5,10,15},profit[]={10,30,20},w=100,n=3;
        System.out.println(knapsackUnbound(wt,profit,w,n));
    }

    private static int knapsackUnbound(int[] wt, int[] profit, int w, int n) {
        int[][] dp=new int[n+1][w+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if(wt[i-1] > j) dp[i][j]=dp[i-1][j];
                else dp[i][j]= Math.max(profit[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
            }
        }
        return dp[n][w];
    }
}
