package src.com.mkp.v2.theory;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={9,3,6,2,1,8,4};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int s, int e) {
        if(s < e ){
            int pivot= partition(arr,s,e);
            quickSort(arr,s,pivot-1);
            quickSort(arr,pivot+1,e);
        }
    }

    private static int partition(int[] arr, int s, int e) {
        int l = s , r= e-1,pivot=arr[e];

        while(l <= r){
            while( l <= r && arr[l] < pivot) l++;
            while( r >= l && arr[r] > pivot) r--;

            if( l < r) exch(arr,l,r);
        }

//        swap pivot with the l or right
        exch(arr,e,l);
        return l;
    }

    private static void exch(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
