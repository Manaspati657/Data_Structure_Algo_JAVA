package src.com.mkp.problem_cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheDuplicateNumber287 {
//    same as 442 only with index not greater than length condition

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int findDuplicate(int[] nums) {

        int i =0 ;
        while (i < nums.length){
            if(nums[i] != nums[nums[i]-1]) exch(nums,i,nums[i]-1);
            else i++;
        }

        List<Integer> list=new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1) return nums[j];
        }
        return nums.length;
    }

    public static void exch(int[] arr,int a , int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
