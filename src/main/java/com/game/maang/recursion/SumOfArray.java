package com.game.maang.recursion;

public class SumOfArray{
    public static int getSum(int[] a, int n,int sum){
        if(n==1)return sum+a[n-1];
        return getSum(a,n-1,sum)+a[n-1];
    }
    public static void main(String[] args){
        int[] a = {5,4,1,3,2};
        System.out.println("Sum of all the elements in an array is "+getSum(a,a.length,0));
    }
}