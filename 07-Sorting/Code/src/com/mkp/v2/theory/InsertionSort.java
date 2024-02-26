package src.com.mkp.v2.theory;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr={9,3,6,2,1,8,4};
//        insertionSort(arr);
        insertionSortV2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSortV2(int[] arr) {
//    we are taking the current element as the last, and we move every element by one if
//    previous element is greater than the last element and if we find any element is the small
//    element than last we stop and assign the last greater element.
        for (int i = 1; i < arr.length; i++) {
            int j=i-1,last=arr[i];
            while(j>=0 && arr[j] > last){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=last;
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else{
                    break;
                }
            }
        }
    }


}
