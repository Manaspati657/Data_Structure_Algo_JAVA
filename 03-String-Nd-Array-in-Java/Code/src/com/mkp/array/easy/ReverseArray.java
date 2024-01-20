package src.com.mkp.array.easy;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr) {
        int i = 0,j=arr.length-1;
        while(i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}
