package src.com.mkp.AdityaVerma;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame1823 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2));
    }
    public static int findTheWinner(int n, int k) {
        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return helper(0,k-1,list);
    }

    private static int helper(int index, int k,List<Integer> list) {
        if(list.size() == 1 ){
            return list.get(0);
        }
        index = (index+k) % list.size();
        list.remove(index);
        return helper(index,k,list);
    }

}
