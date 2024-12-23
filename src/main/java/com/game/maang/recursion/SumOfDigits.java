package com.game.maang.recursion;

public class SumOfDigits {
    public static int getDigitsSum(int n){
        if(n<10) return n;
        return getDigitsSum(n/10)+n%10;
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Sum of "+n+" digits is "+getDigitsSum(n));
    }

}
