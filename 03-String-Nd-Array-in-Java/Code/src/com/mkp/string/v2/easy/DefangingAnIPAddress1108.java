package src.com.mkp.string.v2.easy;

import java.util.Stack;

public class DefangingAnIPAddress1108 {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddrV2( "255.100.50.0"));
    }

    public static String defangIPaddrV2(String address) {
        StringBuilder ans=new StringBuilder();
        for(int i = 0;i < address.length();i++)
            ans.append(address.charAt(i) == '.' ? "[.]" : address.charAt(i));
        return ans.toString();
    }

    /*
    *   without using any predefined method or any other string builder class.
    * */
    public static String defangIPaddr(String address) {
        char[] charArr=address.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i < charArr.length;i++){
            if(charArr[i] == '.'){
                stack.push('[');
                stack.push(charArr[i]);
                stack.push(']');
            }else{
                stack.push(charArr[i]);
            }
        }
        char[] ans=new char[stack.size()];
        for(int i = ans.length-1;i >= 0 ;i--)
            ans[i]=stack.pop();
        return new String(ans);
    }
}
