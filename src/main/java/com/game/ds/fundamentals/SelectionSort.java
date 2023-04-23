package com.game.ds.fundamentals;

public class SelectionSort{
    public static void main(String[] args){
        int[] a = {5,1,2,4,3};
        for(int n:a)System.out.print(n+" ");
        sort(a);
        System.out.println("After sort");
        for(int n:a)System.out.print(n+" ");
    }
    public static void sort(int[] a){
        for(int i = 0 ;i<a.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j<a.length ; j++){
                if(a[j]<a[minIndex]){
                    minIndex =j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }
}

