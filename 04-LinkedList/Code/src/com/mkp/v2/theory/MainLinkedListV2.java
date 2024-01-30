package src.com.mkp.v2.theory;

public class MainLinkedListV2 {
    public static void main(String[] args) {
        //        Singly_Linked_list type is String ,
        SinglyLinkedList<String> list=new SinglyLinkedList<>();
//        list.insertFirst("mk");
//        list.insertFirst("pati");
//        list.insertLast("manas");
        list.insert("mkp");
        list.insert("d");
        list.insert("dge");
        System.out.println(list);
//        System.out.println("size :: "+list.size());
    }
}
