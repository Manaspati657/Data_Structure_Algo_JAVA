package src.com.mkp.array.v2.medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
//        int target = 8;
//        int target = 6;
        int target = 9;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int s=0,e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid] > target)
                e=mid-1;
            else if(nums[mid] < target)
                s=mid+1;
            else{
                int start=mid,end=mid;
                while(start-1 >= s && nums[start-1] == target) start--;
                while(end+1 <= e && nums[end+1] == target) end++;
                return new int[]{start,end};
            }

        }


        return new int[]{-1,-1};
    }
}
