package src.com.mkp.math;

public class GCD_LCM {
    public static void main(String[] args) {
        System.out.println(gcd(12,24));
        System.out.println(lcm(2, 6));
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    //    Both is same
//    GCD -Greatest common divisor
//    HCF - Highest common factor
    private static int gcd(int i, int j) {
        if(i==0) return j;
        return gcd(j%i,i);
    }

}
