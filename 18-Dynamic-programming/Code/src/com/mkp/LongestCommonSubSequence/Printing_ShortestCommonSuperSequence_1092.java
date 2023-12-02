package src.com.mkp.LongestCommonSubSequence;

public class Printing_ShortestCommonSuperSequence_1092 {
    //problem statement:
    /*
     *
     *   SuperSequence means that a string that has both the strings str1 and str2, and all
     *   the str1 and str2 characters should be in order.
     *
     *   e.g. str1="abcd" , str2="wxcd" -> superSequence = "abcdwxcd"
     *
     *   Then the Shortest common Super Sequence is we avoid common characters( i.e. Common SubSequence).
     *   ans -> "abwxcd"
     *
     *   Solution:
     *   Just like printing lcs we take the same approach but there we skip if the character is not
     *   matched but here we will take both the character
     *
     *
     * */

    public static void main(String[] args) {
//        String str1="abcd",str2= "xycd";
        String str1="abac",str2= "cab";
        System.out.println(shortestCommonSuperSequence(str1,str2,str1.length(),str2.length()));
    }

    private static String shortestCommonSuperSequence(String str1, String str2, int m, int n) {
        int[][] dp=new int[m+1][n+1];

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        StringBuilder ans=new StringBuilder("");

        int i=m,j=n;
        while(i > 0 && j > 0){
//         Just like printing lcs here we add that character to our ans and decrease i and j by 1.
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
//         just like lcs printing
                if(dp[i][j-1] > dp[i-1][j]){
                    ans.append(str2.charAt(j-1));
                    j--;
                }
                else{
                    ans.append(str1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i > 0){
            ans.append(str1.charAt(i-1));
            i--;
        }
        while(j > 0){
            ans.append(str2.charAt(j-1));
            j--;
        }

        return ans.reverse().toString();
    }

}
