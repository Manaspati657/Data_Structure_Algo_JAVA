package src.com.mkp.easyProblems;

public class Sum1toN {
    public static void main(String[] args) {
        System.out.println(sumNumber(10));
        System.out.println(prodNumber(5));
    }

    private static int sumNumber(int no) {
        if(no == 1) return 1;
        return no + sumNumber(--no);
    }

    private static int prodNumber(int no) {
        if(no == 1) return 1;
        return no * prodNumber(--no);
    }
}
