package src.com.mkp.array.v2.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddToArrayFormOfInteger989 {
    public static void main(String[] args) {
//        int[] num = {2,7,4};
//        int k = 181;
        int[] num = {9,9,9,9,9,9,9,9,9,9};
        int k = 1;
        System.out.println(addToArrayForm(num,k));
    }
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans=new ArrayList<>();
        long sum=0;
        for(int i = 0 ;i < num.length;i++)
            sum=(sum*10)+num[i];
        sum +=k;
        Stack<Integer> stack=new Stack<>();
        while(sum > 0){
            int lastDigit=(int)(sum%10);
            stack.push(lastDigit);
            sum/=10;
        }
        while(!stack.isEmpty()){
            ans.add((stack.pop()));
        }
        return ans;
    }
}
