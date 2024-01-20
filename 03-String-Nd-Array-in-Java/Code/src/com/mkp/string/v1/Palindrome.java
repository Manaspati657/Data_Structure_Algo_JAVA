package src.com.mkp.string.v1;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("manas"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    private static boolean isPalindrome(String str) {
//      m a n a m
//      0 1 2 3 4
        if(str.isEmpty()) return true;
        else{
            for (int i = 0; i <= str.length()/2; i++) {
                char start=str.charAt(i);
                char end= str.charAt( str.length() - i - 1 );
                if(start != end) return false;
            }
        }

        return true;
    }
}
