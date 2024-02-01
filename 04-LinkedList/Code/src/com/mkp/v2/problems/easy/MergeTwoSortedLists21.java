package src.com.mkp.v2.problems.easy;

public class MergeTwoSortedLists21 {

    //    recursion approach basically we just change the node connection
    public ListNode mergeTwoListsV2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoListsV2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsV2(list1, list2.next);
            return list2;
        }
    }


    //    iterative approach.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        if (list1 == null || list2 == null) return (list1 == null) ? list2 : list1;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ans.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                ans.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            ans = ans.next;
        }

        if (list1 != null) ans.next = list1;
        else ans.next = list2;

        return temp.next;
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
