package src.com.mkp.linear_search;

import java.util.Arrays;

public class SearchIn2DArray {
    //    The time complexity of linear search O(n).
    public static void main(String[] args) {
        int[][] arr = {
                {23, 4, 1},
                {18, 12, 3, 9},
                {78, 99, 34, 56},
                {18, 12}
        };
        int target = 56;
        int[] ans = search(arr,target); // format of return value {row, col}
        System.out.println(Arrays.toString(ans));

        System.out.println(max(arr));

        System.out.println(Integer.MIN_VALUE);
    }

    private static int max(int[][] arr) {
        if(arr.length == 0 ) return Integer.MIN_VALUE;
        int max=arr[0][0];
        for (int[] parent:arr) {
            for (int e:parent) {
                if(e <= max) max=e;
            }
        }
        return max;
    }

    private static int[] search(int[][] arr, int target) {
        if(arr.length== 0 ) return null;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == target) return new int[] {i,j};
            }
        }
        return null;
    }
}
