package src.com.mkp.easy;

public class PrimeNumber {
    public static void main(String[] args) {

        System.out.println("is Prime 5 :: "+isPrime(2));

    }

    /*
    * Time complexity : O( sqrt(n))
    * */

    public static boolean isPrime(int no ){
        if(no == 0 || no == 1 ) return false;
        else if(no == 2 || no == 3 ) return true;
        else if(no % 2 ==0 ) return false;
        else for (int i = 3; i < Math.sqrt(no); i++) if (no % i == 0) return false;
        return true;
    }
}
