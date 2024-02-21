package src.com.mkp.v2.easy;

public class BinarySearch704_recursion {


    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }


    public static int search(int[] nums, int target) {
        return helper(nums,target,0,nums.length-1);
    }
    public static int helper(int[] nums,int target,int s,int e){
        if(s > e) return -1;
        int mid=s+(e-s)/2;
        if(nums[mid] == target)
            return mid;
        else if(target < nums[mid])
            return helper(nums,target,s,mid-1);
        else
            return helper(nums,target,mid+1,e);
    }
}
