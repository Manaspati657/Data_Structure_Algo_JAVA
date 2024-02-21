package src.com.mkp.v2.easy;

import java.util.Arrays;

public class FindMinimumAndMaximumElementInAnArray_gfg {
    public static void main(String[] args) {
        long[] arr = {1, 4, 3, -5, -4, 8, 6};
        System.out.println(Arrays.toString(getMinMax(arr, arr.length)));
    }

    public static long[] getMinMax(long a[], long n)
    {
        //Write your code here
        long min=getMin(a,n);
        long max=getMax(a,n);
        return new long[]{min,max};
    }

    private static long getMin(long a[],long n){
        if(n == 1) return a[0];
        return Math.min(a[(int)(n-1)],getMin(a,n-1));
    }
    private static long getMax(long a[],long n){
        if(n == 1) return a[0];
        return Math.max(a[(int)(n-1)],getMax(a,n-1));
    }
}
