package src.com.mkp.array.v2.medium;

import java.util.Arrays;

public class RotateArray189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
//        rotateV1(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    /*
    *    optimize approach: Reverse entire array then revere k before all element and then reverse k after
    *                       all element.
    *    Note :: k = k % n ; Since rotating an array by its size or multiples of its size results in the
    *                        same array, it is unnecessary to perform redundant rotations. The purpose of
    *                        k = k % n is to ensure that k is within the range of valid rotations.
    *                        e.g. if n = 6 , k = 8 then only we need to rotate 8 % 6 = 2 times because rotating
    *                        n times array itself is the result.
    *    Time Complexity : O(2N).
    * */

    public static void rotate(int[] nums, int k) {
        int n=nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }


//    rotate array from i to j index
    public static void reverse(int[] arr,int i ,int j){
        while(i < j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;
            i++;
        }
    }

    /*
    *   Brute force approach: Store the last index element in a variable(lastElement) then move every
    *                         element 1 step in forward direction and after moving every element,
    *                         set the first element to the lastElement. After every iteration array also rotate
    *                         so if we iterate k times array also rotate k times.
    *                         Time complexity : O(k*N).
    *
    * */

    public static void rotateV1(int[] nums, int k) {
        int lastIndex=nums.length-1;
        for (int i = 0; i < k; i++) {
            int last=nums[lastIndex];
            for (int j = lastIndex; j > 0 ; j--) {
                nums[j]=nums[j-1];
            }
            nums[0]=last;
        }
    }
}
