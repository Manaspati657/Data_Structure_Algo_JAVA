package src.com.mkp.Queue_Interface;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueClass {
    public static void main(String[] args) {
        Queue<String> queue=new PriorityQueue<>();

        queue.add("manas");
        queue.add("pati");
        queue.add("mk");
        queue.add("mkp ");

        System.out.println(queue);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue);
    }
}
