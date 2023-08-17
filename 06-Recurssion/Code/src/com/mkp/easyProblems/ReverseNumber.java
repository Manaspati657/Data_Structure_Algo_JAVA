package src.com.mkp.easyProblems;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseNo(12321));
    }

    private static int rev=0;
    private static int reverseNo(int no) {
        if(no == 0) return rev;
        rev=rev*10+no%10;
        return reverseNo(no/10);
    }
    private static int reverseNo2(int no) {
        if(no == 0) return rev;
        rev=rev*10+no%10;
        return reverseNo(no/10);
    }

}
