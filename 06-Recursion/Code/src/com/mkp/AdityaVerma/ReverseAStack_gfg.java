package src.com.mkp.AdityaVerma;

import java.util.Stack;

public class ReverseAStack_gfg {

    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
    public static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.size() == 1) return ;
        Integer temp=s.pop();
        reverse(s);
        insert(s,temp);
    }

    static void insert(Stack<Integer> s,Integer no)
    {
        // add your code here
        if(s.empty()){
            s.push(no);
            return ;
        }
        Integer temp=s.pop();
        insert(s,no);
        s.push(temp);
    }
}
