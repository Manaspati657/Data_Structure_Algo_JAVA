package src.com.mkp.problems;

import java.util.StringJoiner;

public class ReverseLinkedList_ii_92 {
    public static void main(String[] args) {
        ReverseLinkedList_ii_92 list=new ReverseLinkedList_ii_92();
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

    }

    private static Node head;

    private Integer size;

    public ReverseLinkedList_ii_92() {
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
