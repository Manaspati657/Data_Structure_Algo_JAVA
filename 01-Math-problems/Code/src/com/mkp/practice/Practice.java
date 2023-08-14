package src.com.mkp.practice;

public class Practice {

    public static void main(String[] args) {
//        printFactors(40);
//          fibonacciRecursion(10);
//          fibonacciSeries(10);
//        reverseNumber(12345);
          isPalindrome(12321);
    }

    private static void isPalindrome(int no) {
        System.out.println(no +" is Palindrome ?  "+(no==reverseNumber(no)));
    }

    private static int reverseNumber(int no) {
        int rev=0;
        while(no>0){
            rev= rev * 10 + no%10;
            no/=10;
        }
//        System.out.println(rev);
        return rev;
    }

    private static void fibonacciSeries(int no) {
        int no1=0,no2=1,no3=0;
        while(no > 0){
            System.out.print(no1+" ");
            no3=no1+no2;
            no1=no2;
            no2=no3;
            no--;
        }
    }


    private static void printFactors(int no) {
        for (int i = 1; i * i <= no ; i++) {
            if(no % i == 0){
                if( no/i == i ){
                    System.out.print(i+" ");
                }else{
                    System.out.print(" "+i+" "+no/i+" ");
                }
            }
        }
    }

    private static void fibonacciRecursion(int count){
        fibRec(0,1,count);
    }

    private static void fibRec(int no1,int no2,int count){
        if(count > 0){
            System.out.print(no1+" ");
            fibRec(no2,no1+no2,--count);
        }
    }
}
