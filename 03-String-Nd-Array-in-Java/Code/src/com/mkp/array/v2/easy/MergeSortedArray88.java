package src.com.mkp.array.v2.easy;

import java.util.Arrays;

public class MergeSortedArray88 {
    public static void main(String[] args) {
//       int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
//       int  m = 3, n = 3;
//       merge(nums1,m,nums2,n);
       int[] nums1 = {1}, nums2 = {};
       int  m = 0, n = 0;
       merge(nums1,m,nums2,n);
       System.out.println(Arrays.toString(nums1));
    }

    /*
    *  Solution 2 : The two array are sorted, so we check from end and whichever is bigger set it to the
    *               last element. only we will set nums2 array because after set nums2 nums 1 already sorted.
    *
    *
    * */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
       int i = m-1,j = n-1,k = m+n-1;
       while(j >= 0){
           if(i >= 0 && nums1[i] > nums2[j])
               nums1[k--]=nums1[i--];
           else
               nums1[k--]=nums2[j--];
       }
    }




    /*
    *   Solution 1 : insert nums2 all element inside nums1 and sort it .
    *   Time complexity:O(n + m log m)
    * */
    public static void mergev1(int[] nums1, int m, int[] nums2, int n) {
//      inserting n element into nums1. Time complexity: O(n)
        for(int i = m,j=0 ; i < nums1.length && j < n;i++,j++){
            nums1[i]=nums2[j];
        }
//        quick sort by java. Time complexity O(m log m)
        Arrays.sort(nums1);
    }
}
