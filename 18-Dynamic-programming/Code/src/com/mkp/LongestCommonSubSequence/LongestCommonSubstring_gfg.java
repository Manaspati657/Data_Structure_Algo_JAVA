package src.com.mkp.LongestCommonSubSequence;

public class LongestCommonSubstring_gfg {


    public static void main(String[] args) {
        String str1="abcdxyz",str2= "xyzabcd";
//        String str1="BD",str2= "ABCD";

        System.out.println(longestCommonSubstring(str1,str2,str1.length(),str2.length()));
    }

    private static int longestCommonSubstring(String str1, String str2,int m,int n) {
        int[][] dp=new int[m+1][n+1];

//        initialize base condition of the dp but by default every value is 0

//        convert the recursion logic to i and j
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=0;
            }
        }

        int ans=0;

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                ans=Math.max(ans,dp[i][j]);
            }
        }


//        System.out.println(Arrays.deepToString(dp));
        return ans;
    }
}
