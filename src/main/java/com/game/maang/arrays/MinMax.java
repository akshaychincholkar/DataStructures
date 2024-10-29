package com.game.maang.arrays;

public class MinMax {
    public static int minimum(int[] a){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(min > a[i]) min = a[i];
        }
        return min;
    }
    public static int maximum(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(max<a[i]) max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {5,4,1,3,2};
        System.out.println("Minimum :"+minimum(a));
        System.out.println("Maximum :"+maximum(a));
    }
}
