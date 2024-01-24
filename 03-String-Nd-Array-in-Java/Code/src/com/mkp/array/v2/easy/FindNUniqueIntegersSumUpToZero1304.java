package src.com.mkp.array.v2.easy;

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero1304 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(7)));
    }

    /*
    *   approach : add +x and -x , if n is odd then add 0 in last .
    *
    * */

    public static int[] sumZero(int n) {
        int[] ans =new int[n];
        int condition=0;
        if(n %2 == 0) condition=n;
        else{
            condition=n-1;
            ans[condition]=0;
        }
        for (int i = 0,start=1; i < condition ; i=i+2,start++) {
            ans[i]=start;
            if(i < n-1) ans[i+1]=-start;
        }
        return ans;
    }
}
