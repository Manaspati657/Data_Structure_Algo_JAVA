package src.com.mkp.Sliding_Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString438 {

    /*
    *
    * needs to improve for result .
    *
    * */

    public static void main(String[] args) {

//        String str="forxxorfxdofr",ptr="for";
//        String str="cbaebabacd",ptr="abc";
        String str="abab",ptr="ab";
//        String str="abcdbca",ptr="abc";
        System.out.println(findAnagrams(str,ptr));

    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int i =0 ,j =0 ,n=s.length(),k=p.length();

//       count the occurrences of characters in pat
        Map<Character,Integer> map=new HashMap<>();
        for (int l = 0; l < k; l++) {
            char currentChar=p.charAt(l);
            if(map.containsKey(currentChar))
                map.put(currentChar,map.get(currentChar)+1);
            else
                map.put(currentChar,1);
        }
        System.out.println(map);
        int count=map.size();

        while(j < n){
            int windowSize=j-i+1;
            char currentChar=s.charAt(j);
            // ? calculation on every move ::
            // check the current character is available in map if exist then decrement the occurrence.
            if(map.containsKey(currentChar)){
                map.put(currentChar,map.get(currentChar)-1);
                if(map.get(currentChar) == 0) count--;
            }

            // until we reach the window size we increment the j variable
            if(windowSize < k) j++;

                // ? Slide window
                // if we hit the window size then get the result first and then slide the window

            else if(windowSize == k){
                System.out.println(count);
//                if the count is 0 then we find the anagram in the window size.
                if(count==0) ans.add(i);
                // remove the windows first element calculation
                if(map.containsKey(currentChar)){
                    if(map.get(currentChar) == 0) count++;
                    map.put(currentChar,map.get(currentChar)+1);
                }
                // slide the window
                i++;
                j++;
            }

        }

        return ans;
    }
}
