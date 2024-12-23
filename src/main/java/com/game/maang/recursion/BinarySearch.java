package com.game.maang.recursion;

public class BinarySearch{
    public static boolean search(int[] a,int l, int r,int value){
        if(r<l) return false;
        int m = (l+r)/2;
        if(a[m] == value) return true;
        if(value < a[m]) return search(a,l,m-1,value);
        else return search(a,m+1,r,value);
    }
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int value = 2;
        System.out.println("The value "+value+" is "+(search(a,0,a.length-1,value)?"present":"absent"));
        value = 12;
        System.out.println("The value "+value+" is "+(search(a,0,a.length-1,value)?"present":"absent"));
    }
}
