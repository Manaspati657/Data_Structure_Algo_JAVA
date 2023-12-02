package src.com.mkp.LongestCommonSubSequence;

import java.util.Arrays;

public class LongestCommonSubSequence_TopDown1143 {

    public static void main(String[] args) {
        String str1="AGGTAB",str2= "GXTXAYB";
//        String str1="BD",str2= "ABCD";

        System.out.println(longestCommonSubsequence(str1,str2));
    }

    private static int longestCommonSubsequence(String str1, String str2) {
        int m=str1.length(),n=str2.length();
        int[][] dp=new int[m+1][n+1];

//        initialize base condition of the dp but by default every value is 0

//        convert the recursion logic to i and j
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }
}
