package src.com.mkp.v2.easy;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls933 {

    /*
    *
    * Creating Queue with linked list and store size in a variable
    * Time complexity of ping : O(N)
    * Space complexity: O(N)
    * Running time : 19 ms
    *
    * */


    private Node front;
    private Node end;
    private int size;

    public NumberOfRecentCalls933() {
        front=null;
        end=null;
        size=0;
    }

    public int ping2(int t) {
        if(size == 0){
            front=new Node(t);
            end=front;
            size++;
            return 1;
        }else{
            // insert new element in the end;
            end.next=new Node(t);
            end=end.next;
            size++;
            // search for any elements in queue out of range .
            int startRange=t-3000;
            while(front != null && front.timeStamp < startRange){
                front = front.next;
                size--;
            }

            return size;
        }
    }

    protected class Node{
        int timeStamp;
        Node next;
        Node(int timeStamp){
            this.timeStamp=timeStamp;
        }
    }




    /*
    * using inbuilt class Queue
    *
    * Time complexity of ping : O(N)
    * Space complexity: O(N)
    * Running time : 21 ms
    *
    * */

    Queue<Integer> queue;

//    public NumberOfRecentCalls933() {
//        queue=new LinkedList<>();
//    }

    public int ping(int t) {
        int startedRange=t-3000;
        while(!queue.isEmpty() && queue.peek() < startedRange)
            queue.poll();
        queue.add(t);
        return queue.size();
    }
}
