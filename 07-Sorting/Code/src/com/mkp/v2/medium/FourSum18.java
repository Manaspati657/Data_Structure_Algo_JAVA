package src.com.mkp.v2.medium;


import java.util.*;

public class FourSum18 {


//    using two sum approach
public List<List<Integer>> fourSumV3(int[] nums, int target) {
    int n = nums.length;
    if(n < 4) return new ArrayList<>();
    Arrays.sort(nums);
    List<List<Integer>> result=new ArrayList<>();
    for(int i = 0 ;i < n-3 ; i++){
        if(i > 0 && nums[i] == nums[i-1]) continue;
        for(int j = i+1 ; j < n-2;j++){
            if(j > i+1 && nums[j] == nums[j-1]) continue;
            //two sum problem
            int k = j+1,l=n-1;
            while(k < l){
                int left=nums[i]+nums[j],right=nums[k]+nums[l];
                long sum = (long)left+(long)right;
                if(sum < target){
                    k++;
                }else if( sum > target){
                    l--;
                }else{
                    result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                    k++;
                    l--;

                    while(k < l && nums[k] == nums[k-1]) k++;
                    while(k < l && nums[l] == nums[l+1]) l--;
                }
            }
        }
    }

    return result;
}

//    using three sum problem
    public List<List<Integer>> fourSumV2(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0 ;i < n-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            threeSum(nums,i+1,n-1,target - nums[i],result);
        }
        return result;
    }

    private void threeSum(int[] nums, int lo, int hi, int target, List<List<Integer>> result) {
        for (int i = lo; i <= hi; ++i) {
            if (i > lo && nums[i] == nums[i - 1]) continue;  // skip same result
            // two pointers
            int j = i + 1, k = hi;
            int t = target - nums[i];
            while (j < k) { // each element is only used once
                if (nums[j] + nums[k] < t) {
                    ++j;
                } else if (nums[j] + nums[k] > t) {
                    --k;
                } else { // equal
                    result.add(Arrays.asList(nums[lo - 1], nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                }
            }
        }
    }




//    Brute force approach
public List<List<Integer>> fourSum(int[] nums, int target) {
    Set<List<Integer>> set=new HashSet<>();
    int n = nums.length;
    sort(nums,0,n-1);
    for(int i = 0 ;i < n - 3 ; i++){
        for(int j = i+1; j < n - 2 ; j++){
            for(int k = j+1; k < n -1 ; k++){
                for(int l = k+1; l < n ; l++){
                    if((nums[i]+nums[j]+nums[k]+nums[l]) == target){
                        set.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                    }
                }
            }
        }
    }

    return new ArrayList<>(set);
}

    private void sort(int[] arr,int s,int e){
        if(s >= e) return ;
        int pI=s+(e-s)/2,p=arr[pI],l=s,r=e;

        while(l <= r){
            while(arr[l] < p) l++;
            while(arr[r] > p) r--;

            if(l <= r){
                //swap
                int temp=arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

                l++;
                r--;
            }
        }

        sort(arr,s,r);
        sort(arr,l,e);
    }
}
