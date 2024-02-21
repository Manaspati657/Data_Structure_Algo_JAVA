package src.com.mkp.v2.easy;

public class FirstUppercaseLetterInAString_gfg {
    public static void main(String[] args) {
        String s = "geeksforgeeKs";
        System.out.println(firstUppercaseLetter(s));
        System.out.println(firstUppercaseLetterRecursive(s));
    }

    public static char firstUppercaseLetter(String s){
        for (char ch : s.toCharArray()) {
            if(ch >= 'A' && ch <= 'Z'){
                return ch;
            }
        }
        return 0;
    }
    public static char firstUppercaseLetterRecursive(String s){

        return helper(s,0);
    }

    private static char helper(String s, int i) {
        if(i == s.length()) return 0;

        if(s.charAt(i) >= 'A' && s.charAt(i) <='Z') return s.charAt(i);
        return helper(s, i+1);
    }
}
