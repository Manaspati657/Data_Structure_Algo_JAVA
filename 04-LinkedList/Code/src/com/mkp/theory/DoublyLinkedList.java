package src.com.mkp.theory;

import java.util.StringJoiner;

public class DoublyLinkedList<T> {

    private Node first;
    private Integer size;

    public DoublyLinkedList() {
        this.size = 0;
    }
    public boolean isEmpty(){return size == 0;}
    public int size(){return size;}

    private Node getNodeByIndex(int index){
        Node temp =first;
        int i=0;
        while (temp != null){
            if(i == index) return temp;
            temp=temp.next;
            i++;
        }
        return null;
    }

    private Node findNode(T item){
        Node temp =first;
        while (temp != null){
            if(temp.item == item) return temp;
            temp=temp.next;
        }
        return null;
    }


    public T deleteFirst(){
        if(isEmpty()) return null;
        T item =first.item;
        first=first.next;
        first.prev=null;
        size--;
        return item;
    }

    public T deleteLast(){
        if(size == 1) return deleteFirst();
        Node last=getNodeByIndex(size-2);
        T item=null;
        if(last != null) {
            if(last.next != null) {
                last.next.prev=null;
                item=last.next.item;
            }
            last.next=null;
            size--;
        }
        return item;
    }

    public T delete(int index){
        if(index == 0) return deleteFirst();
        if(index == size-1) return deleteLast();
        if(index >= size) return null;
        Node prev=getNodeByIndex(index-1);
        T item=null;
        if(prev !=null){
            item =prev.next.item;
            prev.next.next.prev=prev;
            prev.next=prev.next.next;
            size--;
        }
        return item;
    }

    // Time complexity:: O(1)
    public void insertFirst(T item){
        Node node =new Node(item);
        if(!isEmpty()) first.prev=node;
        node.next=first;
        first=node;
        size++;
    }

//     Time complexity:: O(size of linkedList) --> bcz we have not maintained the last node so
//     we have to get last node loop is used
    public void insertLast(T item){
        if(isEmpty()) {
            insertFirst(item);
            return;
        }
        Node node =new Node(item);
        Node prev=getNodeByIndex(size-1);
        node.prev=prev;
        if (prev != null) prev.next=node;
        size++;
    }

    public void insertAtIndex(T item ,int index){
        if(isEmpty() || index >= size) {
            insertLast(item);
            return;
        }
        Node node =new Node(item);
        Node prev=getNodeByIndex(index-1);
        if(prev != null){
                node.next=prev.next;
                if(prev.next != null) prev.next.prev=node;
                prev.next=node;
                node.prev=prev;
        }
        size++;
    }
    public void insert(T item){insertFirst(item);}

    public void insertAfterItem(T item, T after) {
        Node prev=findNode(after);
        if(prev==null) {
            System.out.println(after +" doesn't exist in node .");
            return;
        }
        Node node =new Node(item);
        node.next=prev.next;
        if(prev.next != null) prev.next.prev=node;
        prev.next=node;
        node.prev=prev;
        size++;
    }

    public String displayReverse(){
        StringJoiner list=new StringJoiner(", ","[","]");
        if(isEmpty()) return list.toString();

        Node temp=getNodeByIndex(size-1);
        while(temp != null){
            list.add(temp.item.toString());
            temp=temp.prev;
        }
        return list.toString();
    }

    @Override
    public String toString() {
        StringJoiner list=new StringJoiner(", ","[","]");
        if(isEmpty()) return list.toString();

        Node temp=first;
        while(temp != null){
            list.add(temp.item.toString());
            temp=temp.next;
        }
        return list.toString();
    }



    private class Node{
        T item ;
        Node next;
        Node prev;

        public Node(T item) {
            this.item = item;
        }
    }
}
