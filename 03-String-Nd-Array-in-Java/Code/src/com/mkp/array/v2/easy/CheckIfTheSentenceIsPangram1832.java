package src.com.mkp.array.v2.easy;

import java.util.HashMap;
import java.util.Map;

public class CheckIfTheSentenceIsPangram1832 {

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        //   boolean[] letters  = new boolean[26];

        // for(char c : sentence.toCharArray()) {
        //     letters[c - 'a'] = true;
        // }

        // //find any letter that not exist
        // for(boolean existLetter : letters) {
        //     if(!existLetter) return false;
        // }

        // return true;
        Map<Character,Integer> map=new HashMap<>();
        if(sentence.length() < 26) return false;
        for(int i =0 ;i<sentence.length();i++){
            char currentChar=sentence.charAt(i);
            map.put(currentChar,map.getOrDefault(currentChar,0)+1);
        }
        return map.size() == 26;
    }
}
