package src.com.mkp.v2.easy;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        int sI=0,eI=nums.length-1;
        if(target < nums[0]) return 0;
        if(target > nums[eI]) return eI+1;
        while(sI <= eI){
            int mid=sI+(eI-sI)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) sI=mid+1;
            else eI=mid-1;
        }

        return sI ;
    }
}
