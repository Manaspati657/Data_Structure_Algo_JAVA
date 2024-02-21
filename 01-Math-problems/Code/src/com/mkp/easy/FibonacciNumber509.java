package src.com.mkp.easy;

public class FibonacciNumber509 {

    public static void main(String[] args) {
        System.out.println(fib(9));
    }

    public static int fib(int n) {
        int no1=0,no2=1;
        if(n == 0) return 0;
        n=n-1;
        while(n != 0){
            int sum=no1+no2;
            no1=no2;
            no2=sum;
            n--;
        }
        return no2;
    }
}
