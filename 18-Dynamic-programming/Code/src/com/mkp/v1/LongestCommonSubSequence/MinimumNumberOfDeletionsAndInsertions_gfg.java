package src.com.mkp.v1.LongestCommonSubSequence;

public class MinimumNumberOfDeletionsAndInsertions_gfg {


//    problem statement
    /*
    *
    * Given two strings str1 and str2. The task is to remove or insert the minimum
    * number of characters from/in str1 to transform it into str2.
    *
    *
    * */

    public static void main(String[] args) {
//        String word1 = "sea", word2 = "eat";
        String word1 = "heap", word2 = "pea";
        System.out.println(minOperations(word1,word2));
    }

    public static int minOperations(String word1, String word2)
    {
        // Your code goes here
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

//      if we add two string then lcs also includes 2 times so we just substract 2 times lcs from
//      the total length

        return (m-dp[m][n]) + (n-dp[m][n]);
    }
}
