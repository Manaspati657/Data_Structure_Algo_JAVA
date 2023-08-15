package src.com.mkp.theory_stack;

import java.util.Arrays;
import java.util.StringJoiner;

public class Stack_Array<T> {

    private T[] list;

    private Integer ptr=-1;

    public Stack_Array() {
        this.list=(T[])new Object[5];
    }
    public Stack_Array(int size) {
        this.list=(T[])new Object[size];
    }

    public boolean isEmpty(){
        return ptr==-1;
    }

    public Integer size(){
        return ptr+1;
    }

    public void push(T item ){
        if(size() == list.length) resize(list.length*2);
        list[++ptr]=item;

    }

    private void resize(int length) {
        T[] newArray=(T[]) new Object[length];
        for (int i = 0; i <= ptr; i++) {
            newArray[i] = list[i];
        }
        list=newArray;
    }

    public T pop(){
        if(isEmpty()) return null;
        T item=list[ptr];
        list[ptr--]=null;
        if(ptr > -1 && ptr == list.length/4) resize(list.length/2);
//        System.out.println(Arrays.toString(list));
        return item;
    }

    public T peek(){
        if(isEmpty()) return null;
        return list[ptr];
    }

    @Override
    public String toString() {
        StringJoiner items=new StringJoiner(" <- ","[","]");
        for (T t : list) {
            if (t == null) break;
            items.add(t.toString());
        }
        return items.toString();
    }
}
