package src.com.mkp.array.v2.easy;

public class FindNumbersWithEvenNumberOfDigits1295 {
    public static void main(String[] args) {
        int[] nums = {12,345,24,6,7896};
        System.out.println(findNumbers(nums));
    }


    /*
    *
    *  Brute force approach : TC O ( N * ( digit length ))
    *
    * */


    public static int findNumbers(int[] nums) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
//            if(getDigits(nums[i]) % 2 == 0 ) count++;
//            for optimization use formula to get the digit of a number if we get the log of n base 2 and add
//             1 to it then we get the number of digit.
            if(digits2(nums[i]) % 2 == 0 ) count++;
        }
        return count;
    }

    private static int digits2(int no) {
        if(no < 0) no*=-1;
        return (int)(Math.log10(no)) + 1;
    }


    public static int getDigits(int num){
        int count=0;
        if(num < 10) return 1;
        while(num > 0){
            count++;
            num/=10;
        }
        return count;
    }
}
