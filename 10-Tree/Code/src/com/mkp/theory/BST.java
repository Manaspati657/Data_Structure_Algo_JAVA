package src.com.mkp.theory;

import java.util.PriorityQueue;
import java.util.Queue;

public class BST <Key extends Comparable<Key>, Value>{

    private Node root;

    public Integer size(){
        return size(root);
    }

    private Integer size(Node r) {
        if( r == null) return 0;
        return (r.count == null ) ? 0 : r.count;
    }
    public Key min(){
//        Node t=min(root);
////        return t ==null? null:t.key;
        return getMin(root);
    }

    private Key getMin(Node node) {
        if(node == null) return null;
        if(node.left != null) return getMin(node.left);
        return node.key;
    }

    public Node min(Node temp){
        while(temp != null){
            temp = temp.left;
            if(temp.left == null) break;
        }
        return temp;
    }
    public Key max(){
        Node t = max(root);
        return t==null ? null : t.key;
    }
    public Node max(Node temp){
            while(temp != null){
                temp = temp.right;
                if(temp.right == null) break;
            }
            return temp;
    }

    public void insert(Key key,Value value){
        root=insert(root,key,value);
    }

    private Node insert(Node rootTemp, Key key, Value value) {
        if(rootTemp == null ) return new Node(key,value);
        int cmp = key.compareTo(rootTemp.key);
        if(cmp < 0) rootTemp.left = insert(rootTemp.left,key,value);
        else if(cmp > 0) rootTemp.right = insert(rootTemp.right,key,value);
        else if(cmp == 0) rootTemp.value=value;
        rootTemp.count= 1 + size(rootTemp.left)+ size(rootTemp.right);
        return rootTemp;
    }

    public Value getValue(Key key){
        Node tempRoot=root;
        while(tempRoot != null){
            int cmp=key.compareTo(tempRoot.key);
            if(cmp < 0 ) tempRoot=tempRoot.left;
            else if(cmp > 0 ) tempRoot=tempRoot.right;
            else if(cmp == 0) return tempRoot.value;
        }
        return null;
    }

    public Iterable<Key> getAllKeys(){
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

    public Key getFloor(Key key){
        Node temp=floor(root,key);
        return temp==null? null:temp.key;
    }
    private Node floor(Node tempRoot, Key key) {
        if(tempRoot == null) return null;
        int comp=key.compareTo(tempRoot.key);
        if(comp == 0) return tempRoot;
        else if(comp < 0) return floor(tempRoot.left,key);

        Node rightTemp=floor(tempRoot.right,key);
        if(rightTemp != null) return rightTemp;

        return tempRoot;

    }

    public Key getCeil(Key key){
        Node temp=ceil(root,key);
        return temp==null ? null:temp.key;
    }

    private Node ceil(Node tempRoot, Key key) {
        if(tempRoot == null) return null;
        int comp=key.compareTo(tempRoot.key);
        if(comp == 0) return tempRoot;
        else if(comp > 0) return ceil(tempRoot.right,key);

        Node leftTemp = ceil(tempRoot.left,key);
        if(leftTemp != null) return leftTemp;
        return tempRoot;
    }

    public void deleteMin()
    { root = deleteMin(root); }
    private Node deleteMin(Node x)
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(Key key) {
        root=deleteKey(root,key);
    }

    private Node deleteKey(Node tempRoot, Key key) {
        if(tempRoot==null) return null;
        int comp=key.compareTo(tempRoot.key);
        if(comp < 0 ) tempRoot.left=deleteKey(tempRoot.left,key);
        else if(comp > 0 ) tempRoot.right=deleteKey(tempRoot.right,key);
        else{
            if(tempRoot.right == null) return tempRoot.left;
            else if(tempRoot.left == null) return tempRoot.right;

            Node temp=tempRoot;
            tempRoot=min(temp.right);
            tempRoot.right=deleteMin(temp.right);
            tempRoot.left=temp.left;
        }
        tempRoot.count=1+size(tempRoot.left)+size(tempRoot.right);
        return tempRoot;
    }

    public void display(){
        preOrder(root ,"root node key: ");
    }

    private void preOrder(Node root, String msg) {
        if(root == null) return;
        System.out.println(msg+root.key);
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

    private class Node{
        Key key;
        Value value;
        Node left,right;

        Integer count;

        public Node(Key key,Value value) {
            this.key = key;
            this.value=value;
            this.count=1;
        }
    }

}
