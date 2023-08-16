package src.com.mkp.problem;

public class MinStack155 {

    public static void main(String[] args) {
        MinStack155 stack=new MinStack155();
        stack.push(1);
        stack.push(10);
        stack.push(2);
        stack.push(-4);
        stack.push(0);
        stack.push(6);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
    }

    private Node head;


    public MinStack155() {
        head=null;
    }

    public void push(int val) {
        if(head==null){
            head=new Node(val,val,null);
        }else{
            head=new Node(val,Math.min(val,head.min),head);
        }
    }

    public void pop() {
        head=head.next;
    }

    public int top() {
        return head.item;
    }

    public int getMin() {
        return head.min;
    }

    class Node {
        Integer item ;
        Node next;
        Integer min;
        Node(Integer item, Integer min, Node next){
            this.item=item;
            this.min=min;
            this.next=next;

        }
    }
}
