package com.game.ds.fundamentals;

public class BinarySearchRecursive {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Binary Search for 2: "+solve(a,2,0,a.length-1));
    }
    public static int solve(int[] a, int value,int s, int e){
        if(s>e) return -1;
        int mid = (s + e) / 2;
        if(a[mid] == value) return mid;
        if(value < a[mid]) return solve(a,value,s,mid-1);
        else return solve(a,value,mid+1,e);
    }

}
