package src.com.mkp.problems;

import java.util.Arrays;

public class Selection_recursion {

    public static void main(String[] args) {
        Integer[] arr={ 13, 2, 20, 10, 4, 15, 6, 18, 7, 3};
//        Integer[] arr={ 2, 3, 4, 6, 7, 10, 13, 15, 18, 20};
//        Integer[] arr={ 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Integer[] arr) {
        sort(arr,arr.length-1,0,0);
    }

    private static void sort(Integer[] arr, int last,int index,int max) {
        if( last < 0 ) return;
        if( index < last ){
            if(less(arr[max],arr[index+1])){
                max=index+1;
            }
            sort(arr,last,++index,max);
        }else{
            exch(arr,last,max);
            sort(arr,--last,0,0);
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
