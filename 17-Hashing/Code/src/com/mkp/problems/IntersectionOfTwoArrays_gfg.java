package src.com.mkp.problems;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_gfg {
    public static void main(String[] args) {
        int n = 6, m = 5;
        int a[] = {1, 2, 3, 4, 5, 6};
        int b[] = {3, 4, 5, 6, 7};

        System.out.println(numbersOfElementsInIntersection(a,b,n,m));
    }

    public static int numbersOfElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code here
        int count =0;

        // Store both array into a set so that duplicate element will remove
        Set<Integer> setA=new HashSet<>();
        Set<Integer> setB=new HashSet<>();

        for(int i=0;i<n || i<m ;i++){
            if(i < n) setA.add(a[i]);
            if(i < m) setB.add(b[i]);
        }

        // check one set element in another set and if find element increment count
        for(Integer element:setA){
            if(setB.contains(element)) count++;
        }
        return count;
    }
}
