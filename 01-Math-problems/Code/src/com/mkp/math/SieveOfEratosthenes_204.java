package src.com.mkp.math;

import java.lang.reflect.Array;
import java.util.Arrays;

//LeetCode 204. Count Primes

public class SieveOfEratosthenes_204 {

//    Given a number n, print all primes smaller than or equal to n.
//    It is also given that n is a small number.
//    Time complexity : o(n*log(log(n)))
//    time complexity is a formula of harmonic progression .
//    https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/lectures/16-math/Maths.pdf
    public static void main(String[] args) {

        System.out.println("count primes in range :: "+ countPrimeNumbers(37));
    }

    private static int countPrimeNumbers(int no) {

        if(no <= 1 ) return 0;

        int[] primeArr=new int[no+1];
//        System.out.println(Arrays.toString(primeArr));
//        i <= Math.sqrt(no)  === i * i <= no
//        2 <= sqrt(16) ==> square of 2 <= square of sqrt(16) ==> 2 * 2 <= 16 .
        for (int i = 2; i * i <= no; i++) {
            if(primeArr[i] != 1){
                for (int j = i*2; j <= no ; j+=i) { // j+=i because it will false its multiples.
                    primeArr[j]=1;
                }
            }
        }
//        System.out.println(Arrays.toString(primeArr));
        int count =0;
        for (int i = 2; i <= no; i++) {
            if(primeArr[i] == 0 ){
                System.out.print(" "+(i));
                count++;
            }
        }
        System.out.println();
        return count;
    }

}
