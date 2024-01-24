package src.com.mkp.array.v2.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RearrangeArrayElementsBySign2149 {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }


    /*
    *  approach : without extra space - take 2 pointer for positive and negative. positive starts with 0 and
    *             negative starts with 1. Start iterating the array, when a positive number find then add it
    *             with ans and increment positive by 2 and same for negative.
    *            Time complexity : O(N) , Space Complexity : O(N).
    * */
    public static int[] rearrangeArray(int[] nums) {
        int l=nums.length,p=0,n=1;
        int[] ans=new int[l];
        for(int i=0;i<l;i++){
            if(nums[i] > 0){
                ans[p]=nums[i];
                p+=2;
            }
            else{
                ans[n]=nums[i];
                n+=2;
            }
        }
        return ans;
    }
    /*
    *
    *    approach : with extra space - use queue data structure for storing positive and negative numbers.
    *               choose queue because of order of elements also matter. then just iterate through the array
    *               and 0,2,4 ... indexes are for positive and other for negative .
    *               Time complexity : O(2N) , Space Complexity : O(3N).
    *
    * */

    public static int[] rearrangeArrayV1(int[] nums) {
        Queue<Integer> positive=new LinkedList<>();
        Queue<Integer> negative=new LinkedList<>();
//      storing elements in queue . TC : O(N)
        for(int i=0;i < nums.length;i++){
            if(nums[i] < 0) negative.add(nums[i]);
            if(nums[i] > 0) positive.add(nums[i]);
        }
        int[] ans=new int[nums.length];
//      fill the ans array positive first then negative. TC : O(N)
        for(int i=0;i < nums.length;i++){
            if(i%2 == 0){
                ans[i]=positive.remove();
            }else{
                ans[i]=negative.remove();
            }
        }
        return ans;
    }

}
