package src.com.mkp.array.easy;

import java.util.Arrays;

public class KthSmallestElement_gfg {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(arr,0,arr.length-1,3));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        // sorting in O(n^2) in wrost case.
        // sortArray(arr,l,r);
        Arrays.sort(arr); // this sorting takes O(nlogn)
        return arr[k-1];
    }
    public static void sortArray(int[] arr,int l,int r){
        for(int i = l ;i <= r;i++){
            int min=i;
            for(int j = i+1;j<=r;j++){
                if(arr[min] > arr[j]) min=j;
            }
            swap(arr,min,i);
        }
    }
    public static void swap(int[] arr,int i , int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
