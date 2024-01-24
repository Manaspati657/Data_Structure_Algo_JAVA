package src.com.mkp.v1.problems;

import src.com.mkp.v1.theory.SinglyLinkedList;

public class RemoveDuplicatesFromSortedList83  {

//    https://leetcode.com/problems/remove-duplicates-from-sorted-list/

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list=new SinglyLinkedList<>();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        System.out.println(list);
        list.removeDuplicates(); // see implementation in SinglyLinkedList class
        System.out.println(list);
    }
}
