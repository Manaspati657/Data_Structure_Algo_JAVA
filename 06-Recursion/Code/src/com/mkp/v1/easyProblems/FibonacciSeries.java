package src.com.mkp.v1.easyProblems;

public class FibonacciSeries {
    public static void main(String[] args) {
        printFibonacci(10);
    }

    private static void printFibonacci(int no) {
        System.out.print(0+" ");
        helper(0,1,no);
    }

    private static void helper(int n1, int n2, int count) {
        if(count > 1){
            System.out.print(" "+n2+" ");
            helper(n2,n1+n2,--count);
        }
    }


}
