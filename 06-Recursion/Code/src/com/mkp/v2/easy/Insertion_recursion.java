package src.com.mkp.v2.easy;

import java.util.Arrays;

public class Insertion_recursion {
    public static void main(String[] args) {
        int[] arr={5,10,9,3,1,7};
        insertionSortRecursive(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSortRecursive(int[] arr,int n){

        // Base case
        if (n <= 1)
            return;

        // Sort first n-1 elements
        insertionSortRecursive( arr, n-1 );

        // Insert last element at its correct position
        // in sorted array.
        int last = arr[n-1];
        int j = n-2;

       /*
       *  Move elements of arr[0..i-1], that are greater than key, to one position ahead
       * of their current position
       * */
        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;

    }
}
