package src.com.mkp.v2.problems.medium;

public class LinkedListCycleII142 {

    public ListNode detectCycle(ListNode head) {
        // find the circle exist or not
        ListNode slow=head,fast=head;
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast=fast.next.next;
            if(slow == fast) break;
        }

        // if fast.next != null means we find the circle at fast/slow(both pointer meet at one place) other wise return null
        if(fast != null && fast.next != null){
            ListNode tempH=head;
            while(tempH != slow){
                tempH=tempH.next;
                slow=slow.next;
            }
            // after this loop slow and tempH will be in circle starting node.
            return tempH;
        }
        return null;
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
