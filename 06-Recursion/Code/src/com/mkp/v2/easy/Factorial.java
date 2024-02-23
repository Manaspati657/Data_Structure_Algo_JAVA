package src.com.mkp.v2.easy;

public class Factorial {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
}
