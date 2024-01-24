package src.com.mkp.array.v2.easy;

import java.util.Arrays;

public class ShuffleTheArray1470 {


    /*
    *   Important : using technique to store two values at same index (this technique is important)
    *
    * */
    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int n = 3 ;
        System.out.println(Arrays.toString(shuffle(nums, n)));
    }

    /*
     *   optimize approach : using technique to store two values at same index
     *   Example - Lets say we have two numbers in the array a = 1 , b = 3 and the size of
     *             the array is n = 5
     *             We can store both in "a" as :-
     *             a = a + b * n
     *             To get initial value of "a" do a%n
     *             To get the value of "b" we do a/n
     *             a = a + b * n = 1 + 3*5 = 16
     *             a % n = 16 % 5 = 1
     *             a / n = 16 / 5 = 3
     *
     * */

    public static int[] shuffle(int[] nums, int n) {
        int l=nums.length;

        for (int i = n; i < l; i++) {
            nums[i]= nums[i]+((nums[i-n])*1024);
        }

        for (int k = n,i=0; k < l;k++,i+=2) {
            nums[i]=nums[k]/1024;
            nums[i+1]=nums[k]%1024;
        }

        return nums;
    }



    /*
    *
    *  Brute force approach :  time and space complexity : O(N).
    *
    * */

    public static int[] shuffleV1(int[] nums, int n) {
        int[] ans=new int[n*2];
        int i=0,j=n,k=0;
        while (k < n*2) {
            ans[k++]=nums[i++];
            ans[k++]=nums[j++];
        }
        return ans;
    }
}
