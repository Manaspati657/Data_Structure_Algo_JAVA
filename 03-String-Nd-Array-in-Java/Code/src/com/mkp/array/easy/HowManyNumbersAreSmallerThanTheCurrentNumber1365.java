package src.com.mkp.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyNumbersAreSmallerThanTheCurrentNumber1365 {
    public static void main(String[] args) {
//        int[] nums = {8,1,2,2,3};
        int[] nums = {8,8,8,8,8};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }
    /*
    *  for optimizing the solution we need to sort the array and store in map that element index .
    *  Time complexity: O(N log N)
    *
    *   Note : while storing sorting element index in map we have iterated the array from last so that the
    *          repeating element ans will modify in last element of the repeating element.
    *
    * */

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] sortNums=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
//      Time complexity : O(N)
        for (int i = 0; i < n; i++) {
            sortNums[i]=nums[i];
        }
//        Time complexity : O(NlogN)
        Arrays.sort(sortNums);

//        Time complexity : O(N)
        for (int i = n-1; i >= 0; i--) {
            map.put(sortNums[i],i);
        }

        //        Time complexity : O(N)
        for (int i = 0; i < n; i++) {
           nums[i]=map.get(nums[i]);
        }

        return nums;
    }


    /*
    *  Brute force approach : Time complexity O(N^2)
    * */
    public static int[] smallerNumbersThanCurrentV1(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for (int i = 0; i < n; i++) {
            int count=0;
            for (int j = 0; j < n; j++) {
                if(i != j && nums[i] > nums[j]) count++;
            }
            ans[i]=count;
        }

        return ans;
    }
}
