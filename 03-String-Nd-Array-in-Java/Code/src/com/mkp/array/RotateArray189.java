package src.com.mkp.array;

import java.util.Arrays;

public class RotateArray189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
//        rotate(nums,k);
        rotateV2(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotateV2(int[] nums, int k) {
        int n=nums.length;
        //  Since rotating an array by its size or multiples of its size results in the same array, it is
        //  unnecessary to perform redundant rotations. The purpose of k = k % n is to ensure that k is
        //  within the range of valid rotations.
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


//    brute force.
    public static void rotate(int[] nums, int k) {
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
