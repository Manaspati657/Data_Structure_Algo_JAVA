package src.com.mkp.theory;

import java.util.*;

public class AVL<Key extends Comparable<Key>>{
    private Node root;
    public AVL() {
    }
    public AVL(Key[] arr) {
        insertArray(arr);
    }
    private void insertArray(Key[] arr) {
        for (Key e:arr){
            insert(e);
        }
    }
    public void insert(Key key) {
        this.root=insert(root,key);
    }

    public Integer height(){
        return height(root);
    }
    private int height(Node node) {
        if(node == null) return -1;
        return node.height;
    }

    public Integer count(){
        return count(root);
    }
    private int count(Node node) {
        if(node==null) return 0;
        return node.count;
    }

    private Node rotateRight(Node node){
        Node temp=node.left;
        Node t2=temp.right;

        temp.right=node;
        node.left=t2;

        setHeightNdCount(node);
        setHeightNdCount(temp);

        return temp;
    }

    private Node rotateLeft(Node node){
        Node temp=node.right;
        Node t2=temp.left;

        temp.left=node;
        node.right=t2;

        setHeightNdCount(node);
        setHeightNdCount(temp);

        return temp;
    }

    private Node insert(Node node, Key key) {
        if(node == null) return new Node(key);
        int comp=key.compareTo(node.key);
        if(comp > 0) node.right=insert(node.right,key);
        else if(comp < 0) node.left=insert(node.left,key);
        setHeightNdCount(node);
//        this checkIsBalanced used key for child node comparison
        return checkIsBalanced(node,key);
//        this checkIsBalanced don't use anything for child node comparison
//        return checkIsBalanced(node);
    }

    private Node checkIsBalanced(Node node) {
        //        if the height difference greater than then the new node is added on the left side.
//        left case L :
        if((height(node.left) - height(node.right)) > 1){
//            check for LL case or LR case

//            if node left side weight is high then the case is LL
//            case LL :
            if(height(node.left) >= 0){
                node=rotateRight(node);
            }

//            if node left side weight is less than 0 then node.left.right weight is high in
//            that condition case is LR
//            case LR :  => L + RR of node.left => LL => right rotate current node
            else if(height(node.left) < 0){
                node.left=rotateLeft(node.left);
                node=rotateRight(node);
            }

        }

//        if the height difference less than -1 then the new node is added on the right side.
//        Right case R :
        if((height(node.left) - height(node.right)) < -1){
//            check for RR case or RL case

//            if node right side weight is less than equal 0  then the case is RR.
//            case RR :
            if(height(node.right) <= 0 ){
                node=rotateLeft(node);
            }

//            if node right side weight is greater than 0, then the node.right.left weight is
//            high so the case is RL.
//            case RL :  => R + LL of node.right => RR => Left rotate current node
            else if(height(node.right) > 0){
                node.right=rotateRight(node.right);
                node=rotateLeft(node);
            }
        }

        return node;

    }

    private Node checkIsBalanced(Node node,Key key) {
//        if the height difference greater than then the new node is added on the left side.
//        left case L :
        if((height(node.left) - height(node.right)) > 1){
//            check for LL case or LR case
            int comp=key.compareTo(node.left.key);

//            if new node is less than node.left then that node added on the left side.
//            case LL :
            if(comp < 0){
                node=rotateRight(node);
            }

//            if new node is greater than node.left then that node added on the right side.
//            case LR :  => L + RR of node.left => LL => right rotate current node
            else if(comp > 0){
                node.left=rotateLeft(node.left);
                node=rotateRight(node);
            }

        }

//        if the height difference less than -1 then the new node is added on the right side.
//        Right case R :
        if((height(node.left) - height(node.right)) < -1){
//            check for RR case or RL case
            int comp=key.compareTo(node.right.key);

//            if new node is greater than node.right then that node added on the right side.
//            case RR :
            if(comp > 0){
                node=rotateLeft(node);
            }

//            if new node is less than node.right then that node added on the left side.
//            case RL :  => R + LL of node.right => RR => Left rotate current node
            else if(comp < 0){
                node.right=rotateRight(node.right);
                node=rotateLeft(node);
            }
        }

        return node;

    }

    private void setHeightNdCount(Node node) {
        node.height=1+Math.max(height(node.left),height(node.right));
//        node.height = Math.max(height(node.left), height(node.right) + 1);
        node.count=1+count(node.left)+count(node.right);
    }

    public void display(){
        preOrder(root,"root node: ");
    }

    private void preOrder(Node node,String msg) {
        if(node == null) return;
        System.out.println(msg+node.key+" height: "+node.height+" count: "+node.count);
        preOrder(node.left,node.key+" left node is : ");
        preOrder(node.right,node.key+" right node is : ");
    }

    public Boolean isBalanced(){
        return isBalanced(root);
    }

    private Boolean isBalanced(Node node) {
        if(node == null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right) ;
    }

