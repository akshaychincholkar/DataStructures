package com.game.ds.math;

public class Fibonacci {
    public static void main(String args[]){
        System.out.println("Fibonacci program: ");
        printFibonacci(10);
    }
    public static void printFibonacci(int value){
        int n1 = 0 , n2 = 1;
        int n3 = 0;
        while(n3<value){
            System.out.println(n3);
            n3 = n1 + n2;
            n1 = n2;
            n2=n3;
        }
    }
}
