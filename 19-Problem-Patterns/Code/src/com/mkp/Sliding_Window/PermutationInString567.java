package src.com.mkp.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString567 {

    public static void main(String[] args) {
//        String s1 = "ab", s2 = "eidbaooo";
        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(checkInclusion(s1,s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.isEmpty()) return true;
        int k=s1.length();
        Map<Character,Integer> map=new HashMap<>();
        for(int i = 0 ;i<k;i++){
            char currentChar=s1.charAt(i);
            map.put(currentChar,map.getOrDefault(currentChar,0)+1);
        }
        System.out.println(map);
        int l=0,m=0,n=s2.length(),count=map.size();
        while(m < n){
            char currentChar=s2.charAt(m);
            if(map.containsKey(currentChar)){
                map.put(currentChar,map.get(currentChar)-1);
                if(map.get(currentChar) == 0) count--;
            }

            if(m-l+1 < k ){
                m++;
            }else if(m-l+1 == k ){
                if(count == 0 ) return true;
                char frontChar=s2.charAt(l);
                if(map.containsKey(frontChar)){
                    map.put(frontChar,map.get(frontChar)+1);
                    if(map.get(frontChar) == 1) count++;
                }
                l++;
                m++;
            }
        }

        return false;
    }
}
