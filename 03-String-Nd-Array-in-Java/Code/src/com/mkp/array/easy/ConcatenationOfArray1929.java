package src.com.mkp.array.easy;

import java.util.Arrays;

public class ConcatenationOfArray1929 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }

    public static int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n*2];
        for(int i = 0 ;i < n*2;i++)
            if(i < n)
                ans[i]=nums[i];
            else
                ans[i]=nums[i%n];
        return ans;
    }

    public static int[] getConcatenationV1(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n*2];
        for(int i = 0 ;i < n;i++)
            ans[i]=nums[i];
        for(int i=n,j=0;i<n*2 && j < n;i++,j++)
            ans[i]=nums[j];
        return ans;
    }
}
