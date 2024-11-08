package com.game.maang.arrays;

class Rotate{
    public static void rotate(int[] a,int r){
        if(a.length<=1) return;
        r =r % a.length ;
        reverse(a,0,a.length-1);
        reverse(a,0,r-1);
        reverse(a,r,a.length-1);
    }
    public static void reverse(int[] a,int i, int j){
        while(i<j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
    public static void display(int[] a){
        System.out.println();
        for(int i=0;i<a.length;i++) System.out.print(a[i]+" |");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {5,4,1,3,2};
        display(a);
        rotate(a,2);
        display(a);
    }
}
