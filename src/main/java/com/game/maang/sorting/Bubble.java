package com.game.maang.sorting;

public class Bubble {
    public static void sort(int[] a){
        for(int i=0;i<a.length-1;i++){
            boolean isSorted = true;
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted)return;
        }
    }
    public static void display(int[] a){
        for(int element:a) System.out.print(element+"|");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] a = {5,4,1,3,2};
        display(a);
        sort(a);
        display(a);
    }
}
