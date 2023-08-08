package src.com.mkp.problems;

import java.util.StringJoiner;

public class MiddleOfTheLinkedList876 {

//    https://leetcode.com/problems/middle-of-the-linked-list/description/

    public static void main(String[] args) {
        MiddleOfTheLinkedList876 list=new MiddleOfTheLinkedList876();
        list.insertLast(9);
        list.insertLast(2);
        list.insertLast(6);
        list.insertLast(4);
        list.insertLast(1);
//        list.insertLast(8);
        System.out.println(list);
        System.out.println("middle ::"+middle(list));
    }


    public static int middle(MiddleOfTheLinkedList876 list){
        Node s=list.head;
        Node f=list.head;

        while(f != null && f.next != null ){
            s=s.next;
            f=f.next.next;
        }

        return s.value;
    }


    private Node head;
    private Node tail;

    private Integer size;

    public MiddleOfTheLinkedList876() {
        this.size = 0;
    }

    public boolean isEmpty(){return size == 0;}

    public void connectNode(Integer item,Node connect){
        if(isEmpty()) {
            insertFirst(item);
            return;
        }
        Node node =new Node(item);
        tail.next=node;
        if(connect != null) node.next=connect;
        tail=node;
        size++;
    }



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
