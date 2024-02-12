package src.com.mkp.v2.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SwapNodesInPairs24 {

    /*
    *   Optimized approach : with 3 pointer prev -> curr -> next
    *
    * */
    public ListNode swapPairsV2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode ans=new ListNode(0);
        ans.next=head;
        ListNode prev = ans,curr=head,next=null;
        while(curr != null && curr.next != null ){
            /*
            *   e.g. 4 -> 2 -> 3 -> 5 -> 7 -> 8
            *   we have to swap 2 and 3
            *   prev = 4 , curr= 2 and next = 3
            *
            * */
            next=curr.next;
            // swap
            prev.next=curr.next;  // 4 -> 3
            curr.next=next.next;  // 2 -> 5
            next.next= curr;      // 3 -> 2
//            4 -> 3 -> 2 -> 5 ==> swapped.
            // change the 3 pointer values
            prev=curr; // prev = 2
            curr=prev.next; // curr = 5
        }

        return ans.next;
    }


    /*
    *
    *  Brute force approach store it in an array swap 2 every adjacent element create a new linked list
    *  and return it.
    *
    * */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ArrayList<Integer> list=new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head=head.next;
        }
        int[] listArray=new int[list.size()];
        for(int i = 0 ;i < list.size() ;i++)
            listArray[i]=list.get(i);
        for(int i = 0 ; i+1 < listArray.length ;i+=2){
            System.out.println(Arrays.toString(listArray));
            int temp= listArray[i];
            listArray[i]= listArray[i+1];
            listArray[i+1]= temp;
        }
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        for(int e:listArray){
            temp.next=new ListNode(e);
            temp=temp.next;
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
