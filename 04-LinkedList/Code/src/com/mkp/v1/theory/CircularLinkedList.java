package src.com.mkp.v1.theory;

import java.util.StringJoiner;

public class CircularLinkedList<T> {

    private Node head,tail;
    private Integer size;

    public CircularLinkedList() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public boolean isEmpty(){return size == 0;}
    public Integer size() {return size;}

    public void insert(T item) {
        Node node =new Node(item);
        if(head == null){
            tail=node;
            head=node;
            size++;
            return;
        }
        node.next=head;
        tail.next=node;
        head=node;
        size++;
    }

    public T delete(T item){
        Node node =head;
        if(head == null){
            return null;
        }

        if(head == tail ){
            if(head.item == item){
                head=null;
                tail=null;
                size--;
                return item;
            }else{
                return null;
            }
        }

        if(node.item == item ){
            head=head.next;
            tail.next=head;
            size--;
            return item;
        }

        do {
            Node nextNode=node.next;
            if(nextNode.item ==item){
                node.next=nextNode.next;
                size--;
                return item;
            }
            node=node.next;
        }while (node != head);

        return null;
    }
    @Override
    public String toString() {
        StringJoiner list=new StringJoiner(", ","[","]");
        Node temp=head;
        if(head != null){
            do {
                list.add(temp.item.toString());
                if(temp.next != null) temp=temp.next;
            }while (temp != head);
        }
        return list.toString();
    }

    private class Node{
        T item ;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }
}
