package src.com.mkp.v2.problems.easy;

import java.util.HashMap;

public class IntersectionOfTwoLinkedLists160 {

    /*
    *  Optimized approach : Time complexity O(m+n).
    * */
    public ListNode getIntersectionNodeV1(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map=new HashMap<>();
        while(headA != null){
            map.put(headA,headA.val);
            headA=headA.next;
        }
        while(headB != null){
            if(map.containsKey(headB)) return headB;
            headB=headB.next;
        }
        return null;
    }
    /*
    *   Basic approach take one by one node from headA and search it in headB
    *   Time complexity : O(M*N)
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        for(ListNode temp=headA; temp != null ; temp =temp.next){
            ListNode temp2=headB;
            while(temp2 != null){
                if(temp == temp2) return temp;
                temp2=temp2.next;
            }
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
