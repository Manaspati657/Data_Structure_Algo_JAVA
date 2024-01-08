package src.com.mkp.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String str="abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));

    }
    public static int lengthOfLongestSubstring(String S){
        int ans=0,i=0,j=0,n=S.length();

//        create a map to store the character occurrence.
        Map<Character,Integer> map=new HashMap<>();

        while(j < n){
            char currentChar=S.charAt(j);
//           ? calculation on every move ::
//           add the current character occurrence to the map
            map.put(currentChar,map.getOrDefault(currentChar,0)+1);

//            check if map size is same and window size is same then we find one ans .
            if(map.size() == j-i+1){
                ans=Math.max(ans,j-i+1);
                j++;
            }
//            if map size is less than the window size then there is a duplicate character, so we have
//            to remove character from front of window until our map size is equal as window size.
            else if(map.size() < j-i+1){
                while(map.size() < j-i+1){
                    char frontChar=S.charAt(i);
                    map.put(frontChar,map.get(frontChar)-1);
                    if(map.get(frontChar) == 0) map.remove(frontChar);
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}
