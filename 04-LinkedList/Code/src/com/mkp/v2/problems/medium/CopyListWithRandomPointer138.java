package src.com.mkp.v2.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer138 {

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node ans=head;
        Map<Node,Node> map=new HashMap<>();
        while(ans != null){
//           while we putting it in map key value, we create new node so while we set next and random
//            new node connect with new node at last return new head.
            map.put(ans,new Node(ans.val));
            ans=ans.next;
        }

        ans=head;
        while(ans != null){
            map.get(ans).next=map.get(ans.next);
            map.get(ans).random=map.get(ans.random);
            ans=ans.next;
        }
        return map.get(head);
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
