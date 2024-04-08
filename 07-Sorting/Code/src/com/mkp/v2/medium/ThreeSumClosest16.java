package src.com.mkp.v2.medium;

public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length,min=Integer.MAX_VALUE,ans=Integer.MAX_VALUE;
        sort(nums,0,n-1);
        for(int i = 0 ; i < n-2;i++){
            int n2 = i+1,n3=n-1;
            while(n2 < n3){
                int sum = nums[i]+nums[n2]+nums[n3];
                int diffToTarget=Math.abs(target-sum);
                if(diffToTarget < min){
                    min = diffToTarget ;
                    ans=sum;
                }
                if(sum > target){
                    n3--;
                }else if(sum < target){
                    n2++;
                }else{
                    return sum;
                }
            }
        }

        return ans;
    }

    private void sort(int[] arr,int s , int e){
        if(s >= e) return;
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
