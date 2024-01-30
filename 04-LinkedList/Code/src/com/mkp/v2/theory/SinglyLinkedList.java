package src.com.mkp.v2.theory;

import java.util.StringJoiner;

public class SinglyLinkedList<T>  {

    private Node root;
    private int size=0;


    public void insert(T value){
        if(root == null){
            root=new Node(value,null);
        }else{
            Node temp =new Node(value,root);
            root=temp;
        }
        size++;
    }

    @Override
    public String toString() {
        StringJoiner list=new StringJoiner(", ","[","]");
        if(root != null){
            Node temp=root;
            while(temp != null){
                list.add((temp.value).toString());
                temp=temp.next;
            }
        }
        return list.toString();
    }

    private class Node{
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
