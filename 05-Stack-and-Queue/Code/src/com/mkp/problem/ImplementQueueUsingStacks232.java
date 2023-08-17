package src.com.mkp.problem;

import java.util.Stack;

public class ImplementQueueUsingStacks232 {

    public static void main(String[] args) {
        ImplementQueueUsingStacks232 myQueue = new ImplementQueueUsingStacks232();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.peek());
        myQueue.empty(); // return false
    }

    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImplementQueueUsingStacks232() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void push(int x) {
        if(s2.isEmpty()){
            s2.push(x);
        }else{
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            s2.push(x);
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
    }

    public int pop() {
        if(!s2.isEmpty()) return s2.pop();
        return -1;
    }

    public int peek() {
        if(!s2.isEmpty()) return s2.peek();
        return -1;
    }

    public boolean empty() {
        return s2.isEmpty();
    }
}
