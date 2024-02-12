package src.com.mkp.v2.problems.medium;

public class InsertionSortList147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev=dummy;
        while(head != null){
            //store the next node for sorting
            ListNode next=head.next;
            // this is checking if prev is in the middle of the sorted list but prev val is greater
            // than current node val, so we have to go to the first node check the correct place for it
            if(prev.val >= head.val)
                prev=dummy;
            // search for a correct place to put the head if prev next value is less than current node val
            // then we go another step until it next is null then, if we find prev next is greater than
            // head value we put there our current node.
            while(prev.next != null && prev.next.val < head.val)
                prev=prev.next;
            // add the current node after prev.
            head.next=prev.next;
            prev.next=head;

            // set the new head with next;
            head=next;
        }
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
