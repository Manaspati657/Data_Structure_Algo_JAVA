package src.com.mkp.string.v2.medium;

public class MinimumLengthOfStringAfterDeletingSimilarEnds1750 {
    public static void main(String[] args) {
//        String s = "cabaabac";
//        String s = "aabccabba";
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        System.out.println(minimumLength(s));
    }
    public static int minimumLength(String s) {
        int i =0, j= s.length()-1;
        while( i < j && s.charAt(i) == s.charAt(j)){
            char ch=s.charAt(j);
            while (i <= j && s.charAt(i) == ch) i++;
            while (i <= j && s.charAt(j) == ch) j--;
        }
        return j-i+1;
    }
}
