package src.com.mkp.v1.problems;

import java.util.StringJoiner;

public class InsertItemUsingRecursion<T> {


    private Node head;
    private Node tail;

    private Integer size;

    public InsertItemUsingRecursion() {
        this.size = 0;
    }

    public boolean isEmpty(){return size == 0;}

    public void insertFirst(T item){
        Node node =new Node(item);
        node.next=head;
        head=node;
        size++;
    }

    public void insertAtIndex(T item ,int index){
        head=insertRec(item,index,head);
    }

    private Node insertRec(T item, int index, Node node){
        if(index == 0){
            Node temp=new Node(item);
            temp.next=node;
            size++;
            return temp;
        }

        if(node.next != null){
            node.next=insertRec(item, index - 1, node.next);
        }
        return node ;
    }
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringJoiner list=new StringJoiner(", ","[","]");
        Node temp=head;
        while (temp !=null ){
            list.add((temp.value).toString());
            temp=temp.next;
        }

        return list.toString();
    }

    private class Node{
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        InsertItemUsingRecursion<Integer> list=new InsertItemUsingRecursion<>();
        list.insertFirst(5);
        list.insertFirst(2);
        list.insertFirst(6);
        list.insertFirst(7);
        System.out.println(list);
        list.insertAtIndex(9,2);
        System.out.println(list);
    }
}


















