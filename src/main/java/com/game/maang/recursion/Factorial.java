package com.game.maang.recursion;

public class Factorial {
    public static int dofactorial(int n){
        if(n == 1) return n;
        return dofactorial(n-1)*n;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of "+n+" is "+dofactorial(n));
    }
}
