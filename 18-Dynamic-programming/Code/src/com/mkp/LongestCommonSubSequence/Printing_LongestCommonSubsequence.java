package src.com.mkp.LongestCommonSubSequence;

import java.util.Arrays;

public class Printing_LongestCommonSubsequence {

    public static void main(String[] args) {
//        String str1="aggtab",str2= "gxtxayb";
//        String str1="BD",str2= "ABCD";
        String str1="manaskumarpati",str2= "mkp";

        System.out.println(longestCommonSubsequence(str1,str2));
    }

    private static String longestCommonSubsequence(String str1, String str2) {
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

        StringBuilder ans=new StringBuilder("");

        int i=m,j=n;
        while(i > 0 && j > 0){
//          when we create lcs if the both character is same we have added 1 to our answer and decrease i and j
//          by 1 just like that here we add that character to our ans and decrease i and j by 1.
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
//              if both character is not match we have take the Max answer of i-1,j and i,j-1
//              so which ever value is greater we move that way.
                if(dp[i][j-1] > dp[i-1][j]) j--;
                else if(dp[i-1][j] > dp[i][j-1]) i--;
            }
        }

//        System.out.println(Arrays.deepToString(dp));
        return ans.reverse().toString();
    }
}
