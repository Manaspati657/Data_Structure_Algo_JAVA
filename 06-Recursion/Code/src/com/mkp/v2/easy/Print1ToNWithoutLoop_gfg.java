package src.com.mkp.v2.easy;

public class Print1ToNWithoutLoop_gfg {
    public static void main(String[] args) {
        printNos(10);
    }

    public static void printNos(int N)
    {
        //Your code here
        if(N == 0) return;
        printNos(N-1);
        System.out.print(N+" ");
    }
}
