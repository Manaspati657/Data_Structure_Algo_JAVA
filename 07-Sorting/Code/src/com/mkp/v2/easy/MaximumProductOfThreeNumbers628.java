package src.com.mkp.v2.easy;

public class MaximumProductOfThreeNumbers628 {
    public int maximumProduct(int[] nums) {
        int n = nums.length, product=1;
        sort(nums,0,n-1);
        int max1=nums[0]*nums[1]*nums[n-1];
        int max2=nums[n-3]*nums[n-2]*nums[n-1];
        return Math.max(max1, max2);
    }

    public void sort(int[] arr,int s,int e){
        if(s > e) return;
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

        sort(arr,s,r);
        sort(arr,l,e);
    }
}
