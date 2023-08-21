package src.com.mkp.theory;

public class BubbleSort {

    //    Time and Space Complexity:
    /*
     *
     *  How it works : swap 2 element if the current element is greater than next element .
     *  After every iteration greater element are in the last .
     *
     *
     *  Time Complexity:
     *   Bubble sort uses N+(N-1)+(N-2)+(N-3)+....+1+0 == N^2 (N square)  for compare.
     *   N^2 for exchange .
     *
     *   Best case : O(N). (If element in sorting order)
     *   Worst case : O(N^2).
     *
     *   Space Complexity: O(1), as no extra space is required for the Selection sort algorithm
     *
     *
     * */

    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean swap=false;
            for (int j = 0; j < arr.length - i -1 ; j++) {
                if(less(arr[j+1],arr[j])) {
                    exch(arr,j,j+1);
                    swap=true;
                }
            }
            if(!swap) break;
        }
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
