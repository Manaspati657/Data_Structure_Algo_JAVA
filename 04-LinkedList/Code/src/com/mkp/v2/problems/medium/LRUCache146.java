package src.com.mkp.v2.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {


    Map<Integer,Node> map=new HashMap<>();
    Node head,tail;
    int size;

    public LRUCache146(int capacity) {
        // create a head and tail connect them.
        // new add add in tail and remove from head side.
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        size=capacity;
    }

    public int get(int key) {
        if(map.isEmpty() || !map.containsKey(key)) return -1;
        Node node=map.get(key);
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            update(node);
        }else{
            Node newNode=new Node(key,value);
            add(newNode);
            map.put(key,newNode);
        }
        if(map.size() > size){
            Node removeNode=head.next;
            remove(removeNode);
            map.remove(removeNode.key);
        }
    }

    // doubly linked list
    private class Node{
        int key,val;
        Node prev,next;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    private void update(Node node){
        remove(node);
        add(node);
    }

    private void remove(Node node){
        Node prevNode=node.prev,nextNode=node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void add(Node node){
        // add new node in tail
        Node tailPrev=tail.prev;
        tail.prev=node;
        node.next=tail;
        tailPrev.next=node;
        node.prev=tailPrev;
    }
}
