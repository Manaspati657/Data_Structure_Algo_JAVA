package src.com.mkp.array.v2.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                ans[0]=i;
                ans[1]=map.get(target-nums[i]);
            }else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }


    /*
    *
    *   Brute force approach : TC - O(N^2).
    *
    * */

    public static int[] twoSumV1(int[] nums, int target) {
        int[] ans=new int[2];

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(i != j && nums[j] == difference){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }
}
