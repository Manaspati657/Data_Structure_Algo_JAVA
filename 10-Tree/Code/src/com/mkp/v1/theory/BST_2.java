package src.com.mkp.v1.theory;
import java.util.*;
public class BST_2<Key extends Comparable<Key>> {

    public BST_2() {
    }

    public BST_2(Key[] keys) {
        buildTree(keys);
    }

    private void buildTree(Key[] keys) {
        for (Key key:keys){
            insert(key);
        }
    }

    private Node root;

    public Integer size(){
        return size(root);
    }

    private Integer size(Node r) {
        if( r == null) return 0;
        return (r.count == null ) ? 0 : r.count;
    }

    public Integer height(){
        return height(root);
    }
    private int height(Node node) {
        if(node == null) return -1;
        return node.height;
    }

    public void insert(Key key){
        root=insert(root,key);
    }

    private void setHeightNdCount(Node node) {
        node.height=1+Math.max(height(node.left),height(node.right));
//        node.height = Math.max(height(node.left), height(node.right) + 1);
        node.count=1+size(node.left)+size(node.right);
    }

    private Node insert(Node rootTemp, Key key) {
        if(rootTemp == null ) return new Node(key);
        int cmp = key.compareTo(rootTemp.key);
        if(cmp < 0) rootTemp.left = insert(rootTemp.left,key);
        else if(cmp > 0) rootTemp.right = insert(rootTemp.right,key);
        setHeightNdCount(rootTemp);
        return rootTemp;
    }

    private void inorder(Node root, Queue<Key> q) {
        if(root== null) return;
        inorder(root.left,q);
        q.add(root.key);
        inorder(root.right,q);
    }

    public void display(){
        preOrder(root ,"root node key: ");
    }

    private void preOrder(Node root, String msg) {
        if(root == null) return;
//        System.out.println(msg+root.key);
        System.out.print(root.key+" -> ");
        preOrder(root.left,root.key+" key left node key: ");
        preOrder(root.right,root.key+" key right node key: ");
    }

    public Boolean isBalanced() {
        return isBalanced(root);
    }

    private Boolean isBalanced(Node tempRoot) {
        if(tempRoot == null) return true;
        int sizeDiff=size(tempRoot.left)-size(tempRoot.right);
        return (sizeDiff >= -1 && sizeDiff <= 1) && isBalanced(tempRoot.left) && isBalanced(tempRoot.right);
    }

    public void displayPreOrder() {
        preOrder(root ,"root node key: ");
    }

    public void displayInOrder() {
        inOrder(root ,"root node key: ");
    }

    private void inOrder(Node root, String msg) {
        if(root == null) return;
//        System.out.println(msg+root.key);
        inOrder(root.left,root.key+" key left node key: ");
        System.out.print(root.key+" -> ");
        inOrder(root.right,root.key+" key right node key: ");
    }

    public void displayPostOrder() {
        postOrder(root ,"root node key: ");
    }

    private void postOrder(Node root, String msg) {
        if(root == null) return;
//        System.out.println(msg+root.key);
        postOrder(root.left,root.key+" key left node key: ");
        postOrder(root.right,root.key+" key right node key: ");
        System.out.print(root.key+" -> ");
    }

    public int diameterOfBinaryTree() {
        return diameterOfBinaryTree(root);
    }
    int ans=0;
//        https://leetcode.com/problems/diameter-of-binary-tree/description/
    private int diameterOfBinaryTree(Node node) {
        if(node ==null) return ans;
        height1(node);
        return ans;
    }

    private int height1(Node node) {
        if(node == null) return -1;

        int lHeight=height1(node.left);
        int rHeight=height1(node.right);

        ans=Math.max(ans,(lHeight+rHeight+2));

        return Math.max(lHeight,rHeight)+1;
    }

    public void invertTree() {
        root=swapNode(root);
    }
//        https://leetcode.com/problems/invert-binary-tree/
    private Node invertTree(Node root) {
        return swapNode(root);
    }
    private Node swapNode(Node node){
        if(node== null) return node;
        Node r=swapNode(node.right);
        Node l=swapNode(node.left);
        node.left=r;
        node.right=l;
        return node;
    }

    public int maxDepth(){
        return maxDepth(root);
    }

//    https://leetcode.com/problems/maximum-depth-of-binary-tree/
    private int maxDepth(Node root) {
        return height4(root)+1;
    }
    private int height4(Node root){
        if(root==null) return -1;
        return Math.max(height4(root.left),height4(root.right))+1;
    }

//    https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public void sortedArrayToBST(Key[] nums) {
        root= buildTree(nums,0,nums.length-1);
    }
    private Node buildTree(Key[] nums,int s,int e){
        if(s>e){
            return null;
        }
        int mid=s+(e-s)/2;
        Node node=new Node(nums[mid]);
        node.left=buildTree(nums,s,mid-1);
        node.right=buildTree(nums,mid+1,e);

        return node;
    }

    public void flatten(){
        flatten(root);
    }
//    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//    with the help of extra space ArrayList is used
    private void flatten(Node root) {
        if(root != null){
            Node temp=root;
            List<Node> sortedList=new ArrayList<>();
            helper(temp,sortedList);
            Collections.reverse(sortedList);
            root=convertList(temp,sortedList);
        }

    }

    private Node convertList(Node node, List<Node> sortedList) {
        node=sortedList.remove(sortedList.size()-1);
        node.left=null;
        if(!sortedList.isEmpty()) node.right = convertList(node.right,sortedList);
        return node;
    }
