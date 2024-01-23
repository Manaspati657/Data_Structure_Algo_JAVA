package src.com.mkp.array.easy;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {
    public static void main(String[] args) {
        int[] nums= {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int left=1,right=1;

        for (int i = 0; i < n; i++) {
            ans[i]=left;
            left*=nums[i];
        }

        for (int i = n-1; i >= 0; i--) {
            ans[i]*=right;
            right*=nums[i];
        }

        return ans;
    }

    // Brute force approach : TC : O(n^2)
    public static int[] productExceptSelfV1(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];

        for (int i = 0; i < n; i++) {
            int mul=1;
            for (int j = 0; j < n; j++) {
                if(i != j ) mul*=nums[j];
            }
            ans[i]=mul;
        }

        return ans;
    }
}
