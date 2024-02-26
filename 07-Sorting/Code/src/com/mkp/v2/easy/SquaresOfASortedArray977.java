package src.com.mkp.v2.easy;

public class SquaresOfASortedArray977 {

/* without using sort*/
    public int[] sortedSquaresV2(int[] nums) {
        int n = nums.length;
        int[] ans=new int[n];
        int i = 0 ,j = n-1,k=n-1;
        while(i < n && k >= 0 && j >= 0){
            if(Math.abs(nums[i]) > Math.abs(nums[j]))
                ans[k--]= nums[i]*nums[i++];
            else
                ans[k--]= nums[j]*nums[j--];
        }
        return ans;
    }

    /*using sort */
    public int[] sortedSquares(int[] nums) {
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[i]*nums[i];
        }
        sort(ans,0,nums.length-1);
        return ans;
    }
    public void sort(int[] arr,int s ,int e){
        if(s >= e) return;
        int pivotIndex=s+(e-s)/2,pivot=arr[pivotIndex],l=s,r=e;
        while(l <= r){
            while(arr[l] < pivot) l++;
            while(arr[r] > pivot) r--;

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
