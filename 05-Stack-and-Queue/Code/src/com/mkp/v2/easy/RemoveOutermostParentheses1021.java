package src.com.mkp.v2.easy;

import java.util.Stack;

public class RemoveOutermostParentheses1021 {

    public static void main(String[] args) {
        String  s = "(()())(())(()(()))";
        System.out.println(removeOuterParenthesesV1(s));
    }

//    optimized approach but tricky one dry run you can understand the approach.

    public static String removeOuterParenthesesV1(String s) {
        StringBuilder ans=new StringBuilder();
        int count=0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch=s.charAt(i);
            if(ch == '(' && count++ > 0) ans.append(ch);
            if(ch == ')' && count-- > 1) ans.append(ch);
        }
        return ans.toString();
    }


//    with extra space using stack.
    public static String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch=s.charAt(i);
            if(ch == '(' ){
                if(!stack.isEmpty()){
                    ans.append("(");
                }
                stack.push(ch);
            }else {
                stack.pop();
                if(!stack.isEmpty()){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}
