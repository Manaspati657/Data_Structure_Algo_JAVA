package src.com.mkp.v2.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII350 {

    // using extra space hash table
    public int[] intersectV2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int el : nums1) map.put(el, map.getOrDefault(el,0)+1);

        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer el : nums2) {
            if (map.containsKey(el) && map.get(el) > 0 ){
                ans.add(el);
                map.put(el,map.get(el)-1);
                if(map.get(el) == 0) map.remove(el);
            }
        }

        int[] ansArr = new int[ans.size()];
        for (int i = 0; i < ansArr.length; i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }


    // using extra space array .
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] numbers = new int[1001];
        for (int el : nums1) {
            //we will true the numbers that is nums1
            numbers[el]++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int el : nums2) {
            if (numbers[el] != 0) {
                list.add(el);
                numbers[el]--;//once we find the intersection number we make it false for no duplicate add.
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
