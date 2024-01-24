package src.com.mkp.v1.binary_Search_problems;

public class SearchInsertPosition35 {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int s=0,e=nums.length-1;
        if(target > nums[e]) return e+1;
        while( s <= e){
            int mid=e+(s-e)/2;
            if(nums[mid] > target) e= mid-1;
            else if(nums[mid] < target) s= mid+1;
            else return mid;
        }

        return s;
    }
}
