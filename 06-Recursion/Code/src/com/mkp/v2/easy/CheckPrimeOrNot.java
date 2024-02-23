package src.com.mkp.v2.easy;

public class CheckPrimeOrNot {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(isPrime(n));
        System.out.println(isPrimeRecursion(n,2));
    }

    private static boolean isPrimeRecursion(int n,int divisor) {

        // base case
        if(n <= 2 ) return n == 2;
        if(n % divisor == 0) return false;
        if(divisor * divisor > n) return true;
        return isPrimeRecursion(n, divisor+1);
    }

    private static boolean isPrime(int n) {
        if(n <= 2) return true;
        for(int i = 2 ; i * i <= n ;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
