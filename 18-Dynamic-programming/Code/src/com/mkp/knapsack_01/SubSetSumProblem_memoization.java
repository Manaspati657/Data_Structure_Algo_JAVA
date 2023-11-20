package src.com.mkp.knapsack_01;

import java.util.ArrayList;

public class SubSetSumProblem_memoization {

    /*
    *   Problem - find the sum 11 subset is present in the array or not.
    */

    public static void main(String[] args) {
        int arr[]={2,3,7,8,10},sum=11,n=arr.length;
//        System.out.println(permuteResultsWithRecursion(arr,sum,n));
        System.out.println(permuteResultsWithDPMemoization(arr,sum,n));
//        System.out.println(getResultArrayList(arr,sum,n));
    }

    private static boolean permuteResultsWithDPMemoization(int[] arr, int sum, int n) {
        int[][] dp=new int[n+1][sum+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                dp[i][j]=-1;
            }
        }
        int ans=helper2(arr,sum,n,dp);
        return dp[n][sum] == 1;
    }

    private static int helper2(int[] arr, int sum, int n, int[][] dp) {
        if(sum == 0 ) return 1;
        if(n==0) return 0;

        if(dp[n][sum] != -1) return dp[n][sum];

        if(arr[n-1] > sum) dp[n][sum] =helper2(arr,sum,n-1,dp);
        if(helper2(arr,sum,n-1,dp) !=0 || helper2(arr,sum-arr[n-1],n-1,dp) != 0){
            return dp[n][sum]=1;
        }else{
            return dp[n][sum]=0;
        }
    }

    private static ArrayList<Integer> getResultArrayList(int[] arr, int sum, int n) {
        ArrayList<Integer> ans=new ArrayList<>();
        boolean hasSum= helper(arr,sum,n,ans);
        return ans;
    }

    private static boolean helper(int[] arr, int sum, int n, ArrayList<Integer> ans) {

        if(sum == 0 ) return true;
        if( n== 0) return false;

        if(arr[n-1] > sum) helper(arr,sum,n-1,ans);
        ans.add(arr[n-1]);
        boolean flagWithN=helper(arr,sum-arr[n-1],n-1,ans);
        boolean flagWithoutN=helper(arr,sum,n-1,ans);

        if(flagWithN || flagWithoutN) ans.add(arr[n-1]);
        else ans.remove(arr[n-1]);

        return flagWithN || flagWithoutN;
    }

    private static boolean permuteResultsWithRecursion(int[] arr, int sum, int n) {

//      Base condition
        /*
        *  if sum is greater than 0 and n is 0 then we can't find the sum so return false
        *  otherwise sum is 0 so return true
        * */
        if(sum == 0 ) return true;
//        if( n == 0) return false;
        if(sum > 0 && n == 0) return false;
        System.out.println(sum +" sum == n "+n);
//         choice tree code:
//        if the indexed value is greater than the sum then skip the index
        if(arr[n-1] > sum) return permuteResultsWithRecursion(arr,sum,n-1);
//       otherwise just take the index and find result and without taking the index find the result
        return permuteResultsWithRecursion(arr,sum - arr[n-1],n-1)
                ||  permuteResultsWithRecursion(arr,sum,n-1);
    }

}
