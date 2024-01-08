package src.com.mkp.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class LongestKUniqueCharactersSubstring_gfg {
    public static void main(String[] args) {
        String s="aabacbebebe";
        int k=3;
        System.out.println(longestKSubStr(s,k));
    }
    public static int longestKSubStr(String s, int k) {
        int ans=0,i=0,j=0,n=s.length();
        Map<Character,Integer> map=new HashMap<>();

        while(j< n){
            char currentChar=s.charAt(j);
            // ? calculation on every move ::
            // add the current character occurrence to the map
            map.put(currentChar,map.getOrDefault(currentChar,0)+1);

//          In this problem windows size k and the condition for checking the window size is map size if
//          map size is equal k then we find one result .
            if(map.size() < k ) j++;
//           if we hit the window size then store the result and move j for any other long window
            else if(map.size() == k){
                int windowSize=j-i+1;
                ans=Math.max(ans,windowSize);
                j++;
            }
//          if we overlap the window size then we have to remove character occurrences from window front
//          and if occurrence count is 0 then remove that character from the map. Checking this condition
//          until the window size > k .
            else if(map.size() > k){
                while(map.size() > k){
                    char frontChar=s.charAt(i);
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
