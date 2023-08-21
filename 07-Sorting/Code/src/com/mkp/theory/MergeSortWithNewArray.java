package src.com.mkp.theory;

import java.util.Arrays;

public class MergeSortWithNewArray {
    //    Time and Space Complexity:
    /*
     *   This merge sort is using new array and return a new array .
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

    public static Integer[] Sort(Integer[] arr){
        return sort(arr,0,arr.length-1);
    }

    private static Integer[] sort(Integer[] arr, int lo, int hi) {
        if(lo >= hi) return arr;
        int mid=lo+(hi-lo)/2;
        int l1,l2;
        if(arr.length % 2== 0){
            l1=l2= arr.length/2;
        }else{
            l1=arr.length/2+1;
            l2=arr.length/2;
        }
        Integer[] firstArr=new Integer[l1];
        Integer[] lastArr=new Integer[l2];
        for (int i = 0; i < firstArr.length; i++) {
            firstArr[i]=arr[lo];
            lo++;
        }
        for (int i = 0; i < lastArr.length; i++) {
            lastArr[i]=arr[mid+1];
            mid++;
        }
//        System.out.println(lo+"-"+mid+"-"+hi);
        Integer[] first=sort(firstArr,0,firstArr.length-1);
        Integer[] last=sort(lastArr,0,lastArr.length-1);
//        if(less(firstArr[firstArr.length-1],lastArr[0])) return arr;
        return merge(first,last);
    }

    private static Integer[] merge(Integer[] first, Integer[] last) {
        System.out.println(first.length+"-"+last.length);
        Integer[] auxArr=new Integer[first.length+last.length];

        int lo=0,mid=0;

        int k =0;
        while (lo < first.length && mid < last.length){
            if(less(first[lo],last[mid])){
                auxArr[k]= first[lo];
                lo++;
            }else{
                auxArr[k]= last[mid];
                mid++;
            }
            k++;
        }

        while( lo < first.length){
            auxArr[k]= first[lo];
            lo++;
            k++;
        }

        while( mid < last.length){
            auxArr[k]= last[mid];
            mid++;
            k++;
        }

        return auxArr;
    }

    private static boolean less(Integer v , Integer w){
        return v.compareTo(w) < 0;
    }

}
