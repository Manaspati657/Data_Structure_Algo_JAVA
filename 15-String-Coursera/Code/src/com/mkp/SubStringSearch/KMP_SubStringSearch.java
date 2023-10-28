package src.com.mkp.SubStringSearch;

import java.util.Arrays;

public class KMP_SubStringSearch {
    public static void main(String[] args) {
//        String txt="manasakumarpati";
//        String txt="ranjankumarbehara";
//        String pat="pati";
//        String pat="behara";
//        String txt = "ABABDABACDABABCABAB";
//        String pat = "ABABCABAB";
        String txt = "mississippi";
        String pat = "issip";
        int[] lps=new int[pat.length()];
//        computeLPS(pat,lps);
//        System.out.println(Arrays.toString(lps));
        System.out.println(KMPSearch(txt,pat));
    }

    private static int KMPSearch(String txt, String pat) {
        int N=txt.length(),M=pat.length();
        int[] lps=new int[M];
        computeLPS(pat,lps);
        int i=0,j=0;
        while(i < N){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j==M) return i - j;
            }else{
                if(j==0) i++;
                else j=lps[j-1];
            }
        }
        return -1;
    }





    /*
    *    lps : longest proper prefix and suffix
    *
    *    ex: str="ABC";
    *    prefix : A,AB
    *    suffix: C,BC,ABC,
    *
    * */

    private static void computeLPS(String subStr,int[] lps) {
        int len=0,M=subStr.length();
        if(subStr.isEmpty()) return;
        lps[0]=0;
        for (int i = 1; i < M; ) {
             if(subStr.charAt(i) == subStr.charAt(len)){
                len=len+1;
                lps[i]=len;
                i++;
            }else{
                 if(len == 0){
                     lps[i]=0;
                     i++;
                 }else{
                     len=lps[len-1];
                 }
            }
        }
    }


}
