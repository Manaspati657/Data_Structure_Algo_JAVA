package src.com.mkp.v2.easy;

public class ImplementStackUsingQueues225_with1Queue {
    private Node head,tail;
    private int size;

    public ImplementStackUsingQueues225_with1Queue() {
        head=null;
        tail=null;
        size=0;
        // implement with 1 queue when we insert it we have to pull from one end push it to anther end .
    }

    public void push(int x) {
        if(size == 0){
            head = new Node(x);
            tail = head;
            size++;
        }else {
            int temp = size;
            tail.next = new Node(x);
            tail = tail.next;
            size++;
            while( temp != 0){
                int headTemp=pop();
                tail.next = new Node(headTemp);
                tail = tail.next;
                size++;
                temp--;
            }

        }
    }

    public int pop() {
        int val=head.val;
        if(head.next != null) head = head.next;
        size--;
        return val;
    }

    public int top() {
        return head.val;
    }

    public boolean empty() {
        return size == 0;
    }

    protected class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
}
