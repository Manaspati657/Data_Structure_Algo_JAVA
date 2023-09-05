package src.com.mkp.theory;

import java.util.PriorityQueue;
import java.util.Queue;

public class Red_Black_BST<Key extends Comparable<Key>, Value> {

    private static final boolean RED=true;
    private static final boolean BLACK=false;

    Node root;

    public Integer height(){
        return height(root);
    }

    private Integer height(Node root) {
        return root != null ? root.hight : 0 ;
    }

    public boolean isRed(Node temp){
        return  temp != null && temp.color == RED ? RED : BLACK;
    }

    private Node rotateLeft(Node h){
        if(!isRed(h.right)) return h;
        Node temp=h.right;
        h.right=temp.left;
        temp.left=h;
        temp.color=h.color;
        h.color=RED;
        return temp;
    }

    private Node rotateRight(Node h){
        if(!isRed(h.left) || !isRed(h.left.left)) return h;
        Node temp=h.left;
        h.left=temp.right;
        temp.right=h;
        temp.color=h.color;
        h.color=RED;
        return temp;
    }

    private void flipColor(Node h){
        if(!isRed(h.left) || !isRed(h.right)) return ;
        h.left.color=BLACK;
        h.right.color=BLACK;
        h.color=RED;
    }

    public void insert(Key key,Value value){
        root=insert(root,key,value);
    }

    private Node insert(Node tempRoot, Key key, Value value) {
        if(tempRoot==null) return new Node(key,value,RED);
        int comp=key.compareTo(tempRoot.key);
        if(comp > 0 ) tempRoot.right=insert(tempRoot.right,key,value);
        else if(comp < 0 ) tempRoot.left=insert(tempRoot.left,key,value);
        else tempRoot.value=value;

        if(!isRed(tempRoot.left) && isRed(tempRoot.right)) tempRoot=rotateLeft(tempRoot);
        if(isRed(tempRoot.left) && isRed(tempRoot.left.left)) tempRoot=rotateRight(tempRoot);
        if(isRed(tempRoot.left) && isRed(tempRoot.right)) flipColor(tempRoot);

        tempRoot.hight=1+height(tempRoot.left)+height(tempRoot.right);

        return tempRoot;
    }

    public void display(){
        display(root ,"root node key: ");
    }

    private void display(Node root,String msg) {
        if(root == null) return;
        System.out.println(msg+root.key);
        display(root.left,root.key+" key left node key: ");
        display(root.right,root.key+" key right node key: ");
    }

    public Boolean isBalanced() {
        return isBalanced(root);
    }

    private Boolean isBalanced(Node tempRoot) {
        if(tempRoot == null) return true;
        int heightDiff=height(tempRoot.left)-height(tempRoot.right);
        return (heightDiff >= -1 && heightDiff <= 1) && isBalanced(tempRoot.left) && isBalanced(tempRoot.right);
    }

    public Value getValue(Key key) {
        return getValue(root,key);
    }

    private Value getValue(Node tempRoot, Key key) {
        if(tempRoot == null) return null;
        int comp=key.compareTo(tempRoot.key);
        if(comp > 0 ) return getValue(tempRoot.right,key);
        else if(comp < 0 ) return getValue(tempRoot.left,key);
        else return tempRoot.value;
    }

    public Key getFloor(Key key) {
        Node temp=floor(root,key);
        return temp != null ? temp.key : null;
    }

    private Node floor(Node tempRoot, Key key) {
        if(tempRoot == null) return null;
        int cmp=key.compareTo(tempRoot.key);
        if(cmp == 0) return tempRoot;
        else if(cmp < 0) return floor(tempRoot.left,key);

        Node rightTemp= floor(tempRoot.right,key);
        if(rightTemp != null) return rightTemp;
        return tempRoot;
    }

    public Key getCeil(Key key) {
        Node temp=ceil(root,key);
        return temp != null ? temp.key : null;
    }

    private Node ceil(Node tempRoot, Key key) {
        if(tempRoot == null) return null;
        int cmp=key.compareTo(tempRoot.key);
        if(cmp == 0) return tempRoot;
        else if(cmp > 0) return ceil(tempRoot.right,key);

        Node leftTemp= ceil(tempRoot.left,key);
        if(leftTemp != null) return leftTemp;
        return tempRoot;
    }

    public Key min() {
        return min(root) != null ? min(root).key : null;
    }

    private Node min(Node tempRoot) {
        if(tempRoot.left == null) return tempRoot;
        return min(tempRoot.left);
    }

    public Key max() {
        return max(root) != null ? max(root).key : null;
    }

    private Node max(Node tempRoot) {
        if(tempRoot.right == null) return tempRoot;
        return max(tempRoot.right);
    }

    public Iterable<Key> getAllKeys() {
        Queue<Key> q=new PriorityQueue<>();
        inorder(root,q);
        return q;
    }

    private void inorder(Node root, Queue<Key> q) {
        if(root== null) return;
        inorder(root.left,q);
        q.add(root.key);
        inorder(root.right,q);
    }

    public void deleteMin() {
        deleteMin(root);
    }

    private void deleteMin(Node tempRoot) {
    }


    private class Node{
        Key key;
        Value value;
        Node left,right;
        Boolean color;
        Integer hight;
        public Node(Key key,Value value,Boolean color) {
            this.key = key;
            this.value=value;
            this.color=color;
            this.hight=0;
        }
    }
}
