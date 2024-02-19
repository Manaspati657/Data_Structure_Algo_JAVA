package src.com.mkp.v2.medium;

public class DesignCircularQueue622_usingLinkedList {
    /*
    * using linked list.
    *
    * */

    private final int maxSize;
    private int size;
    private Node head,tail;

    public DesignCircularQueue622_usingLinkedList(int k) {
        this.maxSize=k;
        this.size=0;
        this.head=null;
        this.tail=null;
    }

    public boolean enQueue(int value) {
        if(size == 0){
            head=new Node(value,null);
            tail=head;
            head.next=tail;
            size++;
            return true;
        }else if(size < maxSize){
            tail.next=new Node(value,head);
            tail=tail.next;
            size++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(size > 0){
            if(size == 1){
                head = null;
                tail=null;
            }else{
                tail.next=head.next;
                head=head.next;
            }
            size--;
            return true;
        }
        return false;
    }

    public int Front() {
        return (size == 0) ? -1 : head.val;
    }

    public int Rear() {
        return (size == 0) ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return maxSize == size;
    }

    protected class Node{
        int val;
        Node next;
        Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }
}
