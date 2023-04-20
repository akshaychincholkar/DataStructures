package com.game.ds.arrays;

public class ReverseArrayFromIndex {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        for (int element : a) System.out.print(element + "\t");
        reverseArray(a,2);
        System.out.println("after reverse:");
        for (int element : a) System.out.print(element + "\t");
    }

    private static void reverseArray(int[] a, int index) {
        int s = index , e = a.length-1;
        while(s<e){
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }
}
