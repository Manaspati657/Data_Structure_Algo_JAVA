package src.com.mkp.LongestCommonSubSequence;

import java.util.Arrays;
import java.util.Map;

public class LongestCommonSubSequence_memoization1143 {

//   problem statement
    /*
    *  substring: order is same and continuous characters
    *  subsequence: order is same and non-continuous characters.
    *
    *
    *  A longest common subsequence (LCS) is defined as the longest subsequence which
    *  is common in all given input sequences.
    *
    *  ex:1 :  Input: S1 = “AGGTAB”, S2 = “GXTXAYB”
    *          Output: 4
    *          Explanation: The longest subsequence which is present in both strings is “GTAB”.
    *  ex:2 : Input: S1 = “BD”, S2 = “ABCD”
    *         Output: 2
    *         Explanation: The longest subsequence which is present in both strings is “BD”.
    *
    * */

    public static void main(String[] args) {
//        String str1="AGGTAB",str2= "GXTXAYB";
        String str1="BD",str2= "ABCD";

        System.out.println(longestCommonSubsequence(str1,str2));
    }

    private static int longestCommonSubsequence(String str1, String str2) {
        int m=str1.length(),n=str2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(str1,str2,m,n,dp);
    }

    private static int helper(String str1, String str2, int m, int n,int[][] dp) {
//        if any length of the string is 0 then return 0 because if any string is empty then there
//        is no subsequence.
        if(m == 0 || n==0 ) return 0;

        if(dp[m][n] != -1) return dp[m][n];

//      if we find the last character is same then we find 1 subsequence character
//      then find for other string.
        if(str1.charAt(m-1) == str2.charAt(n-1)) return dp[m][n]=1+helper(str1,str2,m-1,n-1,dp);
//      if we find the last character is not matched then we will skip one from both side and search
//      for maximum of longest common subsequence
        return dp[m][n]=Math.max(helper(str1,str2,m-1,n,dp),helper(str1,str2,m,n-1,dp));
    }
}
