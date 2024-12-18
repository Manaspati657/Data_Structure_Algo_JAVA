package src.com.mkp.easy.v2;

public class FibonacciNthNumberV2 {

    public static void main(String[] args) {
        System.out.println("fibonacci series 10th no :: "+getFibonacciNth(3));
    }

    private static int getFibonacciNth(int n) {
        if(n == 0 ) return 0;
        if(n == 1 ) return 1;
        if(n == 2 ) return 1;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        for(int i = 3 ;i <= n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
