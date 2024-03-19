package src.com.mkp.v2.easy;

import java.util.Arrays;

public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        sort(sortedNums,0,n-1);
        int l=0,r=n-1;
        while(l<r){
            int sum = sortedNums[l]+sortedNums[r];
            if(sum == target){
                break;
            }else if(sum < target){
                l++;
            }else if(sum > target){
                r--;
            }
        }
        int index1 = -1 ,index2= -1;
        for(int i = 0;i < n;i++){
            if(index1 == -1 && nums[i] == sortedNums[l])
                index1=i;
            else if(index2 == -1 && nums[i] == sortedNums[r])
                index2=i;
        }
        return new int[]{index1,index2};
    }
    public void sort(int[] arr,int s , int e){
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
