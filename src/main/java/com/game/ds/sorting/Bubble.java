package com.game.ds.sorting;

public class Bubble {
    static void sort(int[] a){
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
    }
    public static void main(String args[]){
        System.out.println("Bubble sort program");
        int[] a ={5,4,3,2,1};
        for(int i:a) System.out.println(i);
        sort(a);
        System.out.println("After sorting");
        for(int i:a) System.out.println(i);
    }
}
