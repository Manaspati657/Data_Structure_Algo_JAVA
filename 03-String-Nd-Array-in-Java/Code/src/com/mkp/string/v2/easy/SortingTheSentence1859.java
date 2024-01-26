package src.com.mkp.string.v2.easy;

import java.util.HashMap;
import java.util.Map;

public class SortingTheSentence1859 {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }

    public static String sortSentence(String s) {
        Map<Integer,String> sMap=new HashMap<>();
        int sI=0,eI=0;
        // using hashmap store index with respective index word
        while(eI< s.length()){
            if(Character.isDigit(s.charAt(eI))){
                sMap.put((int)s.charAt(eI),  s.substring(sI, eI));
                sI=eI+2;
                eI=eI+2;
            }else{
                eI++;
            }
        }
        String[] strArr=new String[sMap.size()];
        // store word in their respective indexes.
        // note : when we convert char to int then character ASCII value will be store, so we subtract
        //        1 ASCII value (i.e. 49) from the index.
        for (Integer e : sMap.keySet()) {
            strArr[e-49]=sMap.get(e);
        }
        System.out.println();
        StringBuilder ans=new StringBuilder();
        // store it in StringBuilder class
        for (int i = 0; i < strArr.length; i++) {
            ans.append(strArr[i]);
            if(i+1 < strArr.length) ans.append(" ");
        }

        return ans.toString();
    }
}
