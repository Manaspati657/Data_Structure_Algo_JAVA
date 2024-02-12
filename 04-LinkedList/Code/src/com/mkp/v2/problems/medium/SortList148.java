package src.com.mkp.v2.problems.medium;

public class SortList148 {

//    merge sort technique.
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid=getMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);

        return merge(left,right);
    }

    private ListNode merge(ListNode list1,ListNode list2){
        ListNode mergeNode=new ListNode(0);
        ListNode temp=mergeNode;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next=new ListNode(list1.val);
                list1=list1.next;
            }else{
                temp.next=new ListNode(list2.val);
                list2=list2.next;
            }
            temp=temp.next;
        }
        temp.next = (list1 != null) ? list1 : list2;
        return mergeNode.next;
    }

    private ListNode getMid(ListNode node){
        ListNode slow=node,fast=node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        return mid;
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
