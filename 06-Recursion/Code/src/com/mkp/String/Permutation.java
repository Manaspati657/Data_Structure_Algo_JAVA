package src.com.mkp.String;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
//        permutations("", "abc");

        permWithBackTracking("abc",0);

//        ArrayList<String> ans = permutationsList("", "abc");
//        System.out.println(ans);

//        System.out.println(permutationsCount("", "abcd"));
    }


//    this algorithm not using any extra space like char[] and no backtracking
//    Time complexity: O(N*N!)  // N for loop and N! for no of permutation
//    Space complexity: O(1)
    private static ArrayList<String> permutationsList(String in, String op) {
        if(op.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(in);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i <op.length();i++){
            String remain=op.substring(0,i)+op.substring(i+1);
            list.addAll(permutationsList(in+op.charAt(i),remain));
        }
        return list;
    }

//    this algorithm not using any extra space like char[] and no backtracking
//    Time complexity: O(N*N!)  // N for loop and N! for no of permutation
//    Space complexity: O(1)
    private static int permutationsCount(String in, String op) {
        if(op.isEmpty()){
//            System.out.println(in);
            return 1;
        }
        int count=0;
        for(int i=0;i <op.length();i++){
            String remain=op.substring(0,i)+op.substring(i+1);
            count+=permutationsCount(in+op.charAt(i),remain);
        }
        return count;
    }

//    this algorithm not using any extra space like char[] and no backtracking
//    Time complexity: O(N*N!)  // N for loop and N! for no of permutation
//    Space complexity: O(1)
    private static void permutations(String in, String op) {

        if(op.isEmpty()){
            System.out.println(in);
            return;
        }
        for(int i=0;i <op.length();i++){
            String remain=op.substring(0,i)+op.substring(i+1);
            permutations(in+op.charAt(i),remain);
        }
    }

//    this algorithm using extra space like char[] and using backtracking concept
//    Time complexity: O(N*N!)  // N for loop and N! for no of permutation
//    Space complexity: O(N)
    public static void permWithBackTracking(String str,int l){

        if(l == str.length()-1){
            System.out.println(str);
            return;
        }
        for(int i=l;i < str.length();i++){
            str = swap(str,i,l);
            permWithBackTracking(str,l+1);
            str = swap(str,i,l);
        }
    }
    static String swap(String str,int i ,int j){
        char[] charArr=str.toCharArray();
        char temp=charArr[i];
        charArr[i]=charArr[j];
        charArr[j]=temp;
        return new String(charArr);
    }
}
