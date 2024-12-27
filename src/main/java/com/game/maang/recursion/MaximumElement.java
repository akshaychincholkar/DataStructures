package com.game.maang.recursion;

public class MaximumElement{
    public static int getMaxElement(int[] a,int n){
        if(n==1) return a[n-1];
        int max = getMaxElement(a,n-1);
        return max<a[n-1]?a[n-1]:max;
    }
    public static void main(String[] args){
        int[] a = {4,1,5,2,3};;
        System.out.println("Maximum element is "+getMaxElement(a,a.length));
    }
}
