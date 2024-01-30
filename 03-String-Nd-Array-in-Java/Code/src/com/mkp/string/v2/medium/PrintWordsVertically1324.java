package src.com.mkp.string.v2.medium;
import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically1324 {
    public static void main(String[] args) {
        // String s = "HOWee AREff YOUg";
        String s = "TO BE OR NOT TO BE";
        System.out.println(printVertically(s));
    }

    public static List<String> printVertically(String s) {
        List<String> ans=new ArrayList<>();
        String[] sArr=s.split(" ");
        int maxLength=0;
        for (String el : sArr) {
            maxLength=Math.max(maxLength, el.length());
        }

        for (int i = 0; i < maxLength; i++) {
            StringBuilder sb=new StringBuilder();
            for (String el : sArr) {
                if(i < el.length()) sb.append(el.charAt(i));
                else sb.append(' ');
            }
            // remove extra space after the word using while loop
            while(sb.charAt(sb.length()-1) == ' ') sb.deleteCharAt(sb.length()-1);
            ans.add(sb.toString());
        }
        return ans;
    }
}
