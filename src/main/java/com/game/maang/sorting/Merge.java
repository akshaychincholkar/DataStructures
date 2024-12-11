package com.game.maang.sorting;

public class Merge {
    public static void sort(int[] a){

    }
    public static void merge(int[] arr,int i,int j){
        int n = arr.length;
        int n1 = n - i -1;
        int n2 = j-i;

        int[] a = new int[n1];
        int[] b = new int[n2];
        int[] c = new int[n];

    }
    public static void display(int[] a){
        for(int element: a) System.out.print(element+"|");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] a={5,4,1,3,2};
        display(a);
        sort(a);
        display(a);
    }
}
