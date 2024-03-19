package src.com.mkp.v2.easy;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifference1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        sort(arr,0,n-1);
        int minDiff=Integer.MAX_VALUE;
        for(int i = 1 ; i < n ; i++){
            minDiff=Math.min(minDiff,Math.abs(arr[i]-arr[i-1]));
        }
        List<List<Integer>> ans=new ArrayList<>();

        for(int i = 1 ; i < n ; i++){
            if(minDiff == Math.abs(arr[i]-arr[i-1])){
                List<Integer> subList=new ArrayList<>();
                subList.add(arr[i-1]);
                subList.add(arr[i]);
                ans.add(subList);
            }
        }
        return ans;
    }

    public void sort(int[] arr,int s,int e){
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
