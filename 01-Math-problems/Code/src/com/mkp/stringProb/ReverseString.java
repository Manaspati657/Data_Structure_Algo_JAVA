package src.com.mkp.stringProb;

public class ReverseString {
    public static void main(String[] args) {

        String str="manas";
        System.out.println(reverseString2(str));
    }


    private static String reverseString2(String str) {
        if (str.isEmpty()) return "";
        StringBuilder revStr= new StringBuilder();
        for (int i = str.length()-1; i >=0 ; i--) {
            revStr.append(str.charAt(i));
        }
        return revStr.toString();
    }

    private static String reverseString(String str) {
        if (str.isEmpty()) return "";
        StringBuilder revStr=new StringBuilder();

        for (int i = str.length(); i > 0; i--) {
            revStr.append(str.charAt(i-1));
        }
        return revStr.toString();
    }
}
