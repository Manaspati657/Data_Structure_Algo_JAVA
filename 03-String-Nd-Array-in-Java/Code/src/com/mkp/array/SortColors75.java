package src.com.mkp.array;

import java.util.Arrays;

public class SortColors75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColorsV2(nums);
        System.out.println(Arrays.toString(nums));
    }

//    counting sort approach : count the occurrences of 0's , 1's and 2's and store it from start to end.
    public static void sortColors(int[] nums) {
        int count0=0,count1=0,count2=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]== 0) count0++;
            else if(nums[i]== 1) count1++;
            else if(nums[i]== 2) count2++;
        }

        int i = 0;
        while (count0 > 0){
            nums[i++]=0;
            count0--;
        }
        while (count1 > 0){
            nums[i++]=1;
            count1--;
        }

        while (count2 > 0){
            nums[i++]=2;
            count2--;
        }

    }

//    Dutch national flag solution: take 3 pointer and if you find 0 then set it to the front and if you
//    find 2 then set it to the end and 1 will automatically set.
    public static void sortColorsV2(int[] nums) {
        int s=0,m=0,e=nums.length-1;
        while(m <= e){
            if(nums[m] == 0){
                swap(nums,s,m);
                m++;
                s++;
            }else if(nums[m] == 2 ){
                swap(nums,m,e);
                e--;
            }else if(nums[m] == 1){
                m++;
            }
        }

    }

    public static void swap(int[] arr,int i , int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
