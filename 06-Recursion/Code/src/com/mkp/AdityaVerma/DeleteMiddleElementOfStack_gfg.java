package src.com.mkp.AdityaVerma;

import java.util.Stack;

public class DeleteMiddleElementOfStack_gfg {

    public static void main(String[] args) {
        Stack<Integer> s =new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        System.out.println(s);
        deleteMid(s,s.size());
        System.out.println(s);
    }

    public static void deleteMid(Stack<Integer> s, int sizeOfStack){
        // code here
        if(s.size() == (sizeOfStack+1)/2){
            s.pop();
            return;
        }
        Integer temp=s.pop();
        deleteMid(s,sizeOfStack);
        s.push(temp);
    }
}
