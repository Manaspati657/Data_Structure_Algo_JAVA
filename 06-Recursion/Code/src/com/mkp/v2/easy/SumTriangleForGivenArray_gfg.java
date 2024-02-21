package src.com.mkp.v2.easy;

import java.util.Arrays;

public class SumTriangleForGivenArray_gfg {
    public static void main(String[] args) {
//        int[] arr={1,2,3,4,5};
//        printTriangle(arr);
        long[] arr={1,2,3,4,5};
        System.out.println(Arrays.toString(getTriangle(arr,arr.length)));
    }

    private static int index;

    public static long[] getTriangle(long arr[], long n)
    {
        long len=(n*(n+1))/2;
        index=0;
        long[] ans=new long[(int)len];
        helper(arr,ans);
        return ans;
    }

    public static void helper(long arr[],long[] ans){
        int n=arr.length;
        if(n < 1) return ;
        long[] newArr=new long[n-1];
        for (int i = 0; i < n-1; i++) {
            newArr[i]=arr[i]+arr[i+1];
        }
        helper(newArr, ans);
        if(index < ans.length){
            for (long el : arr) {
                ans[index++]=el;
            }
        }
    }






//  only print in triangle format.
    public static void printTriangle(int[] arr) {
        int l=arr.length;
        if(l < 1) return ;
        int[] newArr=new int[l-1];
        for (int i = 0; i < l-1; i++) {
            newArr[i]=arr[i]+arr[i+1];
        }
        printTriangle(newArr);
        System.out.println(Arrays.toString(arr));
    }
}
