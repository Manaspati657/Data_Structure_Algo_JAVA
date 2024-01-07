package src.com.mkp.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagrams_gfg {
    public static void main(String[] args) {

//        String str="forxxorfxdofr",ptr="for";
        String str="abab",ptr="ab";
//        String str="abcdbca",ptr="abc";
        System.out.println(search(ptr,str));

    }

    public static int search(String pat, String txt) {
        int ans=0,i =0 ,j =0 ,n=txt.length(),k=pat.length();

//       count the occurrences of characters in pat
        Map<Character,Integer> map=new HashMap<>();
        for (int l = 0; l < k; l++) {
            char currentChar=pat.charAt(l);
            if(map.containsKey(currentChar))
                map.put(currentChar,map.get(currentChar)+1);
            else
                map.put(currentChar,1);
        }
//        System.out.println(map);
        int count=map.size();

        while(j < n){
            int windowSize=j-i+1;
            char currentChar=txt.charAt(j);
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
//                if the count is 0 then we find the anagram in the window size.
                if(count==0) ans+=1;
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
