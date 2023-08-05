package src.com.mkp.Set_Interface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetArrayProblems {
    public static void main(String[] args) {

        Set<Integer> s1 = new HashSet<>(List.of(new Integer[]{1, 3, 2, 4, 8, 9, 0}));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(new Integer[]{1, 3, 7, 5, 4, 0, 7, 5}));

        System.out.println(s1);
        System.out.println(s2);

//        Union --merge two array but no duplicates
        Set<Integer> union=new HashSet<>(s1);
        union.addAll(s2);
        System.out.println("Union of two Set :: ");
        System.out.println(union);

//        Intersection --merge two array but only common in those are output

        Set<Integer> inter=new HashSet<>(s1);
        inter.retainAll(s2);
        System.out.println("Intersection of two Set :: ");
        System.out.println(inter);

//        Difference -- only available in array 1
        Set<Integer> differ=new HashSet<>(s1);
        differ.removeAll(s2);
        System.out.println("Difference of two Set :: ");
        System.out.println(differ);

    }
}
