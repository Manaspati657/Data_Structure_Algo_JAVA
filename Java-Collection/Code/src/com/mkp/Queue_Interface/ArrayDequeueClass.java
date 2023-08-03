package src.com.mkp.Queue_Interface;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeueClass {
    public static void main(String[] args) {
        Deque<Integer> queue=new ArrayDeque<>();

        queue.addFirst(2);
        queue.addFirst(3);
        queue.addFirst(4);
        queue.addLast(6);
        queue.addLast(7);
        queue.addLast(8);

        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peekFirst());
        System.out.println(queue.peekLast());
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
