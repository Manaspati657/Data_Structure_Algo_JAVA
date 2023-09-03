package src.com.mkp.theory;

import java.util.StringJoiner;

/*
*       Time complexity : insert-O(1) , deleteMax and getMax - O(N) (finding max with N iteration loop)
*
*
* */


public class UnorderedMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private Integer ptr=-1;

    public UnorderedMaxPQ(Integer size) {
        pq=(Key[]) new Comparable[size];
    }
    public UnorderedMaxPQ() {
        pq=(Key[]) new Comparable[5];
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    public void insert(Key item){
        if(ptr == pq.length-1) resize(pq.length*2);
        pq[++ptr]=item;
    }


    private void resize(int length) {
        Key[] newArray=(Key[]) new Comparable[length];
        for (int i = 0; i <= ptr; i++) {
            newArray[i] = pq[i];
        }
        pq=newArray;
    }

    public Key getMax(){
        int max=0;
        if(!isEmpty()){
            for (int i = 1; i <= ptr; i++){
                if(less(i,max)) max=i;
            }
        }
        return pq[max];
    }

    public Key deleteMax(){
        int max=0;
        Key deleteItem=null;
        if(!isEmpty()){
            for (int i = 1; i <= ptr; i++){
                if(less(i,max)) max=i;
            }
            deleteItem=pq[max];
            exch(pq,max,ptr);
            pq[ptr--]=null;
            if(ptr > -1 && ptr == pq.length/4) resize(pq.length/2);
        }
        return deleteItem;
    }


    private boolean less(int key, int max) {
        return pq[key].compareTo(pq[max]) > 0;
    }

    private static void exch(Comparable[] a , int i ,int j){
        Comparable swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }

    @Override
    public String toString() {
        StringJoiner items=new StringJoiner(", ","[","]");
        for (Key t : pq) {
            if (t == null) break;
            items.add(t.toString());
        }
        return items.toString();
    }
}
