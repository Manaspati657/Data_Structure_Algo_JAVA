package src.com.mkp.v2.easy;

public class PowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        return n % 2 == 0 && isPowerOfTwo(n / 2);
    }
}
