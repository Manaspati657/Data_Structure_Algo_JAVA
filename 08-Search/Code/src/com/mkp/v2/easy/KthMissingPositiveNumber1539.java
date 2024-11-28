package src.com.mkp.v2.easy;

import java.util.Arrays;

public class KthMissingPositiveNumber1539 {

    public static void main(String[] args) {
        int[] arr={2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr,k));
    }


    // Brute force
    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int[] temp=new int[arr[n-1]+1];
        for(int el:arr){
            temp[el]=1;
        }
        int i = 1;
        while(k > 0 && i < arr[n-1]+1){
            if(temp[i] == 0) k--;
            i++;
        }
        return (k == 0) ? i-1 : arr[n-1]+k ;
    }
}
