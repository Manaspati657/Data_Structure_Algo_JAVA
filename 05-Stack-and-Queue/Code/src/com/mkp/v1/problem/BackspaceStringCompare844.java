package src.com.mkp.v1.problem;

import java.util.Stack;

public class BackspaceStringCompare844 {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f","y#f#o##f"));
    }

    // s = "ab#c", t = "ad#c"
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String s){
        Stack<Character> s1=new Stack<>();
        for (char ch: s.toCharArray()) {
            if( ch != '#') s1.push(ch);
            else if(!s1.isEmpty()) s1.pop();
        }
        return String.valueOf(s1);
    }
}
