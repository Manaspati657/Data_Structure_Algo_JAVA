package src.com.mkp.problem_cyclicSort;

import java.util.Arrays;

public class MissingNumber268 {

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int missingNumber(int[] nums) {

        int i=0;
        while(i< nums.length){
            if(nums[i] < nums.length && nums[i] != i) exch(nums,nums[i],i);
            else i++;
        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j) return j;
        }


        return nums.length;
    }

    public static void exch(int[] arr,int a , int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
