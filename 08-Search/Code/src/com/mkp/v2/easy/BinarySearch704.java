package src.com.mkp.v2.easy;

public class BinarySearch704 {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }

    public static int search(int[] nums, int target) {
        int s = 0 , e = nums.length-1;
        while(s <= e){
            int mid = s +(e-s)/2;
            if(nums[mid] == target) return mid;
            else if(target < nums[mid]) e=mid-1;
            else s=mid+1;
        }
        return -1;
    }
}
