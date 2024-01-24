package src.com.mkp.v1.easyProblems;

public class Pallindrom {
    public static void main(String[] args) {
        System.out.println(isPallindrom(12321));
    }

    private static boolean isPallindrom(int no) {
        return no == reverseNo2(no);
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
