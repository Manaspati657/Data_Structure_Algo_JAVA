package src.com.mkp.v2.theory;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr={9,3,6,2,1,8,4};
        int[] sortedArr = mergeSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    // dividing array then merge the array we can
    private static int[] mergeSort(int[] arr) {
        if(arr.length <= 1){
            return arr;
        }
        int mid=arr.length/2;
        int[] leftArr=new int[mid];
        for (int i = 0; i < mid; i++) {
            leftArr[i]=arr[i];
        }
        int[] rightArr=new int[arr.length-mid];
        for (int i = 0,j=mid; i < rightArr.length ; i++,j++) {
            rightArr[i]=arr[j];
        }
        int[] left=mergeSort(leftArr);
        int[] right=mergeSort(rightArr);

        return mergeArray(left,right);
    }

    private static int[] mergeArray(int[] left, int[] right) {
        int[] mergeArr=new int[left.length+ right.length];
        int i = 0,j = 0,m=0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                mergeArr[m++]=left[i++];
            }else{
                mergeArr[m++]=right[j++];
            }
        }
        while(i < left.length)
            mergeArr[m++]=left[i++];
        while(j < right.length)
            mergeArr[m++]=right[j++];

        return mergeArr;
    }


}
