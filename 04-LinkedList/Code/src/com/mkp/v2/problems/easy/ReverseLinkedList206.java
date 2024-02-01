package src.com.mkp.v2.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList206 {

//  recursion approach
    public ListNode reverseListV3(ListNode head) {
        if(head == null || head.next == null) return head;
//    Basically the approach is go to last and return the last node
        ListNode ans=reverseListV3(head.next);
        // while returning we just modify the node link
        // e.g. 1 -> 2 -> 3 -> 4  when we return last node the in that time we are in node 3 so
        // we just connect 4 -> 3  head.next.next = head => head.next(is 4).next = head(3) and
        // then just current node next to null
        head.next.next=head;
        head.next=null;

        return ans;
    }

//   3 pointers approach
    public ListNode reverseListV2(ListNode head) {
        if(head == null) return head;
        ListNode prev=null,current=head,next=null;
        while(current != null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }


//    without recursion simple approach : Store all numbers in a list and iterates through the list and
//    create new list
    public ListNode reverseList(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode temp=head;
        if(head == null) return head;
        while(temp != null){
            list.add(temp.val);
            temp=temp.next;
        }
        ListNode ans=new ListNode(Integer.MAX_VALUE);
        int i = 0;
        while(i < list.size()){
            if(ans.val == Integer.MAX_VALUE){
                ans = new ListNode(list.get(i));
            }else{
                ListNode temp2=new ListNode(list.get(i),ans);
                ans=temp2;
            }
            i++;
        }
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
