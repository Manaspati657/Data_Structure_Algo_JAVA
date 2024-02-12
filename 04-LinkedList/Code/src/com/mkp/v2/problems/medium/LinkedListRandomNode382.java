package src.com.mkp.v2.problems.medium;

public class LinkedListRandomNode382 {

    ListNode head;
    public LinkedListRandomNode382(ListNode head) {
        this.head=head;
    }

    public int getRandom() {
        ListNode temp=head;
        int i = 1 , ans=0;
        while( temp != null){
            if(Math.random() * i < 1) ans=temp.val;
            temp=temp.next;
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
