package src.com.mkp.v1.problems;

import java.util.StringJoiner;

public class ReverseLinkedListIterative206 {
    public static void main(String[] args) {
        ReverseLinkedListIterative206 list=new ReverseLinkedListIterative206();
        list.insertFirst(9);
        list.insertFirst(2);
        list.insertFirst(6);
        list.insertFirst(4);
        list.insertFirst(1);
        System.out.println(list);
        System.out.println("After reverse :: ");
        list.reverse();
        System.out.println(list);
    }

    private void reverse() {
        Node prev=null;
        Node present=head;
        Node next=present.next;
        while (present != null){
            present.next=prev;
            prev=present;
            present=next;
            if(next != null) next=next.next;
        }
        head=prev;
    }

    private static Node head;

    private Integer size;

    public ReverseLinkedListIterative206() {
        this.size = 0;
    }

    public boolean isEmpty(){return size == 0;}

    public void insertFirst(Integer item){
        Node node =new Node(item);
        node.next=head;
        head=node;
        size++;
    }

    @Override
    public String toString() {
        StringJoiner list=new StringJoiner(", ","[","]");
        Node temp=head;
        while (temp !=null){
            list.add((temp.value).toString());
            temp=temp.next;
        }

        return list.toString();
    }


    private class Node{
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
        }

    }
}
