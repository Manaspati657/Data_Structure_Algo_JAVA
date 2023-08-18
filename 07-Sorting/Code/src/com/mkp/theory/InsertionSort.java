package src.com.mkp.theory;

public class InsertionSort {

    /*
    *   How it works: sort from one end , first 0 index, then 0-1 index ,then 0-2 index
    *   then 0-3 index ... continue to the last index .
    *
    *
    *
    *  Time Complexity:
     *   Insertion sort uses (N-1)+(N-2)+(N-3)+....+1+0 == N^2 (N square) / 2 for compare.
     *   N^2/2 for exchange .
     *
     *   Best case : O(N). (If element in sorting order)
     *   Worst case : O(N^2).
     *
     *   Space Complexity: O(1), as no extra space is required for the Selection sort algorithm
     *
    *
    * */


    //    [  13, 2, 20, 10, 4, 15, 6, 18, 7, 3]
//    [3, 2, 1]
    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--)
                if(less(arr[j],arr[j-1]))
                    exch(arr,j,j-1);
                else break;
        }
    }


    public static boolean isSorted(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(less(arr[i],arr[i-1])) return false;
        }
        return true;
    }


    private static boolean less(Comparable v , Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a , int i ,int j){
        Comparable swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }
}
