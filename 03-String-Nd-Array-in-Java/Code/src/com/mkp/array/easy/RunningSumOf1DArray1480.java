package src.com.mkp.array.easy;

import java.util.Arrays;

public class RunningSumOf1DArray1480 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        if(n < 2) return nums;
        for(int i = 1;i<n;i++)
            nums[i]+=nums[i-1];
        return nums;
    }
}
