package src.com.mkp.bitwise;

public class OddEven {
    public static void main(String[] args) {
        System.out.println("is Even :: "+isEven(3));
    }

    private static boolean isEven(int no) {
        return (no & 1) == 0;
        /*
        *  ...8 4 2 1
        *
        *   3 = 0 1 1
        *   1 = 0 0 1  &
        * =============
        *       0 0 1
        *
        *   6 = 1 1 0
        *   1 = 0 0 1  &
        * =============
        *       0 0 0
         *
        * */

    }
}
