package src.com.mkp.easyProblems;

public class Numbers1ToN {
    public static void main(String[] args) {
//        numberPrint1ToN(5);
        numberPrintNTo1(5);
    }

    private static void numberPrint1ToN(int no) {
        if(no == 0){
            return;
        }
        numberPrint1ToN(no-1);
        System.out.println(no);
    }

    private static void numberPrintNTo1(int no) {
        if(no == 0){
            return;
        }
        System.out.println(no);
        numberPrintNTo1(--no);
    }
}
