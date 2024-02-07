package src.com.mkp.v2.problems.medium;

public class RotateList61 {

    public ListNode rotateRight(ListNode head, int k) {
        int l=0;
        if(head == null) return head;
        ListNode temp=head,tail=null;
        while(temp != null){
            l++;
            if(temp.next == null) tail = temp;
            temp=temp.next;
        }
        k=k%l;
        if(k == l || k == 0 ) return head;
        // approach is separate length-k from full list, kth item is new head and connect tail with head.
        ListNode temp2=head;
        // iterate to the newHead prev because we want new head and also we have to disconnect newHead before node .
        for(int i = 1 ; i < l-k ; i++){
            temp2=temp2.next;
        }
        ListNode newHead=temp2.next;
        // disconnect
        temp2.next=null;
        // connect tail with head;
        tail.next=head;
        return newHead;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
