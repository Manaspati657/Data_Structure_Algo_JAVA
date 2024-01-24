package src.com.mkp.v1.easyProblems;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    private static int fact(int no) {
        if(no == 1) return 1;
        return no * fact(no-1);
    }
}
