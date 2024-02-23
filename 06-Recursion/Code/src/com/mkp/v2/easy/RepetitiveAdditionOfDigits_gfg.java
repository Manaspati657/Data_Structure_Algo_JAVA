package src.com.mkp.v2.easy;

public class RepetitiveAdditionOfDigits_gfg {

    public static void main(String[] args) {
        long n=3632523252523l;
        System.out.println(singleDigit(n));
    }

    static int singleDigit(long N){
        // code here
        long sum = helper(N);
        while(sum > 9){
            sum=helper(sum);
        }
        return (int)sum;
    }

    public static long helper(long N){
        // code here
        if(N == 0) return 0;
        return (long)(N%10)+helper(N/10);
    }
}
