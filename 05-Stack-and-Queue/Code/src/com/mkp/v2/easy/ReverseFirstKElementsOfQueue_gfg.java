package src.com.mkp.v2.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue_gfg {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        if(k <= 1) return q;
        Stack<Integer> stack=new Stack<>();
        for(int i = 0 ; i < k ; i++)
            stack.add(q.poll());
        Queue<Integer> temp=q;
        q=new LinkedList<>();
        while(!stack.isEmpty())
            q.add(stack.pop());
        while(!temp.isEmpty())
            q.add(temp.poll());
        return q;
    }
}
