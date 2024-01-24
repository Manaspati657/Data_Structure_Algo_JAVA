package src.com.mkp.v1.theory;

public class SelectionSort  {

    //    Time and Space Complexity:

    /*
    *   How it works::  get the min element in the entire array and swap it to the first element
    *   this process continue .
    *
    *   Time Complexity:
    *   Selection sort uses (N-1)+(N-2)+(N-3)+....+1+0 == N^2 (N square) / 2 for compare.
    *   N for exchange .
    *
    *   best case : O(N^2). ( its always compare)
    *   Worst case : O(N^2).
    *
    *   Space Complexity: O(1), as no extra space is required for the Selection sort algorithm
    *
    * */

//    [  13, 2, 20, 10, 4, 15, 6, 18, 7, 3]
    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            exch(arr,i,getMin(arr,i,arr.length));
        }
    }

    public static int getMin(Comparable[] arr,int start,int end){
        int min=start;
        for (int j = start; j <  end; j++)
            if(less(arr[j],arr[min])) min=j;
        return min;
    }


    public static boolean isSorted(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(less(arr[i],arr[i-1])) return false;
        }
        return true;
    }


    private static boolean less(Comparable v , Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a , int i ,int j){
        Comparable swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }
}
