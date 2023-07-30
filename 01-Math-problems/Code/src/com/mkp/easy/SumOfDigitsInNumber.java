package src.com.mkp.easy;

public class SumOfDigitsInNumber {
    public static void main(String[] args) {
        System.out.println("Sum :: "+getSumOfDigits(51234));
    }

    public static int getSumOfDigits(int no){
        int sum =0;
        while(no > 0) {
            sum=sum+no%10;
            no/=10;
        }
        return sum;
    }

}
