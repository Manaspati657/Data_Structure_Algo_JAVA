package src.com.mkp.math;

public class NumberOfCommonFactors_2427 {
    public static void main(String[] args) {

        System.out.println(commonFactors(12,6));
        System.out.println(commonFactors(25,30));
        System.out.println(commonFactors(12,24));

    }

    public static int commonFactors(int a, int b) {
        int count =0;
        int gcdValue=gcd(a,b);
        for (int i = 1; i < Math.sqrt(gcdValue); i++) {
            if(gcdValue % i == 0)
                if(gcdValue / i == i )count ++;
                else count+=2;
        }

        return count;
    }

    public static int gcd(int a , int b ){
        if(a == 0) return b;
        return gcd(b%a,a);
    }

}
