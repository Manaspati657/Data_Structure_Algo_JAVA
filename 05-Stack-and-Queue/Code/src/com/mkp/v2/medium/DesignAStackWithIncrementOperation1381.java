package src.com.mkp.v2.medium;

public class DesignAStackWithIncrementOperation1381 {

    private Node head;
    private int size;
    private final int maxSize;

    public DesignAStackWithIncrementOperation1381(int maxSize) {
        this.head=null;
        this.size=0;
        this.maxSize=maxSize;
    }

    public void push(int x) {
        if(size < maxSize ){
            head=new Node(x,head);
            size++;
        }
    }

    public int pop() {
        if(head != null){
            int val=head.val;
            head=head.next;
            size--;
            return val;
        }
        return -1;
    }

    public void increment(int k, int val) {
        int skip = (k  >= size ) ? 0 : size-k;
        Node temp=head;
        while(temp != null){
            if(skip <= 0 && k != 0){
                temp.val=temp.val+val;
                k--;
            }
            temp=temp.next;
            skip--;
        }

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
