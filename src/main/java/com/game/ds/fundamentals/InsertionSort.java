package com.game.ds.fundamentals;

public class InsertionSort{
    public static void main(String[] args){
        int[] a = {5,1,2,4,3};
        for(int n:a)System.out.print(n+" ");
        sort(a);
        System.out.println("After sort");
        for(int n:a)System.out.print(n+" ");
    }
    public static void sort(int[] a){
        for(int i = 1 ;i<a.length;i++){
            int key = a[i];
            int j;
            for(j = i-1;j>=0 && key<a[j];j--){
                a[j+1] = a[j];
            }
            a[j+1] = key;
        }
    }
}

