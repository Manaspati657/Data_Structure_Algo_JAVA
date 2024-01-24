package src.com.mkp.v1.AdityaVerma;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

    /*
    *
    *  problem statement:
    *    Given n pairs of parentheses, write a function to generate all combinations of well-formed
    *    parentheses.
    *
    *    for valid parentheses we have two choice we can take "(" and ")" ,but we have to think when take
    *    a close bracket if already open bracket is there then we can take the close bracket.
    *
    *    Note : Draw recursion tree then see what is the condition we can take for close bracket.
    *
    * */
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper("",n,n,list);
        return list;
    }

    private static void helper(String op,int ob, int cb, List<String> list) {
        if(ob == 0 && cb == 0){
            list.add(op);
            return;
        }
//        for open bracket we don't have to think any think
        if(ob > 0 ) helper(op+"(",ob-1,cb,list);
//        if op bracket balance is less then the close bracket then only we can add a close bracket.
        if(cb > 0 && ob < cb)
            helper(op+")",ob,cb-1,list);
    }
}
