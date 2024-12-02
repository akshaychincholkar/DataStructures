package com.game.maang.sorting;

public class Selection {
    public static void sort(int[] a){
        for(int i=0;i<a.length-1;i++){
            int smallest = i;
            int j = i+1;
            for(;j<a.length;j++){
                if(a[smallest]>a[j])smallest = j;
            }
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
        }
    }
    public static void display(int[] a){
        for(int element:a) System.out.print(element+"|");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a={5,4,1,3,2};
        display(a);
        sort(a);
        display(a);
    }
}
