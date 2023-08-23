package src.com.mkp.problems;

import java.util.Arrays;

public class AssignCookies455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j=0;i < g.length && j < s.length ;j++)
            if(g[i] <= s[j]) i++;

        return i;
    }
}
