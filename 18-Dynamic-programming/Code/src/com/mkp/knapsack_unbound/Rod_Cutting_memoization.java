package src.com.mkp.knapsack_unbound;

public class Rod_Cutting_memoization {

//    problem statement
    /*
    *
    * we have length n rod , we have to cut in some length so that profit is maximum .
    * we are allow to cut same length many times, so it's knapsack unbound problem.
    *
    * */

    public static void main(String[] args) {
        int N = 8;
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price,price.length,N));
    }

    private static int cutRod(int[] price,int length, int n) {
        return 0;
    }
}
