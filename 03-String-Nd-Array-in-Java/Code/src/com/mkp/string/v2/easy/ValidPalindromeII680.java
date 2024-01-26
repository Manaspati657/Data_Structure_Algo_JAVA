package src.com.mkp.string.v2.easy;

public class ValidPalindromeII680 {

    public static void main(String[] args) {
//        String s = "aba";
//        String s = "cbccbcx";
        String s = "abceddcba";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int sI =0 ,eI =s.length()-1;
        while(sI <= eI){
            if(s.charAt(sI) != s.charAt(eI))
                if(!isPalindrome(s,sI+1,eI))
                    return isPalindrome(s,sI,eI-1);
                else
                    return true;
            sI++;
            eI--;
        }
        return true;
    }

    private static boolean isPalindrome(String s,int sI,int eI) {
        while(sI <= eI){
            if(s.charAt(sI) != s.charAt(eI)) return false;
            sI++;
            eI--;
        }
        return true;
    }
}
