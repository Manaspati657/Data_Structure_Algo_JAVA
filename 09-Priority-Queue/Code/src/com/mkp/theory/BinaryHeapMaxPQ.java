package src.com.mkp.theory;

import java.util.StringJoiner;


/*
*
*       Time complexity : insert-O(logN) , deleteMax -O(logN)  and getMax - O(1)
*       logN is the height of the tree (Height only increases when N is a power of 2.)
*
*
* */

public class BinaryHeapMaxPQ<Key extends Comparable<Key>>  {

    private Key[] pq;
    private Integer ptr=0;

    public BinaryHeapMaxPQ(int size) {
        pq=(Key[]) new Comparable[size];
    }

    public BinaryHeapMaxPQ() {
        pq=(Key[]) new Comparable[10];
    }

    public boolean isEmpty(){
        return ptr==0;
    }

    public void insert(Key item){
        if(ptr == pq.length-1) resize(pq.length*2);
        pq[++ptr]=item;
        swim(ptr);
    }

    private void swim(int k) {
        while(k > 1 && less(k/2,k)){
            exch(pq,k/2,k);
            k=k/2;
        }
    }

    public Key deleteMax(){
        Key max=null;
        if(!isEmpty()){
            max=pq[1];
            exch(pq,1,ptr);
            pq[ptr--]=null;
            sink(1);
            if(ptr > -1 && ptr == pq.length/4) resize(pq.length/2);
        }
        return max;
    }

    private void sink(int k) {
        while(2*k < ptr){
            int child1=2*k;
            int child2=2*k+1;
            if(child1 < ptr && less(child1,child2)) child1++;
            if(!less(k,child1)) break;
            exch(pq,k,child1);
            k=child1;
        }
    }

//    Time complexity is O(NlogN)
    public void sort(){
        if(!isEmpty()){
            int tempPtr=ptr;
            while(tempPtr > 2){
                exch(pq,1,tempPtr--);
                sinkSort(1,tempPtr);
            }
        }
    }

    private void sinkSort(int k, int tempPtr) {
        while(2*k < tempPtr){
            int child1=2*k;
            int child2=2*k+1;
            if(child1 < tempPtr && less(child1,child2)) child1++;
            if(!less(k,child1)) break;
            exch(pq,k,child1);
            k=child1;
        }
    }

    public void convertMaxPQ(){
        int tempPtr=ptr;
        while(tempPtr > 0){
            swim(ptr);
            tempPtr--;
        }
    }

    public Key getMax(){
        return pq[1];
    }

    private void resize(int length) {
        Key[] newArray=(Key[]) new Comparable[length];
        for (int i = 0; i <= ptr; i++) {
            newArray[i] = pq[i];
        }
        pq=newArray;
    }


    private boolean less(int p, int c) {
//        System.out.println(pq[p]+"-"+pq[c]);
        return pq[p].compareTo(pq[c]) < 0;
    }

    private static void exch(Comparable[] a , int i ,int j){
        Comparable swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }

    @Override
    public String toString() {
//        StringJoiner items=new StringJoiner(", ","[","]");
//        for (int i =1 ; i <=ptr; i++) {
//            items.add(pq[i].toString());
//        }
//        return items.toString();

//        print like a binary tree
        int counter = 1;
        for (int i = 1; i <= ptr; i++) {
            int space=ptr-counter;
            while( space > 0 ){
                System.out.print(" ");
                space--;
            }
            System.out.print(pq[i]+" ");
            if(i == counter) {
                System.out.println();
                counter=2*i+1;
            }
        }
        return "";
    }

}
