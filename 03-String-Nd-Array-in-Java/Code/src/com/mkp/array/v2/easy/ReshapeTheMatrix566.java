package src.com.mkp.array.v2.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReshapeTheMatrix566 {
    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
        int r = 4, c = 1;
        // int[][] mat = {{1,2},{3,4}};
        // int r = 1, c = 4;
        // int[][] mat = {{1,2}};
        // int r = 1, c = 1;
        System.out.println(Arrays.deepToString(matrixReshape(mat,r,c)));
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int totalElement=mat.length*mat[0].length;
        if(r*c == totalElement){
            int[][] ans=new int[r][totalElement/r];
            List<Integer> temp=new ArrayList<>();
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    temp.add(mat[i][j]);
                }
            }
            for (int i = 0,k=0; i < ans.length && k < temp.size(); i++) {
                for (int j = 0; j < ans[i].length; j++,k++) {
                    ans[i][j]=temp.get(k);
                }
            }
            return ans;
        }
        return mat;
    }
}
