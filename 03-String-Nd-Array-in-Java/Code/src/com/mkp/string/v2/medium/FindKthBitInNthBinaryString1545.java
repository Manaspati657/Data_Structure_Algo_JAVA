package src.com.mkp.string.v2.medium;

public class FindKthBitInNthBinaryString1545 {
    public static void main(String[] args) {
        // String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(findKthBit(4, 13));
    }

    // this problem description is different from gfg findKthBit . please thoroughly read the description

    public static char findKthBit(int n, int k) {
        if(n == 1) return '0';
        int length=(int) Math.pow(2,n)-1,middle=(length+1)/2;
        if(k == middle) return '1';
        else if(k < middle) return findKthBit(n-1, k);
        else return findKthBit(n-1, length-k+1) == '0' ? '1' : '0' ;
    }
}
