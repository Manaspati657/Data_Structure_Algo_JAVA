package src.com.mkp.v2.medium;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid921 {

    /*
    * Without using stack : while we find a close bracket then we check if open bracket is already there
    * then we decrease the open bracket otherwise we increase what ever we found open or close.
    * */

    public int minAddToMakeValidV2(String s) {
        int open=0,close=0;
        for(Character ch : s.toCharArray()){
            if(ch == ')'){
                if(open > 0) open--;
                else close++;
            }else{
                open++;
            }
        }
        return open+close;
    }


    /*
    * Using a stack: Approach: when ever we have a close bracket then we find the top of stack if it
    * has an opening bracket or not if we find that then we removed the open bracket otherwise just
    * add every bracket.
    * */
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(Character ch:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == '(' && ch == ')')
                stack.pop();
            else
                stack.push(ch);
        }
        return stack.size();
    }
}
