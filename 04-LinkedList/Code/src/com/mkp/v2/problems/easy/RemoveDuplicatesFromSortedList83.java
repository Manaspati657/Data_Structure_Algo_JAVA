package src.com.mkp.v2.problems.easy;

public class RemoveDuplicatesFromSortedList83 {

    /*
    *
    *   Recursive approach go to the last node while back check the current with next node .
    *
    * */

    public ListNode deleteDuplicatesV1(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next=deleteDuplicatesV1(head.next);
        return (head.val == head.next.val) ? head.next : head;
    }


    /*
    *   Brute force approach: compare current with next value  if same then current will not change just current next
    *   change to next.next .if not same then only curr change to next.
    * */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val)
                temp.next=temp.next.next;
            else
                temp=temp.next;
        }

        return head;
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
