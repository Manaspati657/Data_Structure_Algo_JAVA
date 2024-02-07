package src.com.mkp.v2.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class FlattenAMultilevelDoublyLinkedList430 {

//    Brute force:
    public Node flattenV1(Node head) {
        List<Integer> list=new ArrayList<>();
        getAllNodesValues(head,list);
        Node ans=new Node(0);
        Node temp=ans;
        for(Integer el:list){
            Node newNode=new Node(el);
            temp.next=newNode;
            newNode.prev=temp;
            temp=newNode;
        }
        if(ans != null && ans.next != null) ans.next.prev=null;
        return ans.next;
    }

    public void getAllNodesValues(Node head,List<Integer> list){
        while(head != null){
            list.add(head.val);
            if(head.child != null) getAllNodesValues(head.child,list);
            head=head.next;
        }
    }

//    optimized :
    public Node flatten(Node head) {
        Node temp=head;
        while(temp != null){
            if(temp.child != null){
                // find the child node tail means last node
                Node tail=findChildTail(temp.child);
                // if current node next is not null then connect current node with the child last node i.e. tail
                if(temp.next != null) temp.next.prev=tail;
                // connect child last with current next;
                tail.next=temp.next;
                // Now just connect current node with its child and remove the child connection
                temp.next=temp.child;
                temp.child.prev=temp;
                temp.child = null;
            }
            //    Now you think about inner child node but when we connect it child to current next then inner child will comes
            //    automatically if exist.
            temp = temp.next;
        }

        return head;
    }

    public Node findChildTail(Node node){
        while(node != null && node.next != null){
            node =node.next;
        }
        return node;
    }

    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    };
}
