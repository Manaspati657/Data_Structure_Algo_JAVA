package src.com.mkp.v2.easy;

public class MaximumProductOfTwoElementsInAnArray1464 {

    public static void main(String[] args) {
//        int[] nums = {3,4,5,2};
        int[] nums = {1,5,4,5};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        if(n > 2 ) sort(nums,0,n-1);
        int max=(nums[n-1]-1) * (nums[n-2]-1);
        return max;
    }

    public static void sort(int[] arr,int s,int e){
        if(s >= e) return ;
        int pI=s+(e-s)/2,p=arr[pI],l=s,r=e;
        while(l <= r){
            while(arr[l] < p) l++;
            while(arr[r] > p) r--;

            if(l <= r){
                //swap
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;

                l++;
                r--;
            }
        }

        sort(arr,s,r);
        sort(arr,l,e);
    }
}
