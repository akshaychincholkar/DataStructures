package com.game.maang.arrays;

public class ReverseArray {
    public static int[] reverse(int[] a){
        for(int i=0;i<a.length/2;i++){
            int temp = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = temp;
        }
        return a;
    }
    public static void display(int[] a){
        for(int i=0;i<a.length;i++) System.out.print(a[i]+"  |");
    }
    public static void main(String[] args) {
        int[] a={5,4,1,3,2};
        display(a);
        System.out.println();
        display(reverse(a));
        int[] b={5,4,1,3,2,9};
        System.out.println();
        display(b);
        System.out.println();
        display(reverse(b));
     }
}
