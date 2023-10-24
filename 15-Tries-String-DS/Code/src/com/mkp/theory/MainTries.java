package src.com.mkp.theory;

import java.util.Arrays;

public class MainTries {
    public static void main(String[] args) {
        String[] s={"mkp","mkpati","axd","xyz","abc","pqr","mno"};
        Tries tr=new Tries();
        for (int i = 0; i < s.length; i++) {
            tr.put(s[i]);
        }

        System.out.println(tr.search("xyz"));
        tr.remove("xyz");
    }
}
