package src.com.mkp.theory;

public class ReverseAString {
    public static void main(String[] args) {
        String str="manas kumar pati";
        System.out.println(reverseStringWithString(str));
        System.out.println(reverseStringWithStringBuilder(str));
    }

//    Time complexity: O(N) - The append method take constant time O(1).
    private static String reverseStringWithStringBuilder(String str) {
        StringBuilder sb=new StringBuilder();
        for (int i = str.length()-1; i >=0 ; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

//    Time Complexity : O(N^2) - because concatenation of String takes O(N^2) time .
//    The reason is that in Java strings are immutable, and as a result, each time you append
//    to the string new string object is created.
//    The loop in the code does 1 + 2 + 3 + ... + N = N * (N + 1) / 2 = O(N2) operations.
    private static String reverseStringWithString(String str) {
        String rev="";
        for (int i = str.length()-1; i >=0 ; i--) {
            rev+=str.charAt(i);
        }
        return rev;
    }
}
