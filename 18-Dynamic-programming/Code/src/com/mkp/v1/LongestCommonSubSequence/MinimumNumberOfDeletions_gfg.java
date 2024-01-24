package src.com.mkp.v1.LongestCommonSubSequence;

public class MinimumNumberOfDeletions_gfg {

//    problem statement:
    /*
    *
    * Given a string 'str' of size ‘n’. The task is to remove or delete the minimum number of characters
    * from the string so that the resultant string is a palindrome. Find the minimum numbers of characters
    *  we need to remove.
    *
    *  Solution find the LPS and subtract it from the length
    *
    *  ans => (length-LPS) => (length-lcs(str,reverse(str)))
    *
    *  LPS= lcs(str,reverse(str))
    *
    * */

    public static void main(String[] args) {
//        String str="aebcbda";
        String str="aba";

        System.out.println(minDeletions(str,str.length()));
    }

    private static int minDeletions(String str, int n)
    {
        return (n - lcs(str,new StringBuilder(str).reverse().toString()));
    }

    private static int lcs(String str1, String str2) {
        int m = str1.length(),n=str2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m][n];
    }
}
