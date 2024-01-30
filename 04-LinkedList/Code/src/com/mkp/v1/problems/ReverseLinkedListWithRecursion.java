package src.com.mkp.v1.problems;

import java.util.StringJoiner;

public class ReverseLinkedListWithRecursion {

    public static void main(String[] args) {
        ReverseLinkedListWithRecursion list=new ReverseLinkedListWithRecursion();
        list.insertLast(9);
        list.insertLast(2);
        list.insertLast(6);
        list.insertLast(4);
        list.insertLast(1);
        System.out.println(list);
        System.out.println("After reverse :: ");
        list.reverse();
        System.out.println(list);
    }

    public static void reverse(){
        reverse(head);
    }

//    reverse with and first and last node
    public static void reverse(Node node){
        if(node.next == null){
            head=node;
            return;
        }
        reverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }

//    reverse without tail only with head gfg
    public static void reverse2(){
        reverse(head);
    }


    private static Node head;
    private static Node tail;

    private Integer size;

    public ReverseLinkedListWithRecursion() {
        this.size = 0;
    }

    public boolean isEmpty(){return size == 0;}


    public void insertLast(Integer item){
        if(isEmpty()) {
            insertFirst(item);
            return;
        }
        Node node =new Node(item);
        tail.next=node;
        tail=node;
        size++;
    }

    public void insertFirst(Integer item){
        Node node =new Node(item);
        node.next=head;
        head=node;
        if(isEmpty()) tail=head;
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
