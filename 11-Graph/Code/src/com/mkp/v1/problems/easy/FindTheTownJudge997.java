package src.com.mkp.v1.problems.easy;

import java.util.Arrays;

public class FindTheTownJudge997 {
    public static void main(String[] args) {
//        int[][] trust = {{1,3},{2,3}};
        int[][] trust = {{1,3},{2,3},{3,1}};
        int n=3;
//        int[][] trust = {{1,3},{1,4},{2,3},{2,4   },{4,3}};
//        int n=4;
        System.out.println(findJudge(n,trust));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] count=new int[n+1];

        for (int[] arr:trust) {
            count[arr[0]]--;
            count[arr[1]]++;
        }
        System.out.println(Arrays.toString(count));

        for (int i = 1; i < n+1; i++) {
            if(count[i] == n-1) return i;
        }

        return -1;
    }
}
