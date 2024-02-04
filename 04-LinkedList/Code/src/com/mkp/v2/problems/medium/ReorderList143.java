package src.com.mkp.v2.problems.medium;

public class ReorderList143 {


    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        // we find the middle now in slow now we divide the list in two half
        ListNode current=slow.next;
        slow.next=null;

        // now reverse the 2nd list
        ListNode prev=null,curr=current;
        while(curr != null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        current=head;
        // we have two end head and prev now merge the two ends;
        while(prev != null){
            ListNode nextPrev=prev.next;
            prev.next=current.next;
            current.next=prev;
            current=prev.next;
            prev=nextPrev;
        }
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
