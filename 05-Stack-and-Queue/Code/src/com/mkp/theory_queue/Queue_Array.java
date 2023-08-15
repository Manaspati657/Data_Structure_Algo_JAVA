package src.com.mkp.theory_queue;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class Queue_Array<T> {
    private T[] list;
    private Integer head=-1,tail=-1;
    private Integer size;
    Queue_Array(){
        this.list=(T[])new Object[5];
        this.size=0;
    }
    Queue_Array(int length){
        this.list=(T[])new Object[length];
        this.size=0;
    }
    public boolean isEmpty(){return head == -1 && tail == -1;}

    public int size(){return size;}

    public void enqueue(T item){
        if(isEmpty()){
            list[++head]=item;
            tail=head;
        }else{
            if(size+1 == list.length) resize(2 * list.length);
            list[++tail]=item;
        }
//        System.out.println(Arrays.toString(list));
        size++;
    }

    private void resize(int length) {
        T[] newArray=(T[]) new Object[length];
        for (int i = head,j=0; i <= tail; i++,j++) {
            newArray[j] = list[i];
        }
        head=0;
        tail=size-1;
        list=newArray;
    }

    public T dequeue(){
        if(isEmpty()) return null;
        T item = null;
        if(head==tail){
            item=list[head];
            list[head]=null;
            head=tail=-1;
        }else{
            item=list[head];
            list[head++]=null;
        }
        System.out.println(Arrays.toString(list));
        size--;
        if(size > 0 && size==list.length/4) resize(list.length/2);
        return item;
    }

    public T peek(){
        if(isEmpty()) return null;
        return list[head];
    }

    @Override
    public String toString() {
        StringJoiner items=new StringJoiner(" <- ","[","]");
        if(!isEmpty()){
            for (int i = head; i <=tail ; i++) {
                items.add(list[i].toString());
            }
        }
        return items.toString();
    }
}

















