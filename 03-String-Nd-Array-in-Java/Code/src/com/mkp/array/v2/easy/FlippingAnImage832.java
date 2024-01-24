package src.com.mkp.array.v2.easy;

import java.util.Arrays;

public class FlippingAnImage832 {
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }

    /*
    *
    *  optimize approach without extra space and TC : (N^2)
    *  if we do 1 xor 1 then get 0 and 0 xor 1 get 1 .
    *
    *  Note : inner loop start 0 to the middle of the array so j < (n+1)/2
    * */

    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int temp=image[i][j];
                image[i][j]=image[i][n-j-1] ^1;
                image[i][n-j-1]=temp ^1;
            }
        }
        return image;

    }


    /*
    *
    *   Brute force approach : TC : O(N^2 + N^2) -> O(2N^2) -> O(N^2)
    *                          SC : O(M*N)
    *
    * */
    public static int[][] flipAndInvertImageV1(int[][] image) {
        int n = image.length;
        int[][] ans=new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j]=image[i][n-j-1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j]= (ans[i][j] == 1) ? 0 : 1;
            }
        }

        return ans;

    }
}
