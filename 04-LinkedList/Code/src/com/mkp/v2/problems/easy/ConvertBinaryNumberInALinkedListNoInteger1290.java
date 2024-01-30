package src.com.mkp.v2.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinaryNumberInALinkedListNoInteger1290 {

    /*
    *
    *   just like in decimal number we multiply 10 for the place of the digit just like that we can do for binary also
    *   e.g. if we convert [5,3,2] to decimal
    *        ans =0 ;
    *        ans += 0 * 10 +5 = 5
    *        ans += 5 *10 + 3 = 53
    *        ans += 53 * 10 + 2 = 532
    *   so for binary also we can do that if we convert [1,1,1] to decimal
    *        ans= 0;
    *        ans += 0 * 2 + 1 = 1
    *        ans += 1 * 2 + 1 = 3
    *        ans += 3 * 2 + 1 = 7  == ans;
    * */
    public int getDecimalValue(ListNode head) {
        int ans=0;
        while (head != null) {
            ans = ans * 2 + head.val;
            head = head.next;
        }
        return ans;
    }



    /*
    *
    *  Brute force approach : e.g. 101 - 1*2^2+0*2^1+1*2^0=4+0+1=5
    *
    * */
    public int getDecimalValueV1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0, ans = 0;
        while (i < list.size()) {
            ans += ((int) Math.pow(2, list.size() - i - 1)) * list.get(i);
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
