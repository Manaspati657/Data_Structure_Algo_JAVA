package src.com.mkp.theory;

import java.util.Arrays;

public class Main_Sorting  {
    public static void main(String[] args) {
        Integer[] arr={ 13, 2, 20, 10, 4, 15, 6, 18, 7, 3};
//        Integer[] arr={ 2, 3, 4, 6, 7, 10, 13, 15, 18, 20};
//        Integer[] arr={ 4, 3, 2, 1};
//        Integer[] arr={ 1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
//        SelectionSort.sort(arr);
//         InsertionSort.sort(arr);
//        BubbleSort.sort(arr);
//        in place merge sort
//         MergeSort.Sort(arr);
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
//        merge sort return a new array
//        Integer[] sortedArr=MergeSortWithNewArray.Sort(arr);
//        System.out.println(Arrays.toString(sortedArr));
    }
}
