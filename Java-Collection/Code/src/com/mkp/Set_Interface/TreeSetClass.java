package src.com.mkp.Set_Interface;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetClass {
    public static void main(String[] args) {
        SortedSet<String> set=new TreeSet<>();

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
