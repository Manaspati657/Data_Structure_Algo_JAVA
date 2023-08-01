package src.com.mkp.math;


import java.util.HashSet;
import java.util.Set;

//1492. The kth Factor of n
public class AllFactorOfNumber_1492 {
    public static void main(String[] args) {
//        getAllFactorWithSqrt(15);
//        System.out.println();
//        factorWithN(15);
//        System.out.println(kthFactor(12,3));
//        System.out.println(kthFactor(7,2));
        System.out.println(kthFactor(4,4));
    }

    private static void factorWithN(int no) {
        for (int i = 1; i <= no; i++) {
            if(no % i == 0) System.out.print(" "+i);
        }
    }

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

    public static int kthFactor(int no, int k){
        if (no == 0) return -1;
        else {
            Set<Integer> list = new HashSet<>();
            for (int i = 1; i <= Math.sqrt(no); i++) {
                if (no % i == 0)
                    if (no / i == i)
                        list.add(i);
                    else {
                        list.add(i);
                        list.add(no / i);
                    }
            }
            if(!list.isEmpty() && k <= list.size()) return (int) list.toArray()[k-1];
        }
        return -1;
    }

}
