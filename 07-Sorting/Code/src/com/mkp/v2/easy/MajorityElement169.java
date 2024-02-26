package src.com.mkp.v2.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

//    without using any extra space using sorting after that we just
    public int majorityElementV2(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length/2];
    }

    public void quickSort(int[] nums,int l,int r){
        if(l >= r) return;
        int pivotIndex=l+(r-l)/2,pivot=nums[pivotIndex], s=l,e=r ;
        while( s <= e){
            while( nums[s] < pivot) s++;
            while( nums[e] > pivot) e--;
            if(s <= e){
                // swap
                int temp=nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;
                e--;
            }
        }

        quickSort(nums,l,e);
        quickSort(nums,s,r);

    }



//    using extra space hashmap. running time : 12ms
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int el:nums){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        for(Integer el:map.keySet()){
            if(map.get(el) > nums.length/2) return el;
        }
        return nums[0];
    }
}
