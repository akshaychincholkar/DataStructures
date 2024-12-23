package com.game.maang.recursion;

public class PowerOfNumber {
    public static int getPower(int n, int p){
        if(p==1) return n;
        return getPower(n,p-1)*n;
    }
    public static void main(String[] args){
        int n = 2, p = 10;
        System.out.println(n+" to the power "+p+" is "+getPower(n,p));
    }
}
