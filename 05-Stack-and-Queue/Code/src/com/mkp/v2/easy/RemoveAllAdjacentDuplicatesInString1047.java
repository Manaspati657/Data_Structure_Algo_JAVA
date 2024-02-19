package src.com.mkp.v2.easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString1047 {

    public String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        for(Character ch:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == ch)
                stack.pop();
            else
                stack.push(ch);
        }

        if(stack.isEmpty()) return "";
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty())
            ans.append(stack.pop());
        return ans.reverse().toString();
    }
}
