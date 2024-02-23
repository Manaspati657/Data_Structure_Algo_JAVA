package src.com.mkp.v2.easy;

import java.util.Arrays;

public class BubbleSort_recursion {
    public static void main(String[] args) {
        int[] arr={5,10,9,3,1,7};
        bubbleSort(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr,int n){

        if(n == 1 ) return ;

        boolean isSwap=false;

        for(int i = 0 ; i < n;i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                isSwap=true;
            }
        }
        if(!isSwap) return;

        bubbleSort(arr,n-1);

    }
}
