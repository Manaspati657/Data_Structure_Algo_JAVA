package src.com.mkp.v2.easy;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class IntersectionOfTwoArrays349 {

    //    using only extra space only one array
    public int[] intersectionV2(int[] nums1, int[] nums2) {
        boolean[] numbers = new boolean[1001];
        for (int el : nums1) {
            //we will true the numbers that is nums1
            numbers[el] = true;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int el : nums2) {
            if (numbers[el]) {
                list.add(el);
                numbers[el] = false;//once we find the intersection number we make it false for no duplicate add.
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    //    using extra space hash map
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int el : nums1) map1.put(el, 0);
        for (int el : nums2) map2.put(el, 0);

        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer el : map1.keySet()) {
            if (map2.containsKey(el)) ans.add(el);
        }

        int[] ansArr = new int[ans.size()];
        for (int i = 0; i < ansArr.length; i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;

    }
}
