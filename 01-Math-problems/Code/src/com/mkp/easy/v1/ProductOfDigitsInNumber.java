package src.com.mkp.easy.v1;

public class ProductOfDigitsInNumber {
    public static void main(String[] args) {
        System.out.println("Product :: "+getProductOfDigits(435));
    }

    public static int getProductOfDigits(int no){
        int sum =1;
        while (no > 0){
            sum=sum * (no % 10);
            no/=10;
        }
        return sum;
    }
}
