package src.com.mkp.v2.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList1171 {



    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        Map<Integer,ListNode> map=new HashMap<>();
        int prefixSum=0;
        map.put(0,dummy);
        while(head != null){
            prefixSum+=head.val;
            map.put(prefixSum,head);
            head=head.next;
        }
        prefixSum=0;
        ListNode curr=dummy;
        while(curr != null){
            prefixSum+=curr.val;
            curr.next=map.get(prefixSum).next;
            curr=curr.next;
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
