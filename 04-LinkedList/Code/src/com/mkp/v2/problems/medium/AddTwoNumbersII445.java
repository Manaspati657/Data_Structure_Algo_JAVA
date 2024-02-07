package src.com.mkp.v2.problems.medium;

import java.util.Stack;

public class AddTwoNumbersII445 {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int carry = 0;
        ListNode ans=new ListNode(-1);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int sum=0;
            if(!stack1.isEmpty()) sum += stack1.pop();
            if(!stack2.isEmpty()) sum += stack2.pop();
            if(sum+carry > 9){
                sum = (sum+carry) %10;
                carry=1;
            }else{
                sum=sum+carry;
                carry=0;
            }
            if(ans.val == -1){
                ans=new ListNode(sum);
            }else{
                ans=new ListNode(sum,ans);
            }
        }

        if(carry != 0) ans=new ListNode(carry,ans);

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
