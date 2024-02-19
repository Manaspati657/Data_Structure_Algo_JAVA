package src.com.mkp.v2.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues225 {

    Queue<Integer> q,temp;

    public ImplementStackUsingQueues225() {
        q=new LinkedList<>();
        temp=new LinkedList<>();
    }

    public void push(int x) {
        while(!q.isEmpty())
            temp.add(q.remove());
        q.add(x);
        while(!temp.isEmpty())
            q.add(temp.remove());
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
