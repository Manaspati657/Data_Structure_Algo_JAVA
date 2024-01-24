package src.com.mkp.v1.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays349 {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6};
        int b[] = {3, 4, 5, 6, 7};

        System.out.println(Arrays.toString(intersection(a, b)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> al=new ArrayList<>();

        Set<Integer> setA=new HashSet<>();
        Set<Integer> setB=new HashSet<>();

        for(int i = 0;i < nums1.length || i< nums2.length;i++){
            if(i<nums1.length) setA.add(nums1[i]);
            if(i<nums2.length) setB.add(nums2[i]);
        }

        for(Integer element: setA)
            if(setB.contains(element)) al.add(element);

        int[] ans=new int[al.size()];
        for(int i=0;i<ans.length;i++)
            ans[i]=al.get(i);
        return ans;
    }
}
