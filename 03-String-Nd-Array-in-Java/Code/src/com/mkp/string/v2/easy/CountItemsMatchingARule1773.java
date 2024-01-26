package src.com.mkp.string.v2.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingARule1773 {
    public static void main(String[] args) {
        List<String> list1= Arrays.asList(new String[]{"phone","blue","pixel"});
        List<String> list2=Arrays.asList(new String[]{"computer","silver","lenovo"});
        List<String> list3=Arrays.asList(new String[]{"phone","gold","iphone"});
        List<List<String>> items =new ArrayList<>();
        items.add(list1);
        items.add(list2);
        items.add(list3);
        String ruleKey = "color", ruleValue = "silver";
        System.out.println(countMatches(items,ruleKey,ruleValue));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans=0,i=0;
        while(i<items.size()){
            if(ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)) ans++;
            if(ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)) ans++;
            if(ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)) ans++;
            i++;
        }
        return ans;
    }
}
