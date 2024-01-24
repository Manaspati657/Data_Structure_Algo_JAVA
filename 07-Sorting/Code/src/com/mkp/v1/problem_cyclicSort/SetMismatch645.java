package src.com.mkp.v1.problem_cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMismatch645 {
    public static void main(String[] args) {
//        int[] nums = {1,2,2,4}; //[2,3]
        int[] nums = {2,2}; //[0,1]
        System.out.println(Arrays.toString(findErrorNums(nums)));
        System.out.println(Arrays.toString(nums));
    }

    public static int[] findErrorNums(int[] nums) {
        int i=0;
        while(i < nums.length){
            if (nums[i] != nums[nums[i] - 1]) {
                exch(nums, i , nums[i] - 1);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1) {
               return new int[]{nums[j],j+1};
            }
        }


        return new int[]{-1,-1};
    }

    public static void exch(int[] arr,int a , int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
