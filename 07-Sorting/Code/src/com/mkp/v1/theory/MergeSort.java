package src.com.mkp.v1.theory;

public class MergeSort {
//    Time and Space Complexity:
    /*
    *   This merge sort is inplace merge sort without creating new array we are just
    *   modify existing array directly.
    *   Time complexity :
    *   Best case: O(N) --if array is sorted it will not take merge operation .
    *   Worst case: O(N logN)  -- N for all array element and log N for recursion tree.
    *
    *
    *   Space complexity: O(N) - In merge sort, all elements are copied into an auxiliary array of size N,
    *   where N is the number of elements present in the unsorted array
    *
    *
    * */

    public static void Sort(Comparable[] arr){
        sort(arr,0,arr.length-1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
      if(lo >= hi) return;
      int mid=lo+(hi-lo)/2;
      sort(arr,lo,mid);
      sort(arr,mid+1,hi);
      if(less(arr[mid],arr[mid+1])) return;
      System.out.println(lo+"-"+mid+"-"+hi);
      merge(arr,lo,hi);
    }

    private static void merge(Comparable[] arr, int lo, int hi) {

        int tempMid=lo+(hi-lo)/2,mid=tempMid+1;
        int tempLo=lo;
        int[] auxArr=new int[(hi-lo)+1];

        int k =0;
        while (tempLo <= tempMid && mid <= hi){
            if(less(arr[tempLo],arr[mid])){
                auxArr[k]= (int) arr[tempLo];
                tempLo++;
            }else{
                auxArr[k]= (int) arr[mid];
                mid++;
            }
            k++;
        }

        while( tempLo <= tempMid){
            auxArr[k]= (int) arr[tempLo];
            tempLo++;
            k++;
        }

        while( mid <= hi){
            auxArr[k]= (int) arr[mid];
            mid++;
            k++;
        }

        for (int i = 0; i < auxArr.length; i++) {
            arr[i+lo]=auxArr[i];
        }
        

        //       with insertion sort
/*        for (int i = lo; i < hi ; i++) {
            for (int j = i+1; j > lo; j--) {
                if(less(arr[j],arr[j-1])){
                    exch(arr,j,j-1);
                }else{
                    break;
                }
            }
        }*/
    }

    private static boolean less(Comparable v , Comparable w){
        return v.compareTo(w) < 0;
    }

}
