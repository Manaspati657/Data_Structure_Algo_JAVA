package src.com.mkp.v2.easy;

import java.util.Stack;

public class ValidParentheses20 {

    public static void main(String[] args) {
        String s = "()[]{}";
//        String s = "()";
//        String s = "(";
        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && (ch == ')' || ch == ']' || ch == '}')){
                if(ch == ')' && stack.peek() != '(') return false;
                else if(ch == '}' && stack.peek() != '{') return false;
                else if(ch == ']' && stack.peek() != '[') return false;
                stack.pop();
            }else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
