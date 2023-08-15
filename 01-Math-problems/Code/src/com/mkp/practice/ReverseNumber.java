package src.com.mkp.practice;

public class ReverseNumber {

    public static void main(String[] args) {
        System.out.println("reverse: "+reverse(12345));//54321
    }

    static int reverse(int no) {
        int rev =0;

        while(no != 0){
            int rem= no %10;
            rev= rev * 10 + rem;
            no=no/10;
        }

        return rev;
    }

}
