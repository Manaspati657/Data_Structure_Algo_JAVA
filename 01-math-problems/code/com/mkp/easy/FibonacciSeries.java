package com.mkp.easy;

public class FibonacciSeries {
    public static void main(String[] args) {
        fibonacciSeries(10);
    }

    public static void fibonacciSeries(int n ){
        int n1=0,n2=1,n3,i=2;
        System.out.print(n1+" "+n2);
        while(i++ < n){
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
    }
}
