package src.com.mkp.v2.medium;

import java.util.*;

public class ThreeSum15 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        System.out.println(threeSumV2(nums));
    }

//    optimized approach with two sum combination . TC : O(N^2)
    public static List<List<Integer>> threeSumV2(int[] nums) {
        int n = nums.length;
        // sort(nums,0,n-1);
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        for(int i = 0;i < n-2;i++){
            int sI=i+1,eI=n-1;
            while(sI < eI){
                int sum=nums[i]+nums[sI]+nums[eI];
                if(sum == 0){
                    set.add(Arrays.asList(nums[i],nums[sI],nums[eI]));
                    sI++;
                    eI--;
                }else if(sum > 0){
                    eI--;
                }else{
                    sI++;
                }
            }
        }

        return new ArrayList<>(set);
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



    //brute force approach : TC- O(N^3)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) {
                // Skip duplicates for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    // Skip duplicates for the third element
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Add the triplet to the result list
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        ans.add(triplet);
                    }
                }
            }
        }

        return ans;
    }
}
