package src.com.mkp.math;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println("is Prime ::  "+isPrime(11));
    }


    /*
     * Time complexity : O( sqrt(n))
     * */


    private static boolean isPrime(int no) {
        if(no <= 1 ) return false;

        int i = 2;
//        i <= Math.sqrt(no)  === i * i <= no
//        2 <= sqrt(16) ==> square of 2 <= square of sqrt(16) ==> 2 * 2 <= 16 .
        while ( i * i <= no ){
            if(no % i == 0 )return false;
            i++;
        }

        return true;
    }
}
