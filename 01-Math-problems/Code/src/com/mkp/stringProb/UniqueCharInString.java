package src.com.mkp.stringProb;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharInString {
    public static void main(String[] args) {

//        NullPointerException.
//        String str=null;
//        System.out.println(str.toString());


//
//        String str="manasa";
//        System.out.println("count unique:: "+uniqueChar(str));
    }

    static int  uniqueChar(String str){
        Set<Character> charSet=new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            charSet.add(str.charAt(i));
        }
        return charSet.size();
    }

}
