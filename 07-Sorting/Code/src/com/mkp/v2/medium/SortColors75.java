package src.com.mkp.v2.medium;

public class SortColors75 {

    //    Dutch national flag algorithm
    public void sortColorsV2(int[] nums) {
        int l = 0, m = 0, h = nums.length - 1;
        while (m <= h) {
            if (nums[m] == 0) {
                swap(nums, l, m);
                l++;
                m++;
            } else if (nums[m] == 1) {
                m++;
            } else {
                swap(nums, m, h);
                h--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //    count 0,1,2 and then put them in array
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int el : nums) {
            if (el == 0) count0++;
            else if (el == 1) count1++;
            else count2++;
        }
        int i = 0;
        while (count0-- != 0) nums[i++] = 0;
        while (count1-- != 0) nums[i++] = 1;
        while (count2-- != 0) nums[i++] = 2;
    }
}

