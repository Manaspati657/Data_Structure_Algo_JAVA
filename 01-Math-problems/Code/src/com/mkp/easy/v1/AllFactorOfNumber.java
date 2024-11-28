package src.com.mkp.easy.v1;

public class AllFactorOfNumber {
    public static void main(String[] args) {
        getAllFactorWithSqrt(50);
    }

    /*
    *  Time Complexity :: O(N)
    * */
    public static void getAllFactor(int no){
        if (no == 0) System.out.print("");
        else for (int i = 1; i <= no; i++) {
            if(no % i == 0) System.out.print(i+" ");
        }
    }

    /*
     *  Time Complexity :: O(sqrt(N))
     * */
    public static void getAllFactorWithSqrt(int no){
        if (no == 0) System.out.print("");
        else for (int i = 1; i <= Math.sqrt(no); i++) {
            if(no % i == 0)
                if(no/i == i )
                    System.out.print(i+" ");
                else
                    System.out.print(i+" "+no/i+" ");
        }
    }


}
