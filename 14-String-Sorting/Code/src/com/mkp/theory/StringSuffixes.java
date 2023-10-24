package src.com.mkp.theory;

import java.util.Arrays;

public class StringSuffixes {
    public static void main(String[] args) {
        String str="ManasKumarPati";
        System.out.println(Arrays.toString(createsSuffixesWithString(str)));
        System.out.println(Arrays.toString(createsSuffixesStringWithStringBuilder(str)));
    }

//    Time Complexity: O(N(for loop)*N(for substring)) =O(N^2) - The time complexity of the
//    StringBuilder substring() method is O(n),where n is the length of the original string.
//    This is because the substring() method must copy the characters from the start index to
//    the end index, which requires O(n) time.
    private static String[] createsSuffixesStringWithStringBuilder(String str) {
        int N=str.length();
        String[] suffixes=new String[N];
        StringBuilder sb=new StringBuilder(str);
        for (int i = 0; i < N; i++) {
            suffixes[i]=sb.substring(i,N);
        }
        return suffixes;
    }

    //    Time Complexity: O(N(for loop)) - The substring() method takes constant time O(1)
    //    to return the substring.

    private static String[] createsSuffixesWithString(String str) {
        int N=str.length();
        String[] suffixes=new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i]=str.substring(i,N);
        }
        return suffixes;
    }
}
