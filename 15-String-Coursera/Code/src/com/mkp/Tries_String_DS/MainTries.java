package src.com.mkp.Tries_String_DS;

public class MainTries {
    public static void main(String[] args) {
//        String[] s={"mkp","mkpati","axd","xyz","abc","pqr","mno"};
        String[] s={"mkp","xyz","abc","pqr","mno"};
//        R_way_Tries tr=new R_way_Tries();
//        for (int i = 0; i < s.length; i++) {
//            tr.put(s[i]);
//        }
//
//        System.out.println(tr.search("xyz"));
//        tr.remove("xyz");

        Ternary_search_tree tr=new Ternary_search_tree();
        for (int i = 0; i < s.length; i++) {
            tr.put(s[i]);
        }

        System.out.println(tr.search("xyz"));
        System.out.println(tr.search("mkpa"));
//        tr.remove("xyz");
    }
}
