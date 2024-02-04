package src.com.mkp.v2.problems.medium;

public class RemoveNthNodeFromEndOfList19 {

    /*
    *
    * First find out the length of the linked List. As per the problem we have to delete nth
    * node from end of list so for find out the delete node the formula will be totalLength-n+1 node .
    * But only we have to go before the deleted node and change the next node to the next.next node.
    *
    * Note: only we have to add two base condition
    * i) If the length is 1, and we have to delete n =1 then linked list will be empty so in that case
    *  we return null.
    * ii) If the n is same as length then we only delete the first node so return the next node.
    *
    *  leetcode solution:
    * https://leetcode.com/problems/remove-nth-node-from-end-of-list/solutions/4677214/super-easy-approach-0-ms-running-time/
    *
    * */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // first find the full length of the linked list
        int length=0;
        ListNode temp=head;
        while(temp != null){
            temp =temp.next;
            length++;
        }
        if(length == 1 && n == 1 ) return null;
        if(length == n) return head.next;
        ListNode ans=head;
        for(int i = 1 ; i < length-n ;i++){
            head = head.next;
        }
        head.next = head.next.next;
        return ans;
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
