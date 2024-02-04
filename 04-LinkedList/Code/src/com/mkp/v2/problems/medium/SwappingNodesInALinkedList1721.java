package src.com.mkp.v2.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodesInALinkedList1721 {

//    optimize approach just use slow and fast pointer.
    public ListNode swapNodesV2(ListNode head, int k) {
        // Approach is first take the fast pointer to the kth node then store fast pointer as first swap1 node
        // and then start slow pointer from head and fast pointer where it before the kth position until
        // fast pointer not to be null when fast pointer is null slow pointer automatically in kth position from end side.
        ListNode slow=head,fast=head,swap1=null,swap2=null;
        for(int i = 0 ;i < k-1;i++)
            fast=fast.next;
        swap1=fast;

        while(fast.next != null){
            slow=slow.next;
            fast=fast.next;
        }
        swap2=slow;
        int temp=swap1.val;
        swap1.val=swap2.val;
        swap2.val=temp;

        return head;
    }


//    Brute force approach : store all nodes value in array then swap kth val from beginning with end side kth val
//    then just create a new node and return it.
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> list=new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head=head.next;
        }
        int length=list.size(),m=k-1,n=length -k;
        Integer[] numbers=new Integer[length];
        numbers=list.toArray(numbers);
        // swap the kth number from both side. index of kth number from beginning is m = k -1 and from end n = length -k.
        int tempVal=numbers[m];
        numbers[m]=numbers[n];
        numbers[n]=tempVal;
        // now create a new linked list with swap number array return it.
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        for(Integer e:numbers){
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
