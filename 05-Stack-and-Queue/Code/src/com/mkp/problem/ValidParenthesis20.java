package src.com.mkp.problem;

import src.com.mkp.theory_stack.Stack_Array;

import java.util.Scanner;

public class ValidParenthesis20 {
    public static void main(String[] args) {
        System.out.println("Enter Parenthesis::");
        String str=new Scanner(System.in).next();
        System.out.println("is Valid :: "+isValid(str));
    }
    public static boolean isValid(String str){
        Stack_Array<Character> parenthesis=new Stack_Array<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(' ||
                    str.charAt(i) == '{' ||
                    str.charAt(i) == '[')
                parenthesis.push(str.charAt(i));
            else if(!parenthesis.isEmpty() &&  (str.charAt(i) == ')' ||
                    str.charAt(i) == '}' ||
                    str.charAt(i) == ']')){
                if(str.charAt(i) == ')' && parenthesis.peek() == '(') parenthesis.pop();
                else if(str.charAt(i) == '}' && parenthesis.peek() == '{') parenthesis.pop();
                else if(str.charAt(i) == ']' && parenthesis.peek() == '[') parenthesis.pop();
                else return false;
            }
            else return false;
        }
        return parenthesis.isEmpty();
    }
}
