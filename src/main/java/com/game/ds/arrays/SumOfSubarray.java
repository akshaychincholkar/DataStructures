package com.game.ds.arrays;

public class SumOfSubarray {
    public static void main(String[] args) {
        int[] a = {1,4,20,3,10,5};
        int sum = 15;
        printSubArrayWithSum(a,sum);
    }

    private static void printSubArrayWithSum(int[] a, int sum) {
        if(a[0] == sum) System.out.println("Sub array:"+a[0]);
        int i=0,j=1;
        int cSum = a[i] ;
        while (cSum != sum && j < a.length) {
            if (cSum < sum) {
                cSum += a[j];
                j++;
            } else {
                cSum-=a[i];
                i++;
            }
        }
        System.out.println("From "+(i+1)+" to "+(j));
        while (i+1 <= j) {
            System.out.println(a[i]);
            i++;
        }
    }
}
