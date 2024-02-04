package src.com.mkp.v2.problems.medium;

public class ReverseLinkedListII92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n ) return head;
        // before we're doing any operation we store head reference so that in the last we will return it.
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode beforeRev=dummy;
        ListNode curr=head;
        // we only have to reverse from m to n, so we store the before m node so that we use it after reverse.
        for(int i = 0; i < m-1;i++){
            beforeRev=beforeRev.next;
            curr=curr.next;
        }
        // now we need to reverse after beforeRev node for n-m+1 nodes.
        ListNode prev=null,tail=curr;
        // here prev and curr used for reverse the n-m+1 nodes.
        for(int i = 0;i< n-m+1;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // after reverse we have to joints 2 nodes beforeRev node with reverse head i.e. here prev node
        beforeRev.next=prev;
        // and another joints is between tail and curr tail is reverse tail curr is rev window next node i.e.
        // after n nodes
        tail.next=curr;


        return dummy.next;
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
