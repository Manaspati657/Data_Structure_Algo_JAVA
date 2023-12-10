package src.com.mkp.AdityaVerma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort_Recursion {
    public static void main(String[] args) {
        Integer[] arr={4,2,5,1,6,0,8};
        List<Integer> list= new ArrayList<>(Arrays.asList(arr));
        System.out.println(list);
        sort(list);
        System.out.println(list);
    }

    private static void sort(List<Integer> list) {
        if(list.isEmpty()) return;
        Integer temp=list.remove(list.size()-1);
        sort(list);
        insert(list,temp);
    }

    private static void insert(List<Integer> list, Integer no) {
        if(list.isEmpty() || list.get(list.size()-1) <= no){
            list.add(no);
            return;
        }
        Integer temp=list.remove(list.size()-1);
        insert(list,no);
        list.add(temp);
    }
}
