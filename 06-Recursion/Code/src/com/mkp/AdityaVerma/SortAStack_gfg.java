package src.com.mkp.AdityaVerma;

import java.util.Stack;

public class SortAStack_gfg {
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(2);
        s.push(6);
        s.push(3);
        s.push(1);
        s.push(9);
        System.out.println(s);
        helper(s);
        System.out.println(s);
    }


    public static void helper(Stack<Integer> s)
    {
        if(s.empty()) return;
        Integer temp=s.pop();
        helper(s);
        insert(s,temp);
    }

    public static void insert(Stack<Integer> s,int no){
        if(s.empty() || s.peek() <= no){
            s.push(no);
            return;
        }
        int temp=s.pop();
        insert(s,no);
        s.push(temp);
    }
}
