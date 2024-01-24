package src.com.mkp.v1.problem_cyclicSort;

import java.util.Arrays;

public class FirstMissingPositive41 {

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int firstMissingPositive(int[] nums) {

        int i=0;
        while(i < nums.length){
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]){
                exch(nums,i,nums[i]-1);
            } else{
                i++;
            }
        }


        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1) return j+1;
        }


        return nums.length+1;
    }

    public static void exch(int[] arr,int a , int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
