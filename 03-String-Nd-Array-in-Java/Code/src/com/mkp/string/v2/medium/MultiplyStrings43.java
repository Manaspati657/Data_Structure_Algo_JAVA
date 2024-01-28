package src.com.mkp.string.v2.medium;

import java.util.Arrays;

public class MultiplyStrings43 {
    public static void main(String[] args) {
        String  num1 = "123", num2 = "456";
        System.out.println(multiply(num1,num2));
    }

    /*
    *
    *   Note if we multiply 2 number their result digit never more than sum of digits of those numbers.
    * */

//    3 ms running time
    public static String multiply(String num1, String num2) {
        int m=num1.length(),n=num2.length();
        int[] product=new int[m+n];
        for (int i = m-1; i >= 0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
//              ASCII value of '0' start from 48 if we subtract any other character from it, we get the digit .
                int mul= product[i+j+1] + (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                product[i+j+1]= mul % 10;
                product[i+j]+=mul/10;
            }
        }
//      add result into StringBuilder
        StringBuilder result=new StringBuilder();
        for (int j : product)  result.append(j);
//      remove 0 from front;
        while(result.length() != 0 && result.charAt(0) =='0') result.deleteCharAt(0);
        return (result.length() == 0) ? "0" : new String(result);
    }

//    2 ms
    public static String multiplyV1(String num1, String num2) {
        int m=num1.length(),n=num2.length();
        int[] product=new int[m+n];
        for (int i = m-1; i >= 0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
//              ASCII value of '0' start from 48 if we subtract any other character from it, we get the digit .
                product[i+j+1]+= (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }

//      forward carry to back.
        int carry = 0;
        for (int i = product.length-1; i >=0 ; i--) {
            int temp=(product[i]+carry) % 10;
            carry=(product[i]+carry)/10;
            product[i]=temp;
        }
//      add result into StringBuilder
        StringBuilder result=new StringBuilder();
        for (int j : product)  result.append(j);
//      remove 0 from front;
        while(result.length() != 0 && result.charAt(0) =='0') result.deleteCharAt(0);
        return (result.length() == 0) ? "0" : new String(result);
    }
}
