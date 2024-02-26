package src.com.mkp.v2.theory;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr={3,2,5,1,4};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cyclicSort(int[] arr) {

        int i = 0 ;
        while(i < arr.length){
            // correct number for i position i itself if correct then increase i else swap with the
            // incorrect index.
//            int correct=arr[i];// if the number start from 0 to n;
            int correct=arr[i]-1;// if the number start from 1 to n;
            if(arr[i] != arr[correct]){
                exch(arr,correct,i);
            }else {
                i++;
            }
        }

    }

    private static void exch(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