    public void deleteMin() {
        root=deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if(node.left == null) return node.right;
        node.left=deleteMin(node.left);
        setHeightNdCount(node);
        return node;
    }

    public void delete(Key key) {
        root=delete(root,key);
    }

    private Node delete(Node node, Key key) {
        if(node == null ) return node;
        int comp=key.compareTo(node.key);
        if(comp < 0) node.left=delete(node.left,key);
        else if(comp > 0) node.right=delete(node.right,key);
        else{
            if(node.left == null ) return node.right;
            else if(node.right == null) return node.left;

            Node temp=node;
            node=min(temp.right);
            node.right=deleteMin(temp.right);
            node.left=temp.left;
            setHeightNdCount(node);
        }
        return checkIsBalanced(node);
    }

    private Node min(Node temp){
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    public void traverseBFS() {
        traverseBFS(root);
    }

    private void traverseBFS(Node node) {
        if(node== null) return;
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
//              remove current node .
                Node tempNode=queue.poll();
                System.out.print(tempNode.key+" ");
//              add current node children to the queue if exit.
                if(tempNode.left != null) queue.add(tempNode.left);
                if(tempNode.right != null) queue.add(tempNode.right);
            }
            System.out.println();
        }
    }

    public List<List<Key>> levelOrder(){
        return levelOrder(root);
    }

//    https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    private List<List<Key>> levelOrder(Node root) {
        List<List<Key>> ans=new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Key> levelData=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node tempNode=queue.poll();
                levelData.add(tempNode.key);
                if(tempNode.left != null) queue.add(tempNode.left);
                if(tempNode.right != null) queue.add(tempNode.right);
            }
            ans.add(levelData);
        }
        return ans;
    }

    public List<List<Key>> levelOrderII(){
        return levelOrderII(root);
    }

//        https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
    private List<List<Key>> levelOrderII(Node root) {
        List<List<Key>> ans=new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Key> levelData=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node tempNode=queue.poll();
                levelData.add(tempNode.key);
                if(tempNode.left != null) queue.add(tempNode.left);
                if(tempNode.right != null) queue.add(tempNode.right);
            }
            ans.add(0,levelData);
        }
        return ans;
    }

    public List<Double> averageOfLevels(){
        return averageOfLevels(root);
    }

//    https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
    private List<Double> averageOfLevels(Node node) {
        List<Double> ans=new ArrayList<>();
        if(node == null ) return ans;
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size=queue.size();
            Double levelSum=0.0;
            for (int i = 0; i < size; i++) {
                Node tempNode=queue.poll();
                levelSum+=(Double) tempNode.key;
                if(tempNode.left != null) queue.add(tempNode.left);
                if(tempNode.right != null) queue.add(tempNode.right);
            }
            ans.add(levelSum/size);
        }

        return ans;
    }

    public List<List<Key>> zigzagLevelOrder(){
        return zigzagLevelOrder(root);
    }

//        https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    private List<List<Key>> zigzagLevelOrder(Node node) {
        List<List<Key>> ans=new ArrayList<>();
        if(node == null) return ans;
        Deque<Node> deque=new LinkedList<>();
        deque.addLast(node);
        boolean rev=false;

        while(!deque.isEmpty()){
            int size=deque.size();
            List<Key> levelAns=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if(rev){
                    Node tempNode=deque.pollLast();
                    levelAns.add(tempNode.key);
                    if(tempNode.right != null) deque.addFirst(tempNode.right);
                    if(tempNode.left != null) deque.addFirst(tempNode.left);
                }else{
                    Node tempNode=deque.pollFirst();
                    levelAns.add(tempNode.key);
                    if(tempNode.left != null) deque.addLast(tempNode.left);
                    if(tempNode.right != null) deque.addLast(tempNode.right);
                }
            }
            rev=!rev;
            ans.add(levelAns);
        }
        return ans;
    }

    public void iterateLevel(){
        iterateLevel(root);;
    }

//        https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    private void iterateLevel(Node node) {
//        if(root==null) return root;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i = 0;i < size ;i++){
                Node temp=queue.poll();
                Node next=queue.peek();
//                if(i == size-1) temp.next=null;
//                else temp.next=queue.peek();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
//        return root;
    }

    public List<Key> rightSideView() {
        return rightSideView(root);
    }

//        https://leetcode.com/problems/binary-tree-right-side-view/
    private List<Key> rightSideView(Node node) {
        List<Key> ans=new ArrayList<>();
        if(node == null) return ans;

        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int size= q.size();
            for (int i = 0; i < size; i++) {
                Node temp=q.poll();
                if(i == size-1) ans.add(temp.key);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
        return ans;
    }




    private class Node{
        Key key;
        Node left,right;
        Integer count;
        Integer height;
        public Node(Key key) {
            this.key = key;
            this.height=0;
            this.count=1;
        }
    }

}
