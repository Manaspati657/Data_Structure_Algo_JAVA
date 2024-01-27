package src.com.mkp.string.v2.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {
    public static void main(String[] args) {
//        String s = "LVIII";
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    /*
    *  optimized approach if the constraints mention that It is guaranteed that s is a valid roman numeral.
    *  then we can just check if current character is lesser than their front character then we subtract it.
    * */

    public static int romanToInt(String s) {
        Map<Character,Integer> romanValues=new HashMap<>();
        romanValues.put('I',1);
        romanValues.put('V',5);
        romanValues.put('X',10);
        romanValues.put('L',50);
        romanValues.put('C',100);
        romanValues.put('D',500);
        romanValues.put('M',1000);
        int sum=0,n=s.length(),i=0;
        while ( i < n) {
            char ch=s.charAt(i);
            /*
             *  Note :
             * i)   I can be placed before V (5) and X (10) to make 4 and 9.
             * ii)  X can be placed before L (50) and C (100) to make 40 and 90.
             * iii) C can be placed before D (500) and M (1000) to make 400 and 900.
             * */
            if(i+1 < n && (romanValues.get(ch) < romanValues.get(s.charAt(i+1)))){
                sum+= romanValues.get(s.charAt(i+1)) - romanValues.get(ch);
                i+=2;
            }else{
                sum+=romanValues.get(ch);
                i++;
            }
        }

        return sum;
    }

    /*
    *
    *   This approach is simple and straight forward as problem description.if in the constraints mention that
    *   may be romain format will be wrong then we used this approach and ans will be right.
    *
    * */
    public static int romanToIntV1(String s) {
        Map<Character,Integer> romanValues=new HashMap<>();
        romanValues.put('I',1);
        romanValues.put('V',5);
        romanValues.put('X',10);
        romanValues.put('L',50);
        romanValues.put('C',100);
        romanValues.put('D',500);
        romanValues.put('M',1000);
        int sum=0,n=s.length(),i=0;
        while ( i < n) {
            char ch=s.charAt(i);
            /*
            *  Note :
            * i)   I can be placed before V (5) and X (10) to make 4 and 9.
            * ii)  X can be placed before L (50) and C (100) to make 40 and 90.
            * iii) C can be placed before D (500) and M (1000) to make 400 and 900.
            * */
            if(ch == 'I' && i+1 < n && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                sum+= romanValues.get(s.charAt(i+1)) - 1;
                i+=2;
            }
            else if(ch == 'X' && i+1 < n && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                sum+= romanValues.get(s.charAt(i+1)) - 10;
                i+=2;
            }
            else if(ch == 'C' && i+1 < n && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                sum+= romanValues.get(s.charAt(i+1)) - 100;
                i+=2;
            }else{
                sum+=romanValues.get(ch);
                i++;
            }
        }

        return sum;
    }
}
