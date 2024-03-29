package src.com.mkp.v1.problem_cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInAnArray442 {

//    same as 448 only get the index element not index+1;

    public static void main(String[] args) {
//       {4,3,2,7,8,2,3,1};
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {

        int i =0 ;
        while (i < nums.length){
            if(nums[i] != nums[nums[i]-1]) exch(nums,i,nums[i]-1);
            else i++;
        }

        List<Integer> list=new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1) list.add(nums[j]);
        }
        return list;
    }

    public static void exch(int[] arr,int a , int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
