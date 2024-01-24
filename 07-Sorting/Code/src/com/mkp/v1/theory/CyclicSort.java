package src.com.mkp.v1.theory;

import java.util.Arrays;

public class CyclicSort {

    /*
    *
    * its only works if sort numbers are from 1 to N or 0 to N or any no to N not any random number
    *
    * */

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int i =0;
        while( i < arr.length) {
//            int correct=arr[i]; //if number start from 0 to N
//            int correct=arr[i]-x; //if number start from x to N
            int correct=arr[i]-1; //if number start from 1 to N
            if(arr[i] != arr[correct]){
                exch(arr,i,correct);
            }else{
                i++;
            }

        }
    }
    public static void exch(int[] arr,int a , int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }


}
