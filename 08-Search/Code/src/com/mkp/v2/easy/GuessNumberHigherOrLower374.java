package src.com.mkp.v2.easy;

public class GuessNumberHigherOrLower374 {

    public int guessNumber(int n) {
        int s=1;
        while(s <= n){
            int m=s+(n-s)/2;
            int g=guess(m);
            if(g == -1) n = m-1;
            else if(g == 1) s = m+1;
            else return m;
        }

        return -1;
    }

    //predefined method by leetcode.
    private int guess(int m) {
        return 1;
    }
}
