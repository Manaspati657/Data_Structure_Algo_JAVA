package src.com.mkp.v1.LongestCommonSubSequence;

public class ShortestCommonSuperSequence_gfg {


    //problem statement:
    /*
    *
    *   SuperSequence means that a string that has both the strings str1 and str2, and all
    *   the str1 and str2 characters should be in order.
    *
    *   e.g. str1="abcd" , str2="wxcd" -> superSequence = "abcdwxcd"
    *
    *   Then the Shortest common Super Sequence is we avoid common characters( i.e. Common SubSequence).
    *   ans -> "abwxcd" -> length is 6 .
    *
    *   Solution:
    *
    *   for only giving the length we don't have to think anything just mathematics.
    *   If we don't ignore any common SubSequence then the length of the Super Sequence is
    *   str1.length()+str2.length() = 8.
    *   and the longest common sub-sequence length is 2 so formula is
    *        (str1.length()+str2.length()) - lcs(str1,str2))
    *
    * */

    public static void main(String[] args) {
        String str1="abcd",str2= "xycd";
        System.out.println(shortestCommonSuperSequence(str1,str2,str1.length(),str2.length()));
    }

    private static int shortestCommonSuperSequence(String str1, String str2, int m, int n) {
        return (m+n) - lcs(str1,str2,m,n);
    }
    private static int lcs(String str1, String str2, int m, int n) {
        int[][] dp=new int[m+1][n+1];

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m][n];
    }

}
