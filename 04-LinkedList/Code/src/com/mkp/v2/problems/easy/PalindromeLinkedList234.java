package src.com.mkp.v2.problems.easy;

public class PalindromeLinkedList234 {


    public boolean isPalindrome(ListNode head) {
        // approach is search the middle node of linked list and reverse from middle to end and start compare head with
        // tail .
        ListNode slow=head,fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // slow is middle
        ListNode prev=null ,curr=slow,next=null;
        while(curr != null){
            next=curr.next;
            curr.next= prev;
            prev = curr;
            curr=next;
        }
        // prev is reverse head i.e. tail of the linked list
        while(head != null && prev != null){
            if(head.val != prev.val){
                return false;
            }
            head=head.next;
            prev=prev.next;
        }
        return true;
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
