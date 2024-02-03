package src.com.mkp.v2.problems.easy;

public class RemoveLinkedListElements203 {


    /*
    *
    *  recursive approach: go to the last until it null and while return check the curr val with given val
    *
    * */
    public ListNode removeElementsV1(ListNode head, int val) {
        if(head == null) return null;

        head.next=removeElementsV1(head.next,val);
        return (head.val == val) ? head.next : head;
    }

    /*
    *
    *  Iterative approach first search for current node is val or if yes then increase the head to next until we
    *  find a node with different val.
    *  Then check the current next with the given val if match just remove the next node . otherwise increase our
    *  current node.
    *
    * */

    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) head=head.next;
        ListNode curr=head;
        while(curr != null && curr.next != null){
            if(curr.next.val == val) curr.next=curr.next.next;
            else curr=curr.next;
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
