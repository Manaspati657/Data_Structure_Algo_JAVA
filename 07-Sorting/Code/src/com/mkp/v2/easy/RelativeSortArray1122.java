package src.com.mkp.v2.easy;

import java.util.Map;
import java.util.HashMap;

public class RelativeSortArray1122 {

    /*
    *  without using sorting.
    * */
    public int[] relativeSortArrayV1(int[] arr1, int[] arr2) {
        //using hashmap
        Map<Integer,Integer> map=new HashMap<>();
        for(int el:arr1)
            map.put(el,map.getOrDefault(el,0)+1);
        int[] ans =new int[arr1.length];
        int i = 0;
        for(int el:arr2){
            while(map.get(el) > 0){
                ans[i++]=el;
                map.put(el,map.get(el)-1);
            }
            map.remove(el);
        }
        if(map.size() > 0){
            int[] remainArr=new int[ans.length-i];
            int j = 0;
            for(Integer el:map.keySet()){
                while(map.get(el) > 0){
                    if(j < remainArr.length) remainArr[j++]=el;
                    map.put(el,map.get(el)-1);
                }
            }
            sort(remainArr,0,remainArr.length-1);
            for(int el:remainArr){
                ans[i++]=el;
            }
        }
        return ans;
    }



//    using sorting .
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //using hashmap
        Map<Integer,Integer> map=new HashMap<>();
        for(int el:arr1)
            map.put(el,map.getOrDefault(el,0)+1);
        int[] ans =new int[arr1.length];
        int i = 0;
        for(int el:arr2){
            while(map.get(el) > 0){
                ans[i++]=el;
                map.put(el,map.get(el)-1);
            }
            map.remove(el);
        }
        if(map.size() > 0){
            int[] remainArr=new int[ans.length-i];
            int j = 0;
            for(Integer el:map.keySet()){
                while(map.get(el) > 0){
                    if(j < remainArr.length) remainArr[j++]=el;
                    map.put(el,map.get(el)-1);
                }
            }
            sort(remainArr,0,remainArr.length-1);
            for(int el:remainArr){
                ans[i++]=el;
            }
        }
        return ans;
    }
    public void sort(int[] arr,int s,int e){
        if(s >= e) return;
        int p=s+(e-s)/2,pivot=arr[p],l=s,r=e;
        while( l <= r){
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
