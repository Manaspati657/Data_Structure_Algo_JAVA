package src.com.mkp.binary_search;

import java.util.Arrays;

public class BinarySearch {
//    https://www.scaler.com/topics/time-complexity-of-binary-search/
//    The time complexity of binary search O(log n).
    public static void main(String[] args) {
        Integer[] arr={ 2, 3, 4, 6, 7, 10, 13, 15, 18, 20};
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr,4));
    }

    private static int binarySearch(Integer[] arr, int key) {
        int lo=0,hi=arr.length-1;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if     (key < arr[mid]) hi=mid-1;
            else if(key > arr[mid]) lo=mid+1;
            else return mid;
        }
        return -1;
    }
}
