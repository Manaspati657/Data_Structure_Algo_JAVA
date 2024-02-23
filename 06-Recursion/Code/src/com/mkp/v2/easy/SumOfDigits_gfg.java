package src.com.mkp.v2.easy;

public class SumOfDigits_gfg {

    public static void main(String[] args) {
        int n = 534;
        System.out.println(sumOfDigits(n));
    }


    public static int sumOfDigits(int N){
        if(N == 0) return 0;
        return N%10+sumOfDigits(N/10);
    }
}
