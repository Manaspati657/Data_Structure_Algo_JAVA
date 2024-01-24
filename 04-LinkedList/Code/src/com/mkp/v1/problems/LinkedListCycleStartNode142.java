package src.com.mkp.v1.problems;

import java.util.StringJoiner;

public class LinkedListCycleStartNode142 {
//https://leetcode.com/problems/linked-list-cycle-ii/description/
    public static void main(String[] args) {
        LinkedListCycleStartNode142 list=new LinkedListCycleStartNode142();
        list.insertLast(9);
        list.insertLast(2);
        list.insertLast(6);
        list.insertLast(4);
        list.insertLast(1);
//        list.connectNode(7,list.head.next.next);
        list.connectNode(8,list.head.next);
        System.out.println(list);
        System.out.println("cycle length:: "+cycleLength(list));
        System.out.println("cycle connect node:: "+detectCyecle(list));
    }

    public static int detectCyecle(LinkedListCycleStartNode142 list){
        int length=cycleLength(list);
        if(length < 0) return -1;

        Node s=list.head;
        Node f=list.head;

        while(length >0){
            s=s.next;
            length--;
        }

        while(s != f){
            s=s.next;
            f=f.next;
        }
        return s.value;

    }

    public static Integer cycleLength(LinkedListCycleStartNode142 list){
        Integer count=0;
        Node f=list.head;
        Node s=list.head;
        while (f != null && f.next != null){
            f=f.next.next;
            s=s.next;
            if(f == s){
                Node temp=s;
                do{
                    temp=temp.next;
                    count++;
                }while (temp != s);
                return count;
            }
        }
        return count;
    }

    private Node head;
    private Node tail;

    private Integer size;

    public LinkedListCycleStartNode142() {
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
        Node temp2=tail;
        while (temp !=null && (temp != temp2)){
            list.add((temp.value).toString());
            temp=temp.next;
            if(temp == temp2){
                list.add((temp.value).toString());
            }
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
