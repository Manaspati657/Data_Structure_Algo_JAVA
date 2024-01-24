package src.com.mkp.v1.String;

import java.util.ArrayList;

public class SubSequencesString {
    public static void main(String[] args) {
        String s="abc";
//        subSeq("",s);
        System.out.println(subSeqArrayList("",s));
//        subseqAscii("",s);
    }

    private static ArrayList<String> subSeqArrayList(String ip, String op) {
        if(op.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(ip);
            return list;
        }
        char ch=op.charAt(0);
        ArrayList<String> left=subSeqArrayList(ip+ch,op.substring(1));
        ArrayList<String> right=subSeqArrayList(ip,op.substring(1));
        left.addAll(right);
        return left;
    }

    static void subseqAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseqAscii(p + ch, up.substring(1));
        subseqAscii(p, up.substring(1));
        subseqAscii(p + (int)ch, up.substring(1));
    }


    private static void subSeq(String ip, String op) {
        if(op.isEmpty()){
            System.out.println(ip);
            return;
        }
        char ch=op.charAt(0);
        subSeq(ip+ch,op.substring(1));
        subSeq(ip,op.substring(1));
    }
}
