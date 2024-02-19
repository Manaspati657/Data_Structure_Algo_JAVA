package src.com.mkp.v2.easy;

public class MinStack155 {

    private Node head = null;
    public MinStack155() {
    }
//    ["MinStack","push","push","push","getMin","pop","top","getMin"]
//    [[],[-2],[0],[-3],[],[],[],[]]
//    null, head(-2,-2,null) , head(0,-2,firstHead), head(-3,-3,secondHead), min=-3 ,
//    pop(thirdHead), top(0),min=-2.
    public void push(int val) {
        if(head == null){
            head = new Node(val,val,null);
        }else{
            head = new Node(val,Math.min(val,head.min),head);
        }
    }

    public void pop() {
        head=head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;
        Node(int val,int min,Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }
}
