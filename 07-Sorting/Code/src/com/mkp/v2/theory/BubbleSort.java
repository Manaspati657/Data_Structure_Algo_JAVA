package src.com.mkp.v2.theory;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={5,9,3,1,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    *   Bubble sort approach: we just compare the adjacent element if required then swap it,we have
    *   to do it for all the elements. we have do it n no of times.
    *
    *   we can optimize the comparison to every time comparison will decrease because after every
    *   iteration the max element will automatically goes to last. so we only have to compare
    *   n-1,n-2,n-3...0;
    *
    *   Note Bubble sort is also Stable sort.stable sort means that what ever order of the element
    *   in non sorting array, after sorting also that order will be same.
    *
    *   Stable sort: A stable sorting algorithm preserves the original order of elements with equal keys.
    * */

    public static void bubbleSort(int[] arr){
        for (int i = 0 ; i < arr.length-1 ; i++ ){
            boolean isSwap=false;
            for (int j = 0; j < arr.length - i - 1 ;j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    isSwap=true;
                }
            }
            // if one iteration there is no swap then we don't need to check another time.
            if(!isSwap) break;
        }
    }
}
