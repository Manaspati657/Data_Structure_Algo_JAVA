package src.com.mkp.easyProblems;

public class SumOfDigit {
    public static void main(String[] args) {
        System.out.println(sumDigit(3544));
    }

    private static int sumDigit(int no) {
        if(no == 0) return  0;
        return no%10+sumDigit(no/10);
    }
}
