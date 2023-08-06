package src.com.mkp.theory;

public class CircularLinkedList<T> {

    private Node first,last;
    private Integer size;

    public CircularLinkedList() {
        this.first=null;
        this.last=null;
        this.size=0;
    }

    public boolean isEmpty(){return size == 0;}
    public Integer size() {return size;}

    public void insertFirst(T item) {

    }

    private class Node{
        T item ;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }
}
