package src.com.mkp.v1.knapsack_unbound;

public class Rod_Cutting_topDown {

    //    problem statement
    /*
     *
     * we have length n rod , we have to cut in some length so that profit is maximum .
     * we are allow to cut same length many times, so it's knapsack unbound problem.
     *
     * */

    public static void main(String[] args) {
        int N = 8;
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price,N));
    }

    private static int cutRod(int[] price, int n) {
        int price_length=price.length;
        int[][] dp=new int[price_length+1][n+1];
        for(int i =1;i <= price_length;i++){
            for(int j=1; j <= n; j++){
                if(i > j) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(price[i-1]+dp[i][j-i],dp[i-1][j]);
            }
        }
        return dp[price_length][n];
    }
}
