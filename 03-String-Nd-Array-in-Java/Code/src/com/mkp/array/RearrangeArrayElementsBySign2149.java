package src.com.mkp.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RearrangeArrayElementsBySign2149 {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }
    public static int[] rearrangeArray(int[] nums) {
        Queue<Integer> positive=new LinkedList<>();
        Queue<Integer> negative=new LinkedList<>();
        for(int i=0;i < nums.length;i++){
            if(nums[i] < 0) negative.add(nums[i]);
            if(nums[i] > 0) positive.add(nums[i]);
        }
        System.out.println(positive);
        System.out.println(negative);
        int[] ans=new int[nums.length];
        for(int i=0;i < nums.length;i++){
            if(i%2 == 0){
                ans[i]=positive.remove();
            }else{
                ans[i]=negative.remove();
            }
        }
        return ans;
    }

//    without extra space ,Time complexity: O(N)
    public int[] rearrangeArrayV2(int[] nums) {
        int l=nums.length,p=0,n=1;
        int[] ans=new int[l];
        for(int i=0;i<l;i++){
            if(nums[i] > 0){
                ans[p]=nums[i];
                p+=2;
            }
            else{
                ans[n]=nums[i];
                n+=2;
            }
        }
        return ans;
    }
}
