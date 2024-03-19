package src.com.mkp.v2.easy;

import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray1331 {

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp=new int[n];
        for(int i= 0; i < n ; i++){
            temp[i]=arr[i];
        }
        sort(arr,0,n-1);
        Map<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[n];
        int count=1;
        for(int i = 0 ; i < n; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],count++);
            }
        }
        for(int i= 0; i < n ; i++){
            ans[i]=map.get(temp[i]);
        }
        return ans;
    }

    public void sort(int[] arr,int s ,int e){
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
