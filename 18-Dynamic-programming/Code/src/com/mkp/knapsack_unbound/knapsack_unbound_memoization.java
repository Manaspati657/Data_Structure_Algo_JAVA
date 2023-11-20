package src.com.mkp.knapsack_unbound;

public class knapsack_unbound_memoization {

    /*
    *   knapsack 01 is either we take the element of not taking the element, and we can't take more
    *   than one time one element.
    *   knapsack unbound is if we take one element we can take that element another time and if we ignore
    *   that element we will not take it anymore.
    *
    *
    * */

    public static void main(String[] args) {
//        int wt[]={1,2,4,5},profit[]={5,4,8,6},w=5,n=4;
        int wt[]={5,10,15},profit[]={10,30,20},w=100,n=3;
        System.out.println(knapsackUnbound(wt,profit,w,n));
    }

    private static int knapsackUnbound(int[] wt, int[] profit, int w, int n) {
        int[][] dp=new int[n+1][w+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j]=-1;
            }
        }
        return helper(wt,profit,w,n,dp);
    }

    private static int helper(int[] wt, int[] profit, int w, int n, int[][] dp) {
        if(w == 0 || n == 0) return 0;

        if(dp[n][w] != -1) return dp[n][w];

        if(wt[n-1] > w) return dp[n][w] = knapsackUnbound(wt,profit,w,n-1);
        else return dp[n][w] = Math.max(profit[n-1] + knapsackUnbound(wt,profit,w-wt[n-1],n),
                      knapsackUnbound(wt,profit,w,n-1));
    }


}
