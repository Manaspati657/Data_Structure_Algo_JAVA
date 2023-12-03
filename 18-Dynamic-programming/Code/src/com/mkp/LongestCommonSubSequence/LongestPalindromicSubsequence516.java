package src.com.mkp.LongestCommonSubSequence;

public class LongestPalindromicSubsequence516 {

//    problem statement
    /*
    *
    *  In string the longest Palindromic SubSequence is A subsequence is a sequence that can be derived
    *  from another sequence by deleting some or no elements without changing the order of the remaining
    *  elements.
    *
    *  e.g. str="bbbcb". answer is "bbbb".
    *  if we take the lcs approach we need another string but in the problem given one string so if we
    *  take the another string as the reverse of the current string then the lcs(str,reverse(str)) is
    *  nothing but the longest Palindromic sub-sequence.
    *
    *  LPS= lcs(str,reverse(str))
    *
    * */

    public static void main(String[] args) {
//        String str="manaskumarpati";
         String str="bbbab";
//        String str="cbbd";

        System.out.println(longestPalindromeSubseq(str));
    }

    private static int longestPalindromeSubseq(String str) {
        return lcs(str,new StringBuilder(str).reverse().toString());
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
