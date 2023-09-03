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
        return (r.count == null )? 1 : r.count;
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

    private class Node{
        Key key;
        Value value;
        Node left,right;

        Integer count;

        public Node(Key key,Value value) {
            this.key = key;
            this.value=value;
        }
    }

}
