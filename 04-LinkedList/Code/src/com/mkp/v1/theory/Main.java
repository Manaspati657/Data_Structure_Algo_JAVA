package src.com.mkp.v1.theory;

public class Main {
    public static void main(String[] args) {

//        Singly_Linked_list type is String ,
/*        SinglyLinkedList<String> list=new SinglyLinkedList<>();
        list.insertFirst("mk");
        list.insertFirst("pati");
        list.insertLast("manas");
        list.insert("mkp");
        System.out.println(list);
        System.out.println("size :: "+list.size());*/
//      singly linked list test
/*
        SinglyLinkedList<Integer> list=new SinglyLinkedList<>();
        list.insertFirst(7);
        list.insertFirst(9);
        list.insertFirst(3);
        list.insertFirst(6);
        list.insertLast(5);
        list.insert(10,6);
        System.out.println(list);
        System.out.println(list.deleteFirst());
        System.out.println(list);
        System.out.println(list.deleteLast());
        System.out.println(list);
        System.out.println(list.delete(2));
        System.out.println(list);
        System.out.println("size :: "+list.size());*/

//       Doubly linked list test
/*        DoublyLinkedList<Integer> list=new DoublyLinkedList<>();
        list.insertFirst(7);
        list.insertFirst(9);
        list.insertFirst(3);
        list.insertFirst(6);
        list.insertLast(5);
        list.insertAtIndex(10,3);
        list.insertAfterItem(8,7);
        System.out.println(list);
        System.out.println(list.deleteFirst());
        System.out.println(list);
        System.out.println(list.deleteLast());
        System.out.println(list);
        System.out.println(list.delete(2));
        System.out.println(list);
        System.out.println("size :: "+list.size());
        System.out.println("In Reverse order :: \n"+list.displayReverse());*/

        CircularLinkedList<Integer> list=new CircularLinkedList<>();
        list.insert(7);
        list.insert(9);
//        list.insert(3);
//        list.insert(6);
        System.out.println(list);
        System.out.println("delete :: "+ list.delete(9));
        System.out.println(list);
        System.out.println("size :: "+list.size());
    }
}
