package src.com.mkp.v2.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate217 {


//    without using any extra space . using quick sort . running time : 21ms

    public boolean containsDuplicateV2(int[] nums) {
        quickSort(nums,0,nums.length-1);
        for(int i = 0 ; i < nums.length-1;i++)
            if(nums[i] == nums[i+1]) return true;
        return false;
    }

    public void quickSort(int[] arr,int s,int e){
        if(s>=e) return;
        int pivotIndex=s+(e-s)/2,pivot=arr[pivotIndex],l=s,r=e;
        while(l <= r){
            while(arr[l] < pivot) l++;
            while(arr[r] > pivot) r--;
            if(l<=r){
                //swap
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;

                l++;
                r--;
            }
        }

        quickSort(arr,s,r);
        quickSort(arr,l,e);
    }



    //    using extra space hashmap . running time 19ms
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int el : nums) {
            map.put(el, map.getOrDefault(el, 0) + 1);
            if (map.get(el) == 2) return true;
        }

        return false;
    }
}
