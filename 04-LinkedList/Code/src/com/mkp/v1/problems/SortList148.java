package src.com.mkp.v1.problems;
import java.util.StringJoiner;

public class SortList148 {

    public static void main(String[] args) {
        SortList148 list=new SortList148();
        list.insertLast(9);
        list.insertLast(2);
        list.insertLast(6);
        list.insertLast(4);
        list.insertLast(1);
        System.out.println(list);
        list.sort();
        System.out.println(list);

    }

    private void sort() {
        head=sortList(head);
    }

    private Node sortList(Node head) {
        if(head == null || head.next ==null) return head;

        Node mid=getMid(head);
        Node left=sortList(mid);
        Node right=sortList(head);

        return merge(left,right);
    }

    Node merge(Node list1, Node list2) {
       Node mergeList=new Node();
       Node tail=mergeList;
       while(list1 != null && list2 != null){
           if(list1.value < list2.value){
               tail.next=list1;
               list1=list1.next;
           }else{
               tail.next=list2;
               list2=list2.next;
           }
           tail=tail.next;
       }

        tail.next= (list1 != null) ? list1 : list2;
       return mergeList.next;
    }

    Node getMid(Node head) {
       Node midPrev=null;
       while(head != null && head.next != null){
           midPrev= (midPrev== null) ? head :midPrev.next;
           head=head.next.next;
       }
       Node mid=midPrev.next;
       midPrev.next=null;
       return mid;
    }

    private Node head;
    private Node tail;

    private Integer size;

    public SortList148() {
        this.size = 0;
    }

    public boolean isEmpty(){return size == 0;}


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
        while (temp !=null){
            list.add((temp.value).toString());
            temp=temp.next;
        }

        return list.toString();
    }


    private static class Node{
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
        }
        public Node() {
        }

    }
}
