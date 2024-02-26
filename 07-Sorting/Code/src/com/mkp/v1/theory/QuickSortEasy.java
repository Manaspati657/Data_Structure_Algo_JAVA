package src.com.mkp.v1.theory;

import java.util.Arrays;

public class QuickSortEasy {

    public static void main(String[] args) {
        Integer[] arr={9,3,6,2,1,8,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Integer[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(Integer[] arr, int lo, int hi) {
        if(lo >= hi) return;
        int s= lo,e=hi;
        int pivotIndex=s+(e-s)/2;
//        int pivotIndex=hi;
//        int pivotIndex=lo;
        int pivot=arr[pivotIndex];
        while(s <= e){
            while(arr[s] < pivot) s++;
            while(arr[e] > pivot) e--;
            if(s <= e){
                exch(arr,s,e);
                s++;
                e--;
            }
        }

        quickSort(arr,lo,e);
        quickSort(arr,s,hi);

    }

    private static void exch(Integer[] a , int i ,int j){
        int swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }

}
