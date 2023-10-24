package src.com.mkp.theory;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String str1="Manas Kumar Pati";
        String str2="Manas Pati";
        System.out.println("Longest Common Prefix");
        System.out.println(str1.substring(0,lcp(str1,str2)));
    }

//    time complexity : O(N) linear time
    private static int lcp(String str1, String str2) {
        int N=str1.length();
        for (int i = 0; i < N; i++) {
            if(str1.charAt(i) != str2.charAt(i)) return i;
        }
        return N;
    }
}
