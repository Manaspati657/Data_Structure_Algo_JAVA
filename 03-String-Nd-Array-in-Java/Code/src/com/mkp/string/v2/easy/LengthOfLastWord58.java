package src.com.mkp.string.v2.easy;

public class LengthOfLastWord58 {
    public static void main(String[] args) {
//        String s = "   fly me   to   the moon  ";
//        String s = "luffy is still joyboy";
//        String s = "a";
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int length=0,n=s.length();
        for (int i = n-1; i >= 0 ; i--) {
            if(s.charAt(i) != ' ') {
                length++;
            }else {
                if(length > 0) return length;
            }
        }
        return length;
    }
}
