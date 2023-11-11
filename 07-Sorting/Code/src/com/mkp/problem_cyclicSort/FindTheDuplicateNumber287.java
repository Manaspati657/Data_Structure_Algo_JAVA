package src.com.mkp.problem_cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindTheDuplicateNumber287 {
//    same as 442 only with index not greater than length condition

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
        System.out.println(Arrays.toString(nums));
    }

    // using hasmap we can store the count and iterate through
    //  the map check the count if more than 1 then return
    // Time Complexity: for building hashmap : O(N)
    //                  for checking the count : O(N)
    // O(N+N) = O(N)
    public static int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        for(int i =0;i<nums.length;i++){
            if(map.get(nums[i]) > 1) return nums[i];
        }

        return -1;
    }

    public static int findDuplicate2(int[] nums) {

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
