package src.com.mkp.string.v2.easy;

import java.util.ArrayList;
import java.util.List;

public class ExcelSheetColumnTitle168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }

    public static String convertToTitle(int columnNumber) {
       StringBuilder sb=new StringBuilder();
       while(columnNumber != 0){
           sb.append((char)('A'+(columnNumber-1)%26));
           columnNumber/=26;
       }
       return sb.reverse().toString();
    }


}
