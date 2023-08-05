package src.com.mkp.Set_Interface;

import java.util.HashSet;
import java.util.Set;

public class HashSetClass {
    public static void main(String[] args) {

        HashSet<String> set=new HashSet<>();

        set.add("mk");
        set.add("amanas");
        set.add("cpati");
        set.add("mk");
        set.add("bmkp ");
//        set.add(5);
//        set.add(2);
//        set.add(3);
//        set.add(6);
        System.out.println(set);
//        System.out.println(set.remove(2));
        System.out.println(set);
    }
}
