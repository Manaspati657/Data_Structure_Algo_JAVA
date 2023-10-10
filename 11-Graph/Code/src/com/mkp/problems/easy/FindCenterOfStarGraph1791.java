package src.com.mkp.problems.easy;

import java.util.ArrayList;

public class FindCenterOfStarGraph1791 {

    public static void main(String[] args) {
//        [[1,2],[2,3],[4,2]]
        int[][] star = {{1,2},{2,3},{4,2}};
        System.out.println(findCenter(star));
    }

    public static int findCenter(int[][] e) {

        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }
}
