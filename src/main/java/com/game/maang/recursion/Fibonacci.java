package com.game.maang.recursion;

public class Fibonacci {
    public static void fibonacci(int a,int b,int n){
        if(n==0)return;
        int c = a +b;
        System.out.print(c+"\t");
        fibonacci(b,c,n-1);
    }

    public static int fibonacci_v2(int n){
        if(n<=1){
            return n;
        }
        return fibonacci_v2(n-2)+fibonacci_v2(n-1);
    }
    public static void main(String[] args) {
        fibonacci(0,1,5);
        System.out.println();
        for(int i=0;i<=5;i++){
            System.out.print(fibonacci_v2(i)+"\t");
        }
    }
}
