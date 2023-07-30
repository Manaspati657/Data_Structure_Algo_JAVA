package com.mkp.easy;

public class FibonacciNthNumber {

    public static void main(String[] args) {
        System.out.println("fibonacci series 10th no :: "+getFibonacciNth(10));
    }

    public static int getFibonacciNth(int no ){
        int n1=0,n2=1,n3,i=2;
        if(no == 1) return n1;
        else if(no ==2) return n2;
        else while(i++ < no){
            n3=n1+n2;
            if(i==no) return n3;
            n1=n2;
            n2=n3;
        }
        return -1;
    }

}
