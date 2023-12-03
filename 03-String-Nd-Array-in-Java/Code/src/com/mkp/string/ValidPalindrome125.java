package src.com.mkp.string;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("manas"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;

        int head=0,tail=s.length()-1;

        while(head <= tail){
            char cHead=s.charAt(head),cTail=s.charAt(tail);
            // skip if space comes
            if(!Character.isLetterOrDigit(cHead)) head++;
            else if(!Character.isLetterOrDigit(cTail)) tail--;
            else {
                if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail))
                    return false;
                head++;
                tail--;
            }
        }
        return true;
    }
}
