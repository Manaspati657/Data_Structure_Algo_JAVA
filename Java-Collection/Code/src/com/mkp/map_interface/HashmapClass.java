package src.com.mkp.map_interface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashmapClass {

    public static void main(String[] args) {

        Map<Integer,String> map=new HashMap<>();

        map.put(1,"mkp");
        map.put(3,"mp");
        map.put(5,"kp");
        System.out.println(map);

        for (Map.Entry<Integer,String> e:map.entrySet()) {
            System.out.print(e.getKey()+"  ->  ");
            System.out.print(e.getValue()+"\n");
        }
    }
}
