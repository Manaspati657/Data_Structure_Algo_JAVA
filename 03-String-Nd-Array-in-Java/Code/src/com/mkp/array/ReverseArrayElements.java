package src.com.mkp.array;

import java.util.Arrays;

public class ReverseArrayElements {
    public static void main(String[] args) {
        int[] arr={2,3,5,4,8,7,6,9};
        System.out.println(Arrays.toString(arr));
        reverseElements(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseElements(int[] arr) {
        int start=0,end=arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            if(start <= end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
    }
}
