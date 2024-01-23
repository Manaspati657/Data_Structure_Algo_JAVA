package src.com.mkp.array.easy;

import java.util.Arrays;

public class PlusOne66 {
    public static void main(String[] args) {
        // int[] digit={9,8,9};
        int[] digit={9,9,9};
        // int[] digit={9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(plusOne(digit)));
    }

    public static int[] plusOne(int[] digits) {
        int n=digits.length ;
        // in this iteration we check if a number is less than 9 or not if yes then just add 1 to add
        // it will not two digit so no issue after that just return it if the digit is 9 then we add 0
        // in that place and continue if every digit is 9 then all digits array elements will be 0,
        // and we need to add 1 in front of the array.

        for (int i = n-1; i >= 0; i--) {
            if(digits[i] < 9){
                digits[i]=digits[i]+1;
                return digits;
            }
            digits[i]=0;
        }

        int[] ans=new int[n+1];
        ans[0]=1;
        return ans;
    }



    // Brute force approach if constraint range store in int or long then this solution work.
    public static int[] plusOneV1(int[] digits) {
        int sum = 0,n=digits.length ;
        for (int i = 0; i < n; i++) {
            sum = (sum*10)+digits[i];
        }
        sum=sum+1;
        int l = (digitsCount(sum) == n) ? n : n+1 ;
        int[] ans=new int[l];
        for (int i = l-1; i >= 0; i--) {
            int rem=sum%10;
            ans[i]=rem;
            sum/=10;
        }
        return ans;
    }

    public static int digitsCount(int num){
        int count=0;
        while(num > 0){
            count++;
            num/=10;
        }
        return count;
    }
}
