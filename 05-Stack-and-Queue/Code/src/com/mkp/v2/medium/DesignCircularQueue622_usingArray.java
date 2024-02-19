package src.com.mkp.v2.medium;

public class DesignCircularQueue622_usingArray {

    /*
    * using an array :
    * */
    private int q[],maxSize,head=0,tail=-1;

    public DesignCircularQueue622_usingArray(int k) {
        q=new int[k];
        maxSize=k;
    }

    public boolean enQueue(int value) {
        if(isFull())
            return false;
        //basically this will change the tail to again 0 while tail will be the last index in array.
        tail = (tail + 1) % maxSize;
        q[tail]=value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;

        if(head == tail){
            head=0;
            tail=-1;
        }else{
            head=(head+1)%maxSize;
        }
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[tail];
    }

    public boolean isEmpty() {
        return tail == -1;
    }

    public boolean isFull() {
        return !isEmpty() && (tail+1) % maxSize == head;
    }
}
