package src.com.mkp.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK560 {
    public static void main(String[] args) {
        int[] arr={1,2,1,2,1};
        int k =  3;
        System.out.println(lenOfLongSubArrV2(arr,arr.length,k));
    }

    //    using map - works on both positive and negative and 0.
    public static int lenOfLongSubArrV2(int arr[], int n, int k){
        int count=0,sum=0;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            if(sum == k || map.containsKey(sum-k) ){
                count++;
            }
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return count;
    }
}
