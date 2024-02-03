package src.com.mkp.v2.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle141 {


    /*
    *  Optimized approach with slow and fast pointer. if there is a circle then fast and slow pointer will meet.
    * */
    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    /*
    *
    * Brute force approach : while iterating the linked list if we find that node already in map then linked list
    *  has a circle.
    *
    * */

    public boolean hasCycleV1(ListNode head) {
        Map<ListNode,Integer> map=new HashMap<>();
        while(head != null){
            if(map.containsKey(head)) return true;
            map.put(head,head.val);
            head = head.next;
        }
        return false;
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
