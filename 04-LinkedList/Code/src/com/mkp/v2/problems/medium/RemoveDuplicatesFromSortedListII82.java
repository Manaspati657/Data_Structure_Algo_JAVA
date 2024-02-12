package src.com.mkp.v2.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedListII82 {

    /*
    *  Optimized approach: Iterate over the Linked list and if we find the current node val is same as next
    * node val then we delete nodes until the next node val is unique.
    * */

    public ListNode deleteDuplicatesV2(ListNode head) {
        if(head == null) return head;
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                int duplicateVal=head.val;
                // Delete all current duplicate values from the list.
                while(head.next != null && head.next.val == duplicateVal){
                    head = head.next;
                }
            }
            else{
                // store the unique value.
                temp.next=new ListNode(head.val);
                temp=temp.next;
            }
            head=head.next;
        }
        return ans.next;
    }


    /*
    *  Brute force approach : Time Complexity O(N)
    *                         Space Complexity O(N)
    *  Approach is use map for store number count and use arraylist for input position track.
    * */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        Map<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        while(head != null){
            if(map.containsKey(head.val)){
                map.put(head.val,map.get(head.val)+1);
            }else{
                map.put(head.val,1);
                list.add(head.val);
            }
            head=head.next;
        }
        ListNode temp=new ListNode(0);
        ListNode ans=temp;
        for(Integer e : list){
            if(map.get(e) == 1){
                temp.next=new ListNode(e);
                temp=temp.next;
            }
        }
        return ans.next;
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
