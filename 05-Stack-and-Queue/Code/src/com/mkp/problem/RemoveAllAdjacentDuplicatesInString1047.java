package src.com.mkp.problem;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString1047 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> s1=new Stack<>();
        for (char ch:s.toCharArray()) {
            if(!s1.isEmpty() && s1.peek() == ch) s1.pop();
            else s1.push(ch);
        }
        if(s1.isEmpty()) return "";
        StringBuilder ans=new StringBuilder();
        while(!s1.isEmpty()) {
            ans.append(s1.peek());
            s1.pop();
        }
        return ans.reverse().toString();
    }
}
