package com.game.maang.recursion;

public class IsSortedArray {
    public static boolean isSorted(int[] a,int n){
        if(n == 2) return a[n-1] > a[n-2];
        return a[n-1]>a[n-2]?isSorted(a,n-1):false;
    }
    public static void main(String[] args){
        int[] a = {1,5,7,9,12};
        System.out.println("Array is sorted:"+(isSorted(a,a.length)?"Yes":"No"));
    }
}
