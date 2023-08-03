package src.com.mkp.Queue_Interface;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueClass {
    public static void main(String[] args) {

        Queue<Integer> queue=new LinkedList<>();

        queue.add(45);
        queue.add(6);
        queue.add(4);
        queue.add(2);

        System.out.println(queue);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue);
    }
}
