package src.com.mkp.v1.problems;

import java.util.StringJoiner;

public class MergeTwoSortedList21 {
//    https://leetcode.com/problems/merge-two-sorted-lists/description/
    public static void main(String[] args) {
        MergeTwoSortedList21 list1=new MergeTwoSortedList21();
        MergeTwoSortedList21 list2=new MergeTwoSortedList21();

        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(4);

        list2.insertLast(1);
        list2.insertLast(3);
        list2.insertLast(4);

        MergeTwoSortedList21 mergedList=mergeTwoList(list1,list2);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(mergedList);
    }


    private Node head;
    private Node tail;

    private Integer size;

    public MergeTwoSortedList21() {
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

    public static MergeTwoSortedList21 mergeTwoList(MergeTwoSortedList21 list1,MergeTwoSortedList21 list2){
        MergeTwoSortedList21 mergedList=new MergeTwoSortedList21();
        Node h1=list1.head;
        Node h2=list2.head;
        while (h1 != null && h2 != null){

            if(h1.value < h2.value){
                mergedList.insertLast(h1.value);
                h1=h1.next;
            }else{
                mergedList.insertLast(h2.value);
                h2=h2.next;
            }

//            if(h1.value == h2.value){
//                mergedList.insertLast(h1.value);
//                mergedList.insertLast(h2.value);
//                h1=h1.next;
//                h2=h2.next;
//            }else if(h1.value < h2.value){
//                mergedList.insertLast(h1.value);
//                h1=h1.next;
//            }else{
//                mergedList.insertLast(h2.value);
//                h2=h2.next;
//            }
        }

        while (h1 != null) {
            mergedList.insertLast(h1.value);
            h1=h1.next;
        }

        while (h2 != null) {
            mergedList.insertLast(h2.value);
            h2=h2.next;
        }

        return mergedList;
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


    private class Node{
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
        }

    }
}























