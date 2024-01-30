package src.com.mkp.v2.problems.easy;

public class MiddleOfTheLinkedList876 {

//   approach slow pointer and fast pointer.
    public ListNode middleNodeV2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode smallStep=head,bigStep=head;
        while(bigStep != null && bigStep.next != null){
            smallStep=smallStep.next;
            bigStep=bigStep.next.next;
        }
        return smallStep;
    }


//    Brute force
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp=head;
        int length=0;
        // get the total number of node length
        while(temp != null){
            length++;
            temp=temp.next;
        }
        // find the middle and iterate to the middle and return it.
        int mid=(length/2)+1;
        ListNode ans=head;
        while(mid != 1){
            ans=ans.next;
            mid--;
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
