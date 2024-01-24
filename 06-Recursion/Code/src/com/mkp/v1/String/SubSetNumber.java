package src.com.mkp.v1.String;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetNumber {
    public static void main(String[] args) {
//        int[] arr={1,2,3};
//        System.out.println(subSet(arr));
        int[] arr={1,2,2};
        System.out.println(subSetDuplicates(arr));
    }

    private static ArrayList<ArrayList<Integer>> subSetDuplicates(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        int s=0,e=0;
        for (int i = 0; i < arr.length; i++) {
            s = 0;
            // if current and previous element is same, s = e + 1
            if (i > 0 && arr[i] == arr[i-1]) {
                s = e + 1;
            }
            e = ans.size() - 1;
            int n = ans.size();
            for (int j = s; j < n; j++) {
                ArrayList<Integer> subAns=new ArrayList<>(ans.get(j));
                subAns.add(arr[i]);
                ans.add(subAns);
            }
        }
        return ans;
    }

    private static ArrayList<ArrayList<Integer>> subSet(int[] arr) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        for (int num : arr) {
            int n=ans.size();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> subAns=new ArrayList<>(ans.get(j));
                subAns.add(num);
                ans.add(subAns);
            }
        }

        return ans;
    }
}
