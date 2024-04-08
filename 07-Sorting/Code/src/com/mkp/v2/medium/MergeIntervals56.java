package src.com.mkp.v2.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    public static void main(String[] args) {
        int[][] intervals={{1,3},{15,18},{2,6},{8,10}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        int n= intervals.length;
        if(n <= 1) return intervals;
        sort(intervals,0,n-1);
        List<int[]> list=new ArrayList<>();
        int[] newIntervals=intervals[0];
        list.add(newIntervals);
        for (int[] arr: intervals) {
            if(arr[0] <= newIntervals[1]){
                newIntervals[1]=Math.max(newIntervals[1],arr[1]);
            }else{
                newIntervals=arr;
                list.add(newIntervals);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    private static void sort(int[][] intervals, int s, int e) {
        if(s >= e) return ;
        int pI= s+(e-s)/2,l=s,r=e;
        int[] p=intervals[pI];
        while(l <= r){
            while (intervals[l][0] < p[0]) l++;
            while(intervals[r][0] > p[0]) r--;

            if(l <= r){
                //swap
                int[] temp=intervals[l];
                intervals[l]=intervals[r];
                intervals[r]=temp;

                l++;
                r--;
            }
        }

        sort(intervals,s,r);
        sort(intervals,l,e);
    }
}













