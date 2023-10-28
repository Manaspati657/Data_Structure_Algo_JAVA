package src.com.mkp.SubStringSearch;

public class Brute_Force_SubStringSearch {
    public static void main(String[] args) {
        String str="manasakumarpati";
//        String str="ranjankumarbehara";
        String subStr="pati";
//        String subStr="behara";
        System.out.println(searchSubString(str,subStr));
    }

//    time complexity : O( N*M )

    private static int searchSubString(String str, String subStr) {
        int N=str.length(),M=subStr.length();
        for (int i = 0; i <= N-M; i++) {
            int j=0;
            for ( j= 0; j < M; j++){
                if(str.charAt(i+j) != subStr.charAt(j)) break;
            }
            if(j==M) return i;
        }
        return -1;
    }
}
