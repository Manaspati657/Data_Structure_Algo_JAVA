package src.com.mkp.easyProblems;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseNo2(12345));
    }

    private static int rev=0;
    private static int reverseNo(int no) {
        if(no == 0) return rev;
        rev=rev*10+no%10;
        return reverseNo(no/10);
    }
    private static int reverseNo2(int no) {
        int digit = (int) Math.log10(no)+1;
        return  helper(no,digit);
    }

    private static int helper(int no, int digit) {
        if(no%10== no ) return no;
        return (no%10)*(int)Math.pow(10,digit-1)+helper(no/10,digit-1);
    }

}
