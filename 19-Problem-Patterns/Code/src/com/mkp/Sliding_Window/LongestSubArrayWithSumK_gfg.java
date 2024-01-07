package src.com.mkp.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK_gfg {

    public static void main(String[] args) {
        int[] arr={10, 5, 2, 7, 1, 9};
        int k =  15;
        System.out.println(lenOfLongSubArrV2(arr,arr.length,k));
    }

//    using map - works on both positive and negative and 0.
    public static int lenOfLongSubArrV2(int arr[], int n, int k){
        int ans=0,sum=0;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            if(sum == k ){
                ans= i+1;
            }
            if(map.containsKey(sum-k)){
                ans= Math.max(ans,i-map.get(sum-k));
            }
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return ans;
    }

    //    sliding window pattern -- only works in positive and 0 .
    public static int lenOfLongSubArr(int arr[], int n, int k) {
        int ans=0,i=0,j=0,sum=0;

        while( j < n){
            // ? calculation on every move ::
            // sum every new element.
            sum+=arr[j];

//            if sum is less than the k then we don't reach the window size then increment j
            if(sum < k) j++;
//            if sum == k then we find the window
//            calculate the result here
            else if(sum == k ) {
                int windowSize=j-i+1;
                ans = windowSize > ans ? windowSize : ans;
                j++;
            }
//            if sum is greater than the k then we exceed the window size, so we have to decrease the window
//            size to subtract the element from the window front
            else if(sum > k ){
//              remove calculation for k from front of the window
                while(i < n && sum > k){
                    sum-=arr[i];
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}
