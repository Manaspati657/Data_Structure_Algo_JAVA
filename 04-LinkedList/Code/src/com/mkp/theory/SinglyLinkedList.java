package src.com.mkp.theory;

import java.util.StringJoiner;

public class SinglyLinkedList<T> {

    private Node head;
    private Node tail;

    private Integer size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public boolean isEmpty(){return size == 0;}
    private Node getNodeByIndex(int index){
        Node temp=head;
        int i =0;
        while(temp != null){
            if(i== index) return temp;
            temp=temp.next;
            i++;
        }
        return null;
    }

    public T deleteFirst(){
        if(isEmpty()) return null;
        T item=head.value;
        head=head.next;
        size--;
        return item;
    }
    public T deleteLast(){
        if (size==1) return deleteFirst();
        T item=tail.value;
        Node lastPrev=getNodeByIndex(size-2);
        if(lastPrev != null){
            lastPrev.next=null;
            tail=lastPrev;
        }
        size--;
        return item;
    }
    public T delete(){
        return deleteLast();
    }
    public T delete(int index){
        if( index < 1) return deleteFirst();
        if(index == size-1) return deleteLast();
        if(index > size -1) return null;
        Node prev=getNodeByIndex(index-1);
        T item=null;
        if(prev != null){
            item=prev.next.value;
            prev.next=prev.next.next;
            size--;
        }
        return item;
    }
    public void insert(T item ,int index){
        if ( isEmpty() || index >= size ) {
            insertLast(item);
            return;
        }
        Node prev=getNodeByIndex(index-1);
        Node node=new Node(item);
        if (prev != null) {
            node.next= prev.next;
            prev.next=node;
        }
        size++;
    }
// Time complexity:: O(1)
    public void insertFirst(T item){
        Node node =new Node(item);
        node.next=head;
        head=node;
        if(isEmpty()) tail=head;
        size++;
    }

//  if only insert call then used insert first
    public void insert(T item){
        this.insertFirst(item);
    }

    // Time complexity:: O(1) -- bcz we maintain last node also if we are not used
    // last then we have to find last that cost us O(size of node)
    public void insertLast(T item){
        if(isEmpty()) {
            insertFirst(item);
            return;
        }
        Node node =new Node(item);
        tail.next=node;
        tail=node;
        size++;
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

    public void removeDuplicates() {
        if(head != null){
            Node temp=head;
            while(temp.next != null){
                if(temp.value==temp.next.value){
                    temp.next=temp.next.next;
                    size--;
                }else{
                    temp=temp.next;
                }
            }
        }
    }

    private class Node{
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

    }

}
