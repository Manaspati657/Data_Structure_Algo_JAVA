package src.com.mkp.v2.medium;

import java.util.*;

public class GroupAnagrams49 {

    //using character frequency
    public List<List<String>> groupAnagramsV2(String[] strs) {
        if(strs.length == 0 ) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String frequencyStr=getFrequencyStr(str);
            if (map.containsKey(frequencyStr)) {
                map.get(frequencyStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(frequencyStr, list);
            }
        }
        for (Map.Entry<String, List<String>> stringAnagrams : map.entrySet()) {
            result.add(stringAnagrams.getValue());
        }
        return result;
    }

    private String getFrequencyStr(String str){
        int[] charArr=new int[26];
        for(char ch:str.toCharArray()){
            charArr[ch - 'a']++;
        }
        char character='a';
        StringBuilder sb=new StringBuilder();
        for(int el:charArr){
            sb.append(character);
            sb.append(el);
            character++;
        }
        return sb.toString();
    }

    //    using sorting approach
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = String.valueOf(charArr);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }
        for (Map.Entry<String, List<String>> stringAnagrams : map.entrySet()) {
            result.add(stringAnagrams.getValue());
        }
        return result;
    }
}
