package src.com.mkp.array.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NumberOfGoodPairs1512 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairsV1(nums));
    }

    /*
    *
    *  optimize approach with some space complexity but need formula (count*(count-1))/2;
    *
    * */
    public static int numIdenticalPairs(int[] nums) {
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        System.out.println(map);
        int i =0 ;
        Set<Integer> keys=map.keySet();
        for (Integer no:keys) {
            Integer count=map.get(no);
            ans+=(count*(count-1))/2;
        }
        
        return ans;
    }

    /*
    *  Brute force approach : Time complexity O(N ^ 2)
    *
    * */

    public static int numIdenticalPairsV1(int[] nums) {
        int goodPair = 0,n=nums.length;

        for (int i = 0; i <n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[i] == nums[j]){
                    goodPair++;
                }
            }
        }


        return goodPair;
    }
}
