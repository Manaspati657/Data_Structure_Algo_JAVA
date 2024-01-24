package src.com.mkp.v1.knapsack_01;

public class PartitionEqualSubsetSum416 {

    /*
    * check whether the array can be equally partition or not
    *  e.g {1,5,1} and {11}
    *
    *  but before checking the subset partition we have to check the array sum is even or odd
    *  if even there is a possible partition . if odd then return false e.g. if sum is 23 then
    *  there is no subset with equal sum . if even 24 we can search for subset of 12 and 12.
    *
    * */
    public static void main(String[] args) {
//        int[] arr={1,5,11,5};
        int[] arr={1,1};
        System.out.println(canPartition(arr));
    }

    private static boolean canPartition(int[] arr) {
        int sum =0,n=arr.length;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        if(sum % 2 != 0 ) return false;
        sum=sum/2;
        boolean[][] dp=new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++)
            dp[i][0]=true;
        findSubset(arr,n,sum,dp);
        return dp[n][sum];
    }

    private static void findSubset(int[] arr, int n, int sum,boolean[][] dp) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] > j) dp[i][j]=dp[i-1][j];
                else {
                    dp[i][j]=(dp[i-1][j-arr[i-1]] || dp[i-1][j] );
                }
            }
        }

    }
}
