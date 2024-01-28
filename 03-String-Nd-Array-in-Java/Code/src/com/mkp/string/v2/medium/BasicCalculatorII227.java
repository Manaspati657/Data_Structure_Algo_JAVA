package src.com.mkp.string.v2.medium;

import java.util.Stack;

public class BasicCalculatorII227 {
    public static void main(String[] args) {
//        String s = "3+2*2";
//        String s = " 3/2 ";
        String s = "10+2*3-6/3";
//        String s = "   42";
        System.out.println(calculate(s));
    }

    /*
    *
    *  with stack.
    *
    * */
    public static int calculate(String s) {
        int currNum = 0,ans=0;
        char op = '+';
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
//            add how much long number it is in currNum variable
            if (Character.isDigit(c))
                currNum = currNum * 10 + (c - '0');
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (op == '+' || op == '-') {
                    stack.push(op == '-' ? -currNum : currNum);
                } else if (op == '*') {
                    stack.push( stack.pop() * currNum);
                } else if (op == '/') {
                    stack.push( stack.pop() / currNum);
                }
                op = c;
                currNum = 0;
            }
        }
        while(!stack.isEmpty()) ans+=stack.pop();
        return ans;
    }
    public static int calculateV1(String s) {
        int ans = 0;
        int currNum = 0;
        int prevNum = 0;
        char op = '+';

        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
//            add how much long number it is in currNum variable
            if (Character.isDigit(c))
                currNum = currNum * 10 + (c - '0');
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (op == '+' || op == '-') {
                    ans += prevNum;
                    prevNum = op == '+' ? currNum : -currNum;
                } else if (op == '*') {
                    prevNum *= currNum;
                } else if (op == '/') {
                    prevNum /= currNum;
                }
                op = c;
                currNum = 0;
            }
        }

        return ans + prevNum;
    }
}
