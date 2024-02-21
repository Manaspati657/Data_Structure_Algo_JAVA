package src.com.mkp.v2.easy;

public class ReverseString344_recursive {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(new String(s));
    }

    public static void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }

    private static void helper(char[] str,int s, int e){
        if(s >= e) return;
        char temp=str[s];
        str[s]=str[e];
        str[e]=temp;
        helper(str,s+1,e-1);
    }

}
