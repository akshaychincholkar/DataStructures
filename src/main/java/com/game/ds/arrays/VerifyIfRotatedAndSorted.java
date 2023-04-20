package com.game.ds.arrays;

public class VerifyIfRotatedAndSorted {
    public static void main(String[] args) {
//        int[] a = {2,3,4,5,1};
        int[] a = {1,2,3,4,5};
        System.out.println("Is rotated and sorted: "+isRotatedAndSorted(a));
    }

    private static boolean isRotatedAndSorted(int[] a) {
        int count = 0;
        for(int i = 1;i<a.length;i++){
            if(a[i-1]>a[i])count++;
        }
        if(a[a.length-1] > a[0]) count++;
        return count == 1;
    }
}
