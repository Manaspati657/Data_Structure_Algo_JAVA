package src.com.mkp.v1.theory_queue;

import java.util.StringJoiner;

public class Queue_LinkedList<T> {


    private Node head,tail;
    private Integer size;

    public Queue_LinkedList(){
        size=0;
    }
    public boolean isEmpty(){ return head == null;}
    public Integer size(){return size;}

    public void enqueue(T item){
        Node node=new Node(item);
        if(isEmpty()){
            head=node;
            tail=head;
        }else{
            tail.next=node;
            tail=node;
        }
        size++;
    }

    public T dequeue(){
        if(isEmpty()) return null;
        T item=head.value;
        head=head.next;
        size--;
        return item;
    }


    public T peek(){
        if(isEmpty()) return null;
        return head.value;
    }

    @Override
    public String toString() {
        StringJoiner list=new StringJoiner(" <- ","[","]");
        Node temp=head;
        while (temp  != null){
            list.add(temp.value.toString());
            if(temp.next == null) break;
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
}
