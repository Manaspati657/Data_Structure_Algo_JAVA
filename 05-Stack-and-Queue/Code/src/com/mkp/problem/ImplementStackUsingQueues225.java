package src.com.mkp.problem;

import src.com.mkp.theory_queue.Queue_Array;
import src.com.mkp.theory_queue.Queue_LinkedList;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ImplementStackUsingQueues225 {

    public static void main(String[] args) {
        ImplementStackUsingQueues225 myStack = new ImplementStackUsingQueues225();
        myStack.push(1);
        myStack.push(2);
        System.out.println( myStack.top()); // return 2
        myStack.pop(); // return 2
        System.out.println( myStack.top());
        myStack.empty(); // return False
    }

//    Queue<Integer> q1;
//    Queue<Integer> q2;

    Queue_LinkedList<Integer> q1;
    Queue_LinkedList<Integer> q2;

    public ImplementStackUsingQueues225() {
//        q1=new LinkedList<>();
//        q2=new LinkedList<>();
        q1=new Queue_LinkedList<>();
        q2=new Queue_LinkedList<>();
    }

    public void push(int x) {
//        if(q2.isEmpty()) q2.add(x);
        if(q2.isEmpty()) q2.enqueue(x);
        else {
            while (!q2.isEmpty()){
//                q1.add((q2.remove()));
                q1.enqueue((q2.dequeue()));
            }
//            q2.add(x);
            q2.enqueue(x);
            while(!q1.isEmpty()){
//                q2.add((q1.remove()));
                q2.enqueue((q1.dequeue()));
            }
        }
    }

    public int pop() {
//        if(!q2.isEmpty()) return q2.remove();
        if(!q2.isEmpty()) return q2.dequeue();
        else return -1;
    }

    public int top() {
        if(!q2.isEmpty()) return q2.peek();
        else return -1;
    }

    public boolean empty() {
        return q2.isEmpty();
    }
}
