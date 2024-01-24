package src.com.mkp.v1.binary_Search_problems;

import java.util.Arrays;

public class SearchA2DMatrix74 {
    public static void main(String[] args) {
//        int[][] arr = {
//                {1,3,5,7},
//                {10,11,16,20},
//                {23,30,34,60}
//        };
          int[][] arr = {
                {1}
        };

        System.out.println(Arrays.toString(search(arr, 16)));
    }

    private static int[] search(int[][] arr, int target) {
        int r=arr.length-1,c=0;
        while(r >= 0 && c < arr[0].length){
            if(arr[r][c] == target) return new int[]{r,c};
            if( r > 0 && arr[r][c] > target ){
                r--;
            }else{
                return (binarySearch(arr[r],target) != -1) ?
                        new int[]{r,binarySearch(arr[r],target)}
                        : new int[]{-1,-1} ;
            }
        }

        return new int[]{-1,-1};
    }

    private static int binarySearch(int[] arr, int target) {
        int s=0,e=arr.length-1;
        while(s <= e){
            int m=s+(e-s)/2;
            if(arr[m] < target) s=m+1;
            else if(arr[m] > target) e=m-1;
            else return m;
        }
        return -1;
    }
}
