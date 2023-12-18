package src.com.mkp.AdityaVerma;

public class KthSymbolInGrammar779 {

    /*
    *
    *   We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every
    *   subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and
    *   each occurrence of 1 with 10.
    *
    *   Note: 0 convert 01 and 1 convert to 10 in next line
    *   e.g. n = 1  -> 0
    *   e.g. n = 2  -> 01
    *   e.g. n = 3  -> 01 10
    *   e.g. n = 4  -> 01 10 10 01
    *
    *   In this example we have to find the kth element of n row and k start from 1 <= nth
    *   row length-1
    *
    *   Solution:
    *     -> To find the length of the nth row, formula is 2^n-1.
    *     -> Another thing is every next row 1st half numbers are previous row value and 2nd half is
    *        previous row value reverse ( ! of 0 or 1 ).
    *     -> So if the k is less than nth length/2 so in that case we have to find it in n-1 row. If
    *        also k is greater than nth length/2 also we have to find it in n-1 row but the return value
    *        will be reverse ( if ans is 0 then return 1 and if ans is 1 then return 0).
    *
    * */

    public static void main(String[] args) {
//        System.out.println(kthGrammar(2,1));
        System.out.println(kthGrammar(4,5));
    }
    public static int kthGrammar(int n, int k) {
        if(n == 1 && k == 1) return 0;
        int length = (int) Math.pow(2,n-1);
        if(k <= length/2){
            return kthGrammar(n-1,k);
        }else {
            return kthGrammar(n-1,(k-(length/2))) == 0 ? 1 : 0;
        }
    }
}
