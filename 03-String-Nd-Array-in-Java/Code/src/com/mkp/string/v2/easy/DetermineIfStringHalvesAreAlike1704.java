package src.com.mkp.string.v2.easy;

public class DetermineIfStringHalvesAreAlike1704 {
    public static void main(String[] args) {
        // String s = "book";
        String s = "textbook";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        int count = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            boolean flag = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
            if (flag)
                if (i < n / 2) count++;
                else count--;
        }
        return count == 0;
    }
}
