package src.com.mkp.v1.MatrixChainMultiplication;

public class PalindromePartitioningII132 {

    /*
    *
    *   Given a string s, partition s such that every substring of the partition is a palindrome.
    *   Return the minimum cuts needed for a palindrome partitioning of s.
    *
    *   e.g. s = "aab" , if we cut 3 times there is 3 palindrome "a","a","b",
    *                    but "aa" already palindrome, so only we need 1 min cut.
    *
    *
    * */

    public static void main(String[] args) {
//        String s = "aab";
        String s = "nitis";
        System.out.println(minCut(s));
    }

    public static int minCut(String s) {
        int n = s.length();
        int[][] dp=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) dp[i][j] = 0;
                else dp[i][j] = -1;
            }
        }
        return helper(s,0,n-1,dp);
    }

    private static int helper(String s,int i ,int j,int[][] dp) {
//      if i == j means there is only one character so one character is always palindrome, so
//      we don't need any cut , another condition if i > j that's means string is empty we need
//      0 cut
        if(i >= j) return 0;

//      Before checking for any cut if the string is already palindrome we don't need any cut
        if(isPalindrome(s,i,j)) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans=Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int left,right;
            if(dp[i][k] != -1 ){
                left=dp[i][k];
            }else{
                left=helper(s,i,k,dp);
                dp[i][k]=left;
            }
            if(dp[k+1][j] != -1){
                right=dp[k+1][j];
            }else{
                right=helper(s,k+1,j,dp);
                dp[k+1][k]=right;
            }
            int temp=1+left+right;
            if(temp < ans) ans=temp;
        }
        return dp[i][j] = ans;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        if( i == j ) return true;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }

}

