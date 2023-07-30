package com.mkp.easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println("is Palindrome 1225221 :: "+isPalindrome(1225221));
    }

    public static boolean isPalindrome(int no ){
        if(no == 0 ) return true;
        else {
            int temp = no , rev =0,rem;
            while (no >0){
                rem=no %10;
                rev=rev*10+rem;
                no/=10;
            }
            if(temp==rev) return true;
        }

        return false;
    }
}
