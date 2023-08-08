package src.com.mkp.problems;
import java.util.StringJoiner;
public class LinkedListHasCycle141 {

//    https://leetcode.com/problems/linked-list-cycle/
    public static void main(String[] args) {
        LinkedListHasCycle141 list1=new LinkedListHasCycle141();
        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(3);
        list1.insertLast(4);
        list1.connectNodeTo3rdNode(6);
        System.out.println(list1);
        System.out.println(hasCycle(list1));

        System.out.println("cycle length:: "+cycleLength(list1));
    }

    public  static boolean hasCycle(LinkedListHasCycle141 list){
        Node f=list.head;
        Node s=list.head;
        while (f != null && f.next != null){
            f=f.next.next;
            s=s.next;
            if(f == s){
                return true;
            }
        }
        return false;
    }

    public static Integer cycleLength(LinkedListHasCycle141 list){
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

    public LinkedListHasCycle141() {
        this.size = 0;
    }

    public boolean isEmpty(){return size == 0;}

    public void connectNodeTo3rdNode(Integer item){
        if(isEmpty()) {
            insertFirst(item);
            return;
        }
        Node node =new Node(item);
        tail.next=node;
        if(head.next != null) node.next=head.next.next;
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
