package src.com.mkp.LongestCommonSubSequence;

public class MinimumInsertionPalindrome1312 {


    //    problem statement:
    /*
     *
     * Given a string s. In one step you can insert any character at any index of the string.
     * Return the minimum number of steps to make s palindrome.
     *
     *  Solution find the LPS and subtract it from the length.
     *  e.g. str="mbadm". it will be a palindrome if we insert 2 character "mbdadbm".
     *  if we take the lps(Longest palindrome sub-sequence) of the string then we find "mam",
     *  b and d is extra character, so we have to insert that character in the string once more
     *  so that the string becomes a palindrome. so the formula is same as minimum number of
     *  deletion problem.
     *
     *  ans => (length-LPS) => (length-lcs(str,reverse(str)))
     *
     *  LPS= lcs(str,reverse(str))
     *
     * */


    public static void main(String[] args) {
//        String str="zzazz";
//        String str="mbadm";
        String str="leetcode";

        System.out.println(minInsertions(str));
    }

    public static int minInsertions(String s) {
        return s.length() - lps(s);
    }

    private static int lps(String str1) {
        int m=str1.length(),n=m;
        String str2=new StringBuilder(str1).reverse().toString();
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



















