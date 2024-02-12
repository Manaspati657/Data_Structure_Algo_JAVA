package src.com.mkp.v2.problems.medium;

public class MergeKSortedLists23 {


    /*
    *   Input: lists = [[1,4,5],[1,3,4],[2,6]]
    *   Output: [1,1,2,3,4,4,5,6]
    *
    *   Approach is to merge two list node at one time,so we can use the divide and conquer approach
    *   Or we can say merge sort approach.
    *
    * */

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists== null || lists.length == 0) return null;

        return mergeKLists(lists,0,lists.length-1);
    }
    private ListNode mergeKLists(ListNode[] lists,int start , int end) {
        if(start == end ) return lists[0];

        int mid=start + ((end-start)/2);

        ListNode left = mergeKLists(lists,start,mid);
        ListNode right = mergeKLists(lists,mid+1,end);

        return merge(left,right);
    }

    private ListNode merge(ListNode left,ListNode right){
        ListNode mergeList=new ListNode(0);
        ListNode temp=mergeList;
        while(left != null && right != null){
            if(left.val < right.val){
                temp.next=left;
                left=left.next;
            }else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        temp.next= (left != null) ? left : right;
        return mergeList.next;
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
