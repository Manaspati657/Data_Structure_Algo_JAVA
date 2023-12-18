package src.com.mkp.AdityaVerma;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }
    public static List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        helper("",s,list);
        return list;
    }

    private static void helper(String op, String ip, List<String> list) {
        if(ip.isEmpty()){
            list.add(op);
            return;
        }

        char currentChar=ip.charAt(0);
//        if(Character.isAlphabetic(currentChar)){
        if((currentChar >= 'a' && currentChar <= 'z') || (currentChar >= 'A' && currentChar <= 'Z') ){
            helper(op+(""+currentChar).toLowerCase(),ip.substring(1),list);
            helper(op+(""+currentChar).toUpperCase(),ip.substring(1),list);
        }else{
            helper((op+currentChar),ip.substring(1),list);
        }
    }
}
