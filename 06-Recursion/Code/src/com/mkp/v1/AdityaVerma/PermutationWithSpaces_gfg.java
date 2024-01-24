package src.com.mkp.v1.AdityaVerma;

import java.util.ArrayList;

public class PermutationWithSpaces_gfg {

    /*
    *
    * Problem statement:
    *    Given a string you need to print all possible strings that can be made by placing spaces (zero or one)
    *    in between them. The output should be printed in sorted increasing order of strings.
    *
    *    e.g. s="abc" op: abc a bc ab c a b c
    *
    * */

    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }


    public static ArrayList<String> permutation(String S){
        // Code Here
        ArrayList<String> list =new ArrayList<>();
        helper(""+S.charAt(0),S.substring(1),list);
        return list;
    }

    private static void helper(String op, String ip, ArrayList<String> list) {
        if(ip.isEmpty()){
            list.add(op);
            return;
        }

        helper(op+" "+ip.charAt(0),ip.substring(1),list);
        helper(op+ip.charAt(0),ip.substring(1),list);
    }
}