//if the binary tree is on the PreOrder
/*    private void helper(Node node,List<Node> list){
        if(node == null) return;
        list.add(node);
        helper(node.left,list);
        helper(node.right,list);
    }*/

    //if the binary tree is on the Inorder
    private void helper(Node node,List<Node> list){
        if(node == null) return;
        helper(node.left,list);
        list.add(node);
        helper(node.right,list);
    }


//    this will only work for leetcode example.
    public void flatten2(){
        flatten2(root);
    }

    private void flatten2(Node root) {
        Node current=root;
        while(current != null){
            if(current.left != null){  // if in left node not null then only in left node have some less value
                Node temp=current.left;
//                search for left highest no
                while(temp.right != null) temp=temp.right;
//                set the current right to the left highest node
                temp.right=current.right;
//                then just move the left side to the right side and left side will be null
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
    }


    public boolean isValidBST(){
        return isValidBST(root);
    }
    //    https://leetcode.com/problems/validate-binary-search-tree/description/
    private boolean isValidBST(Node root) {
        if(root == null) return true;
//        if(root.left != null && max(root.left).key >= root.key) return false;
        if(root.left != null && max(root.left).key.compareTo(root.key) >= 0 ) return false;
//        if(root.right != null && min(root.right).key <= root.key) return false;
        if(root.right != null && min(root.right).key.compareTo(root.key) <= 0) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);

    }
    private Node max(Node node){
        if(node.right == null) return node ;
        return max(node.right);
    }

    public Key kthSmallest(int k){
        return kthSmallest(root,k) != null ? kthSmallest(root,k).key : null;
    }
    private int count=0;
//    https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    private Node kthSmallest(Node node, int k) {
        if(node == null) return null;
        Node left=kthSmallest(node.left,k);

        // if k'th smallest is found in left subtree, return it
        if (left != null)
            return left;

        count++;
        if(count==k) return node;

        return kthSmallest(node.right,k);
    }

    public boolean hasPathSum(int targetSum){
        return hasPathSum(root,targetSum);
    }
//   https://leetcode.com/problems/path-sum/
    private boolean hasPathSum(Node node, int targetSum) {
        if(node == null) return false;

        if(node.left == null && node.right == null)
            if((Integer) node.key == targetSum)return true;

        return hasPathSum(node.left,targetSum-(Integer) node.key) ||
                hasPathSum(node.right,targetSum-(Integer) node.key);
    }

    public int sumAllPathNumbers() {
        return sumNumbers(root,0);
    }
//    https://leetcode.com/problems/sum-root-to-leaf-numbers/
    public int sumNumbers(Node node, int sum) {
        if(node== null) return 0;
        sum=(Integer)node.key+sum*10;
        if(node.left == null && node.right== null)
            return sum;
        return sumNumbers(node.left,sum) + sumNumbers(node.right,sum);

    }

    private int max=Integer.MIN_VALUE;
    public int maxPathSum(){
        maxPathSum(root);
        return max;
    }

//    https://leetcode.com/problems/binary-tree-maximum-path-sum/
    private int maxPathSum(Node node) {
        if(node==null) return 0;

        int left=maxPathSum(node.left);
        int right=maxPathSum(node.right);

        left=Math.max(0,left);
        right=Math.max(0,right);

        int pathsum=left+right+(Integer) node.key;

        max=Math.max(ans,pathsum);
        return Math.max(left,right)+(Integer) node.key;
    }

    public List<String> binaryTreePaths() {
        return binaryTreePaths(root);
    }

//https://leetcode.com/problems/binary-tree-paths/
    public List<String> binaryTreePaths(Node root) {
        List<String> ans=new ArrayList<>();
        if(root!=null) helper(root,ans,"");
        return ans;
    }
    private void helper(Node root,List<String> ans,String str){
        if(root.left == null && root.right == null) ans.add(str+root.key);
        if(root.left != null) helper(root.left,ans,str+root.key+"->");
        if(root.right != null) helper(root.right,ans,str+root.key+"->");
    }

    public boolean isSymmetric(){
        return isSymmetric(root);
    }

//    https://leetcode.com/problems/symmetric-tree/
    private boolean isSymmetric(Node root) {
        if(root == null) return true;

        Stack<Node> list=new Stack<>();
        list.add(root.left);
        list.add(root.right);
        while(!list.isEmpty()){
            Node node1=list.pop();
            Node node2=list.pop();

            if(node1 == null && node2 == null) continue;

            if(node1 == null || node2== null) return false;

            if(!node1.key.equals(node2.key)) return false;
            list.add(node1.left);
            list.add(node2.right);
            list.add(node1.right);
            list.add(node2.left);

        }

        return true;
    }

    public boolean isSymmetric2() {
        if(root == null) return true;
        return isSymmetric2(root.left,root.right);
    }

    private boolean isSymmetric2(Node left,Node right){
        if(left== null && right == null ) return true;
        else if(left == null || right== null ) return false;
        else if(!left.key.equals(right.key)) return false;
        return isSymmetric2(left.left,right.right) && isSymmetric2(left.right,right.left);
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
