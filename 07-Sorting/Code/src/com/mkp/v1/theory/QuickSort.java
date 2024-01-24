package src.com.mkp.v1.theory;

public class QuickSort {

//    Time and Space Complexity:
    /*
    *
    *  Time complexity: ref(https://www.scaler.com/topics/data-structures/quick-sort-algorithm/)
    * =================
    *  Best case : O(NlogN) -The best-case occurs when the pivot is almost in the middle of the array,
    *  and the partitioning is done in the middle. So, let us assume that we have a total of n elements
    *  in the array, and we are dividing the array from the middle .(just like merge sort we divide array
    *  from middle).
    *
    *  Worst case : O(N^2) - The Worst-case occurs when either of the two partitions is unbalanced.
    *   This generally happens when the greatest or smallest element is selected as the pivot.In this case,
    *   the pivot lies at the extreme of the array, and one sub array is always empty while the other contains
    *    n – 1 elements.
    *
    *
    * */

    public static void sort(Integer[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(Integer[] arr, int left, int right) {
        if(left < right){
            int pivot= partition(arr,left,right);
            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }

    private static int partition(Integer[] arr, int left, int right) {

        int pv=arr[right];
        int l=left,r=right-1;

        while (l <= r){
            while (l <= r && arr[l] < pv) l++;
            while (r >= l && arr[r] > pv) r--;
//            System.out.println(l+"-"+r+"-"+pv);
            if(l < r ) exch(arr,l,r);
        }
        exch(arr,l,right);
        return l;
    }

    private static void exch(Integer[] a , int i ,int j){
        int swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }


}
