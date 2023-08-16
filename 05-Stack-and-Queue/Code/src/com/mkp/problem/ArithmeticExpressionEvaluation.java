package src.com.mkp.problem;

import src.com.mkp.theory_stack.Stack_Array;

import java.util.Scanner;

public class ArithmeticExpressionEvaluation {

    public static void main(String[] args) {
        Stack_Array<String> operation=new Stack_Array<>();
        Stack_Array<Integer> values=new Stack_Array<>();
        System.out.println("Enter a Arithmetic expression");
        String exp=new Scanner(System.in).next();
        System.out.println(exp);
//      "(1+((2+3)*(4*5)))"

        for (int i = 0; i < exp.length(); i++) {
            if(!String.valueOf(exp.charAt(i)).equals(" ")){
                if (exp.charAt(i) == '(') ;
                else  if (exp.charAt(i) == '+'
                        || exp.charAt(i) == '*'
                        || exp.charAt(i) == '/'
                        || exp.charAt(i) == '-')
                    operation.push(String.valueOf(exp.charAt(i)));
                else if(exp.charAt(i) == ')'){
                    String op=operation.pop();
                    if(op != null){
                        if(op.equals("+")) values.push(values.pop() + values.pop());
                        else if(op.equals("-")) values.push(values.pop() - values.pop());
                        else if(op.equals("*")) values.push(values.pop() * values.pop());
                        else values.push(values.pop() / values.pop());
                    }else{
                        System.out.println("invalid expression");
                    }

                }
                else values.push(Integer.valueOf(String.valueOf(exp.charAt(i))));
//                System.out.println(exp.charAt(i));

            }
        }

        System.out.println(values.pop());

    }
}
