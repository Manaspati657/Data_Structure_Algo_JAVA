package src.com.mkp.easyProblems;

public class ProductOfDigit {
    public static void main(String[] args) {
        System.out.println(prodDigit(2345));
    }
    private static int prodDigit(int no) {
        if(no == 0) return  1;
        return no%10*prodDigit(no/10);
    }
}
