package com.game.maang.sorting;

public class Insertion {
    public static void sort(int[] a){
        for(int i = 1 ;i < a.length ; i++){
            int j = i;
            int element = a[i];
            for(;j>0 && element <a[j-1];j--){
                a[j] = a[j-1];
            }
            a[j] = element;
        }
    }

    public static void display(int[] a){
        for(int element:a) System.out.print(element+"|");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] a= {3,5,7,9,4};
        display(a);
        sort(a);
        display(a);
    }
}
