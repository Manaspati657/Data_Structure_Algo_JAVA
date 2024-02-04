package src.com.mkp.v2.problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumbers2 {

    /*
    *  Optimized Approach 🔥🔥🔥🔥
    * The Problem Input helps a lot while solving the problem. Input numbers are in reverse order,
    * while we sum two numbers we start from the last digit and if the sum is greater than 9 then
    * we store carry for future sum. So the same approach I used here.
    *
    *  leetcode solution :
    *  https://leetcode.com/problems/add-two-numbers/solutions/4677552/brute-force-with-queue-3ms-optimize-approach-1ms/
    * */
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        while(l1 != null || l2 != null){
            int sum=0;
            if(l1 != null){
                sum += l1.val;
                l1=l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2=l2.next;
            }
            if(sum + carry > 9 ){
                sum = (sum+carry) % 10;
                carry = 1 ;
            }else{
                sum +=carry;
                carry = 0;
            }
            temp.next=new ListNode(sum);
            temp=temp.next;
        }
        if(carry == 1) temp.next=new ListNode(1);
        return ans.next;
    }


    /*
    *  Brute force solution using Queue.
    *
    * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue1=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();
        while(l1 != null){
            queue1.add(l1.val);
            l1=l1.next;
        }
        while(l2 != null){
            queue2.add(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            int sum=0;
            if(!queue1.isEmpty()) sum += queue1.remove();
            if(!queue2.isEmpty()) sum += queue2.remove();
            if(sum + carry > 9 ){
                sum = (sum+carry) % 10;
                carry = 1 ;
            }else{
                sum +=carry;
                carry = 0;
            }
            temp.next=new ListNode(sum);
            temp=temp.next;
        }
        if(carry == 1) temp.next=new ListNode(1);
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
