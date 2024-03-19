package src.com.mkp.v2.theory;

import java.util.Arrays;
public class SelectionSort {

    public static void main(String[] args) {
//        int[] arr={5,9,3,1,7};
        int[] arr={3,8,-10,23,19,-4,-14,27};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    *   n : size of array.
    *   Selection sort approach:
    *   select the greater element from the entire array put it in the last index,then search for next
    *   greater element but skip the last one and put it in n-2 index.
    *   e.g.
    *   select the greater element from 0 to n-1 and put it in n-1 index.
    *   select the greater element from 0 to n-2 and put it in n-2 index.
    *   select the greater element from 0 to n-3 and put it in n-3 index.
        ...
        ...
    *  Time complexity : O(n^2)
    *  Note: Selection sort is not stable.
    *
    *
    * */
    public static void selectionSort(int[] arr){
        for (int i = 0 ; i < arr.length ; i++ ){
            int maxIndex=0;
            for (int j = 1; j < arr.length - i  ; j++){
                if(arr[j] > arr[maxIndex]) maxIndex = j;
            }
            // we find max value index swap the element with n-1 i.e. n-i-1 .
            int temp=arr[maxIndex];
            arr[maxIndex]=arr[(arr.length-i-1)];
            arr[(arr.length-i-1)]=temp;
        }
    }
}
