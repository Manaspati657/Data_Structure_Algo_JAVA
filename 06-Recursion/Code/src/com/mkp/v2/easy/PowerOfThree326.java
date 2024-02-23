package src.com.mkp.v2.easy;

public class PowerOfThree326 {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }
}
