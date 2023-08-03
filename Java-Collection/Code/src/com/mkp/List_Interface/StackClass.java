package src.com.mkp.List_Interface;

import java.util.Stack;

public class StackClass {
    public static void main(String[] args) {
        Stack<Integer> list=new Stack<>();

        list.push(2);
        list.push(22);
        list.push(23);
        list.push(24);
        System.out.println(list);
        System.out.println(list.peek());
        System.out.println(list.pop());
        System.out.println(list);
        System.out.println(list.search(2));
    }
}
