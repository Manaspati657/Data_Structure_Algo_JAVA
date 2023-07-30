package com.mkp.easy;

public class FactorialOfNumber {
    public static void main(String[] args) {
        System.out.println("Factorial of 5 :: "+getFactorial(5));
    }

    public static int getFactorial(int n){
        int sum=1;
        while(n>0) sum*=n--;
        return sum;
    }
}
