package src.com.mkp.theory_queue;

public class Main_Queue {
    public static void main(String[] args) {
        //        Queue using LinkedList and its time complexity and space complexity
        /*
         * Time Complexity: O(1), for all enqueue(), dequeue(), and peek(),
         * as we are not performing any kind of traversal over the list.
         * We perform all the operations through the current pointer only.
         * Auxiliary Space: O(N), where N is the size of the Queue
         *
         * */
        /*Queue_LinkedList<Integer> list=new Queue_LinkedList<>();
        list.enqueue(2);
        list.enqueue(5);
        System.out.println("dequeue : "+list.dequeue());
        System.out.println("dequeue : "+list.dequeue());
        System.out.println("dequeue : "+list.dequeue());
        list.enqueue(6);
        list.enqueue(3);
        list.enqueue(1);
        System.out.println(list);
        System.out.println("peek : "+list.peek());
        System.out.println("dequeue : "+list.dequeue());
        System.out.println(list);
        list.enqueue(8);
        list.enqueue(9);
        System.out.println("peek: "+list.peek());
        System.out.println(list);
        System.out.println("size : "+list.size());*/

        Queue_Array<Integer> list=new Queue_Array<>();
        list.enqueue(2);
        list.enqueue(5);
        System.out.println("dequeue : "+list.dequeue());
        System.out.println("dequeue : "+list.dequeue());
        System.out.println("dequeue : "+list.dequeue());
        list.enqueue(6);
        list.enqueue(3);
        list.enqueue(1);
        System.out.println(list);
        System.out.println("peek : "+list.peek());
        System.out.println("dequeue : "+list.dequeue());
        System.out.println(list);
        list.enqueue(8);
        list.enqueue(9);
        list.enqueue(88);
        list.enqueue(23);
        list.enqueue(16);
        list.enqueue(28);
        list.enqueue(10);
        list.enqueue(11);
        System.out.println("peek: "+list.peek());
        System.out.println(list);
        System.out.println("dequeue : "+list.dequeue());
        System.out.println("dequeue : "+list.dequeue());
        System.out.println("dequeue : "+list.dequeue());
        System.out.println("dequeue : "+list.dequeue());
        System.out.println("dequeue : "+list.dequeue());
        System.out.println("dequeue : "+list.dequeue());
        System.out.println("dequeue : "+list.dequeue());

        System.out.println("size : "+list.size());

    }
}
