package src.com.mkp.v1.theory_stack;

import java.util.StringJoiner;

public class Stack_LinkedList<T> {

    Node head;
    private Integer size;

    public Stack_LinkedList() {
        size=0;
    }

    public boolean isEmpty(){
        return head ==null;
    }

    public Integer size(){
        return size;
    }

    public void push(T value){
        Node node=new Node(value);
        if(isEmpty()){
            head=node;
        }else{
            node.next=head;
            head=node;
        }
        size++;
    }

    public T pop(){
        if(isEmpty()) return null;
        T item=head.value;
        if(head.next != null ) head=head.next;
        size--;
        return item;
    }

    public T peek(){
        if(isEmpty()) return null;
        return head.value;
    }

    @Override
    public String toString() {
        StringJoiner list=new StringJoiner(" -> ","[","]");
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
