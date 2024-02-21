package src.com.mkp.v2.easy;

public class FibonacciNumber509_recursion {

    public static void main(String[] args) {
        System.out.println(fib(9));
    }

    public static int fib(int n) {
        int no1=0,no2=1;
        if(n == 0) return 0;
        return helper(no1,no2,n-1);
    }
    private static int helper(int no1,int no2,int n){
        if(n == 0) return no2;
        return helper(no2,no1+no2,n-1);
    }
}
