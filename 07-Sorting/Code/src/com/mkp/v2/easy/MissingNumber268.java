package src.com.mkp.v2.easy;

public class MissingNumber268 {



//    if we subtract total array sum from 1 to n sum then we find the missing number.
    public int missingNumberV2(int[] nums) {
        int n = nums.length,sum=0;
        for(int el:nums)
            sum+=el;
        return ((n*(n+1))/2) - sum;
    }


    //    using cyclic sort approach
    public int missingNumber(int[] nums) {
        // circular sort
        int i = 0, n = nums.length;
        while (i < n) {
            int correct = nums[i];
            if (correct < n && nums[i] != nums[correct]) {
                // swap i and correct;
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
        // array is Sorted now
        i = 0;
        while (i < nums.length) {
            if (nums[i] != i) return i;
            else i++;
        }


        return nums.length;
    }
}
