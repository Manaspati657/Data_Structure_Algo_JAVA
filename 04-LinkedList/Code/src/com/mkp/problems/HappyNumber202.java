package src.com.mkp.problems;

public class HappyNumber202 {
//    https://leetcode.com/problems/happy-number/

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    private static boolean isHappy(int no) {
        int f=no,s=no;
        do{
            f=digitSquareSum(digitSquareSum(f));
            s=digitSquareSum(s);
        }while( s != f);
        if(s==1) return true;
        return false;
    }

    public static int digitSquareSum(int no){
        int sum=0;
        while(no > 0){
            sum+=(no%10)*(no%10);
            no/=10;
        }
        return sum;
    }
}
