package src.com.mkp.v1.binary_Search_problems;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray34 {

//    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,8,8,9,10};
        int target=8;
        System.out.println(Arrays.toString(searchRange2(arr,target)));

    }

    public static int[] searchRange(int[] nums, int target) {
        int s=0,e=nums.length-1;
        // if(target > nums[nums.length-1]) return new int[]{-1,-1};
        while( s <= e){
            int mid=e+(s-e)/2;
            if(nums[mid] > target) e= mid-1;
            else if(nums[mid] < target) s= mid+1;
            else {
                s=mid;e=mid;
                while(s != nums.length-1 && nums[s+1] == target) s++;
                while(e != 0 && nums[e-1] == target) e--;
                return new int[]{e,s};
            };
        }

        return new int[]{-1,-1};
    }
    public static int[] searchRange2(int[] nums, int target) {
        int[] ans={-1,-1};

        // check for first occurrence if target first (means get the first starting index)
        ans[0] = search(nums, target, true);
        if (ans[0] != -1) {
            // check for 2nd occurrence if target last (means get the last end index)
            ans[1] = search(nums, target, false);
        }


        return ans;
    }
    // this function just returns the index value of target
    public static int search(int[] nums, int target, boolean findStartIndex) {
        int ans=-1;

        int s=0,e=nums.length-1;
        if(target > nums[e]) return e+1;
        while( s <= e){
            int mid=e+(s-e)/2;
            if(nums[mid] > target) e= mid-1;
            else if(nums[mid] < target) s= mid+1;
            else {
                ans=mid;
                if(findStartIndex){
                    e=mid-1;
                }else {
                    s=mid+1;
                }
            }
        }

        return ans;
    }
}
