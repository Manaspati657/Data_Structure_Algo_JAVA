package src.com.mkp.array.v2.easy;

import java.util.Arrays;

public class BuildArrayFromPermutation1920 {

    /*
     *   Important : using technique to store two values at same index (this technique is important)
     *
     * */

    public static void main(String[] args) {
//        int[] nums = {5,0,1,2,3,4};
        int[] nums = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray(nums)));
    }

    /*
    *   optimize approach : using technique to store two values at same index
    *   Example - Lets say we have two numbers in the array a = 1 , b = 3 and the size of
    *             the array is n = 5
    *             We can store both in "a" as :-
    *             a = a + b * n
    *             To get initial value of "a" do a%n
    *             To get the value of "b" we do a/n
    *             a = a + b * n = 1 + 3*5 = 16
    *             a % n = 16 % 5 = 1
    *             a / n = 16 / 5 = 3
    *
    * */
    public static int[] buildArray(int[] nums) {
        int n = nums.length;
//       while storing two value at same index also we nums[nums[i]]%n because may be that index value is
//       calculated value.
        for(int i = 0;i < n;i++)
            nums[i]=nums[i]+((nums[nums[i]]%n)*n);
        for(int i = 0;i < n;i++)
            nums[i] = nums[i]/n;
        return nums;
    }



//   Brute force approach with Space complexity: O(N)
    public static int[] buildArrayV1(int[] nums) {
        int n = nums.length;
        int[] ans=new int[n];
        for(int i = 0;i < n;i++)
            ans[i]=nums[nums[i]];
        return ans;
    }
}
