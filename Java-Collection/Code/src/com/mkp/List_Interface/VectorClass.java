package src.com.mkp.List_Interface;

import java.util.List;
import java.util.Vector;

public class VectorClass {
    public static void main(String[] args) {
        List<Integer> list=new Vector<>(2);
        System.out.println(list.size());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
